package com.scsa.product.service.impl;

import com.scsa.product.common.DecreaseStockInput;
import com.scsa.product.common.ProductInfoOutPut;
import com.scsa.product.dao.ProductInfoDao;
import com.scsa.product.dataobject.ProductInfo;
import com.scsa.product.enums.ProductStatusEnum;
import com.scsa.product.enums.ResultEnum;
import com.scsa.product.exception.ProductException;
import com.scsa.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        }
    }
}
