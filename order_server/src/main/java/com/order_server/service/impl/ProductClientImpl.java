package com.order_server.service.impl;


import com.order_server.service.ProductClient;
import org.springframework.stereotype.Component;

/**
 * 真对商品服务，降级处理
 */
@Component
public class ProductClientImpl implements ProductClient {
    @Override
    public String findById(Integer id) {
        System.out.println("feigin 异常");
        return null;
    }
}
