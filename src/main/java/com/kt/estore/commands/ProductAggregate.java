package com.kt.estore.commands;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.kt.estore.event.ProductCreatedEvent;

@Aggregate

public class ProductAggregate {
	@AggregateIdentifier
	private String productId;
	private String title;
	private BigDecimal price;
	private Integer quantity;

	@CommandHandler
	public ProductAggregate(CreateProductCommand createProductCommand) {
		// validate product;
		if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Price canot  be less than equal to Zero");
		}
		if (createProductCommand.getTitle().isBlank()) {
			throw new IllegalArgumentException("Title cant be empty");
		}
		ProductCreatedEvent prodCreated = new ProductCreatedEvent();
		BeanUtils.copyProperties(createProductCommand, prodCreated);
		AggregateLifecycle.apply(prodCreated);

	}

	@EventSourcingHandler
	public void on(ProductCreatedEvent productCreatedEvent) {
		this.productId = productCreatedEvent.getProductId();
		this.price = productCreatedEvent.getPrice();
		this.title = productCreatedEvent.getTitle();
		this.quantity = productCreatedEvent.getQuantity();

	}

}
