package com.scsa.product.dao;

import com.scsa.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: SCSA
 * @Date: 2020/8/19 22:27
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

    /* 查询上架的商品 */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}