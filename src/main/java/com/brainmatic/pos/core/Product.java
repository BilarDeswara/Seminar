package com.brainmatic.pos.core;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String code;
    private String name;
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {

        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrice (long price) {
        setPrice(BigDecimal.valueOf(price));
    }

//    public Product(){
//        ProductRepository repo = new ProductRepository();
//        setId(repo.getCount()+1);
//    }
}
