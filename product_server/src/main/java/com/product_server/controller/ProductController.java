package com.product_server.controller;

import com.product_server.model.Product;
import com.product_server.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ve/product")
public class ProductController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private ProductService service;

    /**
     * 订单集合
     * @return
     */
    @RequestMapping("/list")
    private Object list(){
        System.out.println(port);
        return service.listProduct();
    }

    /**
     * 根据id查询订单信息
     * @param id
     * @return
     */
    @RequestMapping("/find")
    public Object find(Integer id){
        Product byId = service.getById(id);
        Product product = new Product();
        BeanUtils.copyProperties(byId,product);
        product.setName(port);
        return product;
    }

}
