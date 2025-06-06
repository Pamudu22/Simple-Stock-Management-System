package com.example.productCRUD.Service;

import com.example.productCRUD.Entity.Product;
import com.example.productCRUD.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productServiceimpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    // Create
    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    // Read all
    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    // Read one by ID
    @Override
    public Optional<Product> getProductById(int id) {
        return productRepo.findById(id);
    }

    // Update
    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            // Add more fields if applicable
            return productRepo.save(existingProduct);
        } else {
            throw new RuntimeException("Product not found with ID: " + id);
        }
    }

    // Delete
    @Override
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
}
