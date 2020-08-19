package com.scsa.product.service.impl;

import com.scsa.product.dao.ProductInfoDao;
import com.scsa.product.dataobject.ProductInfo;
import com.scsa.product.enums.ProductStatusEnum;
import com.scsa.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: SCSA
 * @Date: 2020/8/19 22:57
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
