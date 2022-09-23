package com.kt.estore.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CreateProductRestModel {
	private String title;
	private BigDecimal price;
	private Integer quantity;

	
}
