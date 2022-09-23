package com.kt.estore.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kt.estore.commands.CreateProductCommand;
import com.kt.estore.model.CreateProductRestModel;

@RestController
@RequestMapping("/products")
public class ProductServiceRestController {
	@Autowired
	private final Environment env;
	private final CommandGateway commandGateway;

	public ProductServiceRestController(Environment env, CommandGateway commandGateway) {
		this.env = env;
		this.commandGateway = commandGateway;

	}

	@PostMapping
	public String createProduct(@RequestBody CreateProductRestModel prodcut) {
		CreateProductCommand createProduct = CreateProductCommand.builder().price(prodcut.getPrice())
				.quantity(prodcut.getQuantity()).title(prodcut.getTitle()).productId(UUID.randomUUID().toString())
				.build();
		String sendAndWait;
		try {
			sendAndWait = commandGateway.sendAndWait(createProduct);
		} catch (Exception e) {
			sendAndWait = e.getLocalizedMessage();
		}
		return sendAndWait;

	}

	@GetMapping
	public String getProduct() {
		return "Get HTTP" + env.getProperty("local.server.port");

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
