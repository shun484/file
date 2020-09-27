package com.order_server.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.order_server.model.ProductOrder;
import com.order_server.service.ProductClient;
import com.order_server.service.ProductOderService;
import com.order_server.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.UUID;

@Service
public class ProductOderServiceImpl implements ProductOderService {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @Override
    public ProductOrder save(Integer userId, Integer productId) {
        /*Map<String,Object> forObject = restTemplate.getForObject("http://product-service/api/ve/product/find?id="+productId, Map.class);
        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setUserName(forObject.get("name").toString());
        productOrder.setPrice(Integer.parseInt(forObject.get("price").toString()));*/
        String byId = productClient.findById(productId);
        /*try {
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }*/
        JsonNode jsonNode = JsonUtils.str2JsonNode(byId);
        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setUserName(jsonNode.get("name").toString());
        productOrder.setPrice(Integer.parseInt(jsonNode.get("price").toString()));
        return productOrder;
    }
}
