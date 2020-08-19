package com.scsa.product.dao;


import com.scsa.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: SCSA
 * @Date: 2020/8/19 22:30
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

    /* 根据类目类型查询 */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
