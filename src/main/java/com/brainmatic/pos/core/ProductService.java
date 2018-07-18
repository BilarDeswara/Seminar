package com.brainmatic.pos.core;

import com.brainmatic.pos.infra.data.inmemory.ProductMemRepo;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepo repository;

    public ProductService(ProductRepo repository){
        this.repository = repository;
    }

    public int generateId(){
//        ProductMemRepo repo = new ProductMemRepo();
        return repository.getCount()+1;
    }

    public String generateCode(){
        //ProductMemRepo repo = new ProductMemRepo();
        return "P" + repository.getCount();
    }


    public Product newProduct(){
        Product result = new Product();
        result.setCode(generateCode());
        return result;
    }
}
