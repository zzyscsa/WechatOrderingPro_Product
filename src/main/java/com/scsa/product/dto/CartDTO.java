package com.scsa.product.dto;

import lombok.Data;

/**
 * 购物车
 * @Author: SCSA
 * @Date: 2020/8/21 23:07
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;
}
