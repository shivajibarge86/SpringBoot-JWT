package com.inventory.productinventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.productinventory.entities.Product;
import com.inventory.productinventory.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService  productService;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public Product saveProduct(@RequestBody Product newProduct){
		return productService.save(newProduct);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Product findProductById(@RequestParam("id") String id){
		return productService.findById(Long.valueOf(id));
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	public String delete(@RequestParam("id") String id){
		 productService.delete(Long.valueOf(id));
		 return "product deleted successfully";
	}
	
}
