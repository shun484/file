package com.order_server.service;

import com.order_server.model.ProductOrder;

public interface ProductOderService {

    ProductOrder save(Integer id , Integer productId);
}
