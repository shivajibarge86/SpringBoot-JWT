package com.inventory.productinventory.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.productinventory.dao.ProductRepository;
import com.inventory.productinventory.entities.Product;

@Service
public class ProductService {

   @Autowired
   private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		return productRepository.findOne(id);
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
	}

	public void delete(Long id) {
		 productRepository.delete(id);
	}
	
}

