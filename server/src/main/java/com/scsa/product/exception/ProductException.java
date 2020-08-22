package com.scsa.product.exception;

import com.scsa.product.enums.ResultEnum;

/**
 * @Author: SCSA
 * @Date: 2020/8/21 23:12
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
