package com.scsa.product.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 商品状态
 * @Author: SCSA
 * @Date: 2020/8/19 22:33
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ProductStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;
    private String message;

}
