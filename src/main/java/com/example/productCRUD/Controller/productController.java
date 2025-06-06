package com.example.productCRUD.Controller;

import com.example.productCRUD.Entity.Product;
import com.example.productCRUD.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Update if your frontend is on a different port
@RequestMapping("/product")
public class productController {

    @Autowired
    private ProductService productService;

    // CREATE
    @PostMapping("/add")
    public String add(@RequestBody Product product) {
        System.out.println("Received product: " + product);
        productService.addProduct(product);
        return "New Product Added";
    }

    // READ ALL
    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        System.out.println("Fetched products: " + products);
        return products;
    }

    // READ ONE
    @GetMapping("/get/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        productService.updateProduct(id, updatedProduct);
        return "Product Updated Successfully";
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "Product Deleted Successfully";
    }
}
