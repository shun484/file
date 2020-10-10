package com.product_server.controller;

import com.product_server.model.Product;
import com.product_server.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

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
        logger.info("pro list");
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
