package com.kt.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductServiceRestController {
	@Autowired
	private Environment env;
	
	@PostMapping
	public String createProduct() {
		return "HTTP Post";
		
	}
	@GetMapping
	public String getProduct() {
		return "Get HTTP"+env.getProperty("local.server.port");
		
	}
	@PutMapping
	public String updateProduct() {
		return "Put HTTP";
		
	}
	@DeleteMapping
	public String deleteProduct() {
		return "Delete HTTP";
		
	}
	
}
