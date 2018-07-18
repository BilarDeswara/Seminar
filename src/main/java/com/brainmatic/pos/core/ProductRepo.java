package com.brainmatic.pos.core;

import java.util.ArrayList;

public interface ProductRepo {
    int getCount();
    void save(Product prod);
    void remove(int id);
    Product getById(int id);
    ArrayList<Product> getAll();
}
