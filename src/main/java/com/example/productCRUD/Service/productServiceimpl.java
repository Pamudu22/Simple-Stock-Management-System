package com.example.productCRUD.Service;

import com.example.productCRUD.Entity.Product;
import com.example.productCRUD.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class productServiceimpl implements ProductService {


    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product addProduct(Product product){
        return productRepo.save(product);
    }


    @Override
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
}
