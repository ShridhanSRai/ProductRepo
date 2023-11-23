package com.cg.micro.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.micro.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
