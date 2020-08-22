package com.scsa.product.common;

import lombok.Data;

/**
 * 减库存的入参，不使用order服务里面的对象
 * @Author: SCSA
 * @Date: 2020/8/22 18:46
 */
@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
