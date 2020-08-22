package com.scsa.product.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 接口向外提供的字段
 * @Author: SCSA
 * @Date: 2020/8/22 18:34
 */
@Data
public class ProductInfoOutPut {

    private String productId;

    /** 名字 */
    private String productName;

    /** 单价 */
    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 小图地址 */
    private String productIcon;

    /** 状态：0在家1下架；默认在架 */
    private Integer productStatus;

    /** 类目编号 */
    private Integer categoryType;
}
