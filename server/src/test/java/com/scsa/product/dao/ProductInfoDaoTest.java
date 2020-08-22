package com.scsa.product.dao;

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
 * @Date: 2020/8/21 22:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void findByProductIdIn() {
        List<ProductInfo> list = productInfoDao.findByProductIdIn(Arrays.asList("1596464046810459451", "123457"));
        Assert.assertTrue(list.size()>0);
    }
}