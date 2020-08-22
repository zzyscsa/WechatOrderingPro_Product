package com.scsa.product.service;

import com.scsa.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @Author: SCSA
 * @Date: 2020/8/19 22:56
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
