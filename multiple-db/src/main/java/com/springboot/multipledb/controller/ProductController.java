package com.springboot.multipledb.controller;

import com.springboot.multipledb.mysql.entities.Product;
import com.springboot.multipledb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product){
        System.out.println("ProductController ... ");
        productService.addProduct(product);
    }
    @GetMapping("/findAll")
    public List<Product> findAllProduct(){
        System.out.println("ProductController ... ");
        return productService.findAllProduct();
    }
}
