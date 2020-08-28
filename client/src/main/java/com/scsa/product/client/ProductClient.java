package com.scsa.product.client;

import com.scsa.product.common.DecreaseStockInput;
import com.scsa.product.common.ProductInfoOutPut;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Product服务提供对外的服务接口,订单服务调用服务接口
 * @Author: SCSA
 * @Date: 2020/8/22 18:55
 */
//表示调用的是哪个应用,Feign接口和Controller对应, fallback表示服务降级对应的类
@FeignClient(name = "product", fallback = ProductClient.ProductClientFallBack.class)
public interface ProductClient {

    /**
     * 获取商品列表（专门给订单服务）
     * @param productIdList
     * @return
     */
    //RequestParam接受的参数在请求头(?参数)，RequestBody接收的参数来自请求体
    // 这传过来的是json字符串，RequestBody可以解析Body中的json格式数据
    @PostMapping("/product/listForOrder") //使用了@RequestBody必须用post!
    List<ProductInfoOutPut> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

    //Hystrix服务降级调用的方法
    @Component
    class ProductClientFallBack implements ProductClient {

        @Override
        public List<ProductInfoOutPut> listForOrder(List<String> productIdList) {
            return null;
        }

        @Override
        public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

        }
    }
}
