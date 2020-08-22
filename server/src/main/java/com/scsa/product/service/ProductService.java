package com.scsa.product.service;

import com.scsa.product.common.DecreaseStockInput;
import com.scsa.product.common.ProductInfoOutPut;
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
    List<ProductInfoOutPut> findList(List<String> productIdList);

    /**
     * 扣减库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
