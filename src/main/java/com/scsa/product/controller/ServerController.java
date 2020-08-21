package com.scsa.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单Order服务调用商品Product服务，商品服务属于服务端
 * @Author: SCSA
 * @Date: 2020/8/21 19:24
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String meg() {
        return "this is product' msg ";
    }
}
