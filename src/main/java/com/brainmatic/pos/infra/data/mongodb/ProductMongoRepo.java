package com.brainmatic.pos.infra.data.mongodb;

import com.brainmatic.pos.core.Product;
import com.brainmatic.pos.core.ProductRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ProductMongoRepo implements ProductRepo {

    private static ArrayList<Product> data = new ArrayList<>();

    public int getCount(){
        System.out.println("Mongo DB");
        return 1;
    }

    public void save(Product prod){
        data.add(prod);
    }

    public void remove(int id){
    }

    public Product getById(int id){
        System.out.println("Mongo DB");
       return new Product();
    }

    public ArrayList<Product> getAll() {
        return data;
    }


}
