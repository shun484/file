package com.order_server.service;

import com.order_server.service.impl.ProductClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="product-service",fallback = ProductClientImpl.class)
public interface ProductClient {

    @GetMapping("/api/ve/product/find")
    String findById(@RequestParam(value = "id")Integer id);
}
