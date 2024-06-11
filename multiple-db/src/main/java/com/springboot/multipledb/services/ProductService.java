package com.springboot.multipledb.services;

import com.springboot.multipledb.mysql.entities.Product;
import com.springboot.multipledb.mysql.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product){
        System.out.println("ProductService ...");
        productRepository.save(product);
    }

    public List<Product> findAllProduct() {
        System.out.println("ProductService ...");
        return productRepository.findAll();
    }

}
