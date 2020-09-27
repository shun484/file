package com.order_server.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.order_server.service.ProductOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {


    @Autowired
    private ProductOderService service;

    @RequestMapping("/save")
    @HystrixCommand(fallbackMethod = "saveFindOeder")
    public Object find(@RequestParam("userId")Integer userId,@RequestParam("productId")Integer productId){
        Map<Object, Object> map = new HashMap<>();
        map.put("code",1);
        map.put("data",service.save(userId,productId));
        return map;
    }

    private Object saveFindOeder(Integer userId,Integer productId){
        Map<String, Object> map = new HashMap<>();
        map.put("code",-1);
        map.put("msg","抢购人数太多，你被挤出来了，稍后再试");
        return map;
    }
}
