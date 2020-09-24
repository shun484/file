package com.order_server.service.impl;

import com.order_server.model.ProductOrder;
import com.order_server.service.ProductOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductOderServiceImpl implements ProductOderService {

    private final static String S = "http://";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ProductOrder save(Integer userId, Integer productId) {
        Map<String,Object> forObject = restTemplate.getForObject(S+"product-service/api/ve/product/find?id="+productId, Map.class);
        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setUserName(forObject.get("name").toString());
        productOrder.setPrice(Integer.parseInt(forObject.get("price").toString()));
        return productOrder;
    }
}
