package com.example.productCRUD.Service;

import com.example.productCRUD.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProducts();

    Optional<Product> getProductById(int id);

    Product updateProduct(int id, Product updatedProduct);

    void deleteProduct(int id);
}
