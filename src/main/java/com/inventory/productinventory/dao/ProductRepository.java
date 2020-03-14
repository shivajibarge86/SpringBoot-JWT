package com.inventory.productinventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.productinventory.entities.Product;

/** This the product  Repository interface  */ 
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



}
