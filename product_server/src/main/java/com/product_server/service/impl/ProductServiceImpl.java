package com.product_server.service.impl;

import com.product_server.model.Product;
import com.product_server.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Map<Integer,Product> hashMap = new HashMap<>();

    static {
        Product p1 = new Product(1, "小米", 999, 10);
        Product p2 = new Product(2, "华为", 9999, 1000);
        Product p3 = new Product(3, "魅族", 9990, 100);
        hashMap.put(p1.getId(),p1);
        hashMap.put(p2.getId(),p2);
        hashMap.put(p3.getId(),p3);
    }

    @Override
    public List<Product> listProduct() {
        Collection<Product> collection = hashMap.values();
        List<Product> list = new ArrayList<>(collection);
        return list;
    }

    @Override
    public Product getById(Integer id) {
        return hashMap.get(id);
    }
}
