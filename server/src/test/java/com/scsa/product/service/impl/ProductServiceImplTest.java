package com.scsa.product.service.impl;

import com.scsa.product.common.ProductInfoOutPut;
import com.scsa.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: SCSA
 * @Date: 2020/8/21 22:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findList() {
        List<ProductInfoOutPut> list = productService.findList(Arrays.asList("1596464046810459451", "123457"));
        Assert.assertTrue(list.size()>0);
    }
}