package com.product_server.model;

import java.io.Serializable;

public class Product implements Serializable {

    public Product(){}
    public Product(Integer id ,String name , Integer price ,Integer store){
        this.id = id;
        this.name = name;
        this.price = price;
        this.store = store;
    }

    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 价格，分为单位
     */
    private Integer price;

    /**
     * 库存
     */
    private Integer store;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }
}
