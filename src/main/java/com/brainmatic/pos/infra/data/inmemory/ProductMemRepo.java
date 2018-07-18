package com.brainmatic.pos.infra.data.inmemory;

import com.brainmatic.pos.core.Product;
import com.brainmatic.pos.core.ProductRepo;

import java.util.ArrayList;

public class ProductMemRepo implements ProductRepo {

    private static ArrayList<Product> data = new ArrayList<>();

    public int getCount(){
        return data.size();
    }

    public void save(Product prod){
        data.add(prod);
    }

    public void remove(int id){
        for (Product p : data){
            if (p.getId()==id)
                data.remove(p);
        }
    }

    public Product getById(int id){
        for (Product p: data){
            if (p.getId()==id)
                return p;
        }
        return null;
    }

    public ArrayList<Product> getAll() {
        return data;
    }


}
