package com.example.productCRUD.Service;

import com.example.productCRUD.Entity.Product;

import java.util.List;

public interface ProductService {

    public Product addProduct(Product product);

    public List<Product> getAllProducts();
}
