package com.example.productCRUD.Controller;

import com.example.productCRUD.Entity.Product;
import com.example.productCRUD.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Product")
public class productController {

    @Autowired
    private ProductService productService;

    /*@PostMapping("/add")
    public String add(@RequestBody Product product){
        productService.addProduct(product);
        return "New Product Added";
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }*/

    @PostMapping("/add")
    public String add(@RequestBody Product product) {
        System.out.println("Received product: " + product); // Log received product
        productService.addProduct(product);
        return "New Product Added";
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        System.out.println("Fetched products: " + products); // Log fetched products
        return products;
    }

}
