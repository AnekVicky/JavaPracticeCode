package com.springboot.multipledb.mysql.repository;

import com.springboot.multipledb.mysql.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
