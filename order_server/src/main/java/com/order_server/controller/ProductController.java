package com.order_server.controller;

import com.order_server.service.ProductOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {


    @Autowired
    private ProductOderService service;

    @RequestMapping("/save")
    public Object find(@RequestParam("userId")Integer userId,@RequestParam("productId")Integer productId){

        return service.save(userId,productId);
    }

}
