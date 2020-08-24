package com.scsa.product.service.impl;

import com.scsa.product.common.DecreaseStockInput;
import com.scsa.product.common.ProductInfoOutPut;
import com.scsa.product.dao.ProductInfoDao;
import com.scsa.product.dataobject.ProductInfo;
import com.scsa.product.enums.ProductStatusEnum;
import com.scsa.product.enums.ResultEnum;
import com.scsa.product.exception.ProductException;
import com.scsa.product.service.ProductService;
import com.scsa.product.util.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author: SCSA
 * @Date: 2020/8/19 22:57
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutPut> findList(List<String> productIdList) {
        // 查询出来的ProductInfo对象转换为ProductInfoOutPut对象
        return productInfoDao.findByProductIdIn(productIdList).stream()
                .map(e-> {
                    ProductInfoOutPut outPut = new ProductInfoOutPut();
                    BeanUtils.copyProperties(e, outPut);
                    return outPut;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = decreaseStockProcess(decreaseStockInputList);

        //扣完库存向订单服务发送MQ消息,发送整个购物车对象，包括很多商品
        List<ProductInfoOutPut> productInfoOutPutList = productInfoList.stream().map(e -> {
            ProductInfoOutPut productInfoOutPut = new ProductInfoOutPut();
            BeanUtils.copyProperties(e, productInfoOutPut);
            return productInfoOutPut;
        }).collect(Collectors.toList());
        amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(productInfoOutPutList));

    }

    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = new ArrayList<>();
        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList) {
            Optional<ProductInfo> productInfoOptional = productInfoDao.findById(decreaseStockInput.getProductId());
            //判斷商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            //判斷庫存是否足夠
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoDao.save(productInfo);

            productInfoList.add(productInfo);
        }
        return productInfoList;
    }
}
