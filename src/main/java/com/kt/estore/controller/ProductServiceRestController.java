package com.kt.estore.controller;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductServiceRestController {
	
	@PostMapping
	public String createProduct() {
		return "HTTP Post";
		
	}
	@GetMapping
	public String getProduct() {
		return "Get HTTP";
		
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
