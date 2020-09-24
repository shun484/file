package com.product_server.service;

import com.product_server.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProduct();

    Product getById(Integer id);
}
