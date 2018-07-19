package com.brainmatic.pos.infra.data.inmemory;

import com.brainmatic.pos.core.entity.Product;
import com.brainmatic.pos.core.entity.repo.entityrepo.ProductRepo;

import java.util.ArrayList;

public class ProductMemRepo implements ProductRepo {

    private static ArrayList<Product> data = new ArrayList<>();

    public int getCount(){
        return data.size();
    }

    public void save(Product prod){
        data.add(prod);
    }

    public int remove(int id){
        for (Product p : data){
            if (p.getId()==id)
                data.remove(p);
        }
        return id;
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
