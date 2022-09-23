package com.kt.estore.event;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data

@AllArgsConstructor
@NoArgsConstructor
public class ProductCreatedEvent {
	
	private  String productId;
	private  String title;
	private  BigDecimal price;
	private  Integer quantity;
	
}
