package com.scsa.product.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * @Author: SCSA
 * @Date: 2020/8/19 22:59
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
