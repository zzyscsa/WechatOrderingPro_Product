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

    /**
     * 查询商品id集合的所有商品信息
     */
    List<ProductInfo> findList(List<String> productIdList);
}
