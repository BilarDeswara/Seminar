package com.brainmatic.pos.infra.data.mongodb;

import com.brainmatic.pos.core.entity.Product;
import com.brainmatic.pos.core.entity.repo.entityrepo.ProductRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ProductMongoRepo implements ProductRepo {

    private static ArrayList<Product> data = new ArrayList<>();

    public int getCount(){
        System.out.println("Mongo DB COY BAHENOL");
        return 1;
    }

    public void save(Product prod){
        data.add(prod);
    }

    public int remove(int id){
        return id;
    }

    public Product getById(int id){
        System.out.println("Mong9o DB COY BAHENOL");
       return new Product();
    }

    public ArrayList<Product> getAll() {
        return data;
    }


}
