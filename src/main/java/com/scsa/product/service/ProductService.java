package com.scsa.product.service;

import com.scsa.product.dataobject.ProductInfo;

import java.util.List;

/**
 * @Author: SCSA
 * @Date: 2020/8/19 22:55
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();
}
