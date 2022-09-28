package com.kt.estore.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
public class ProductEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7332911214056370157L;
	@Id
	@Column(unique = true)
	private String productId;
	@Column(unique = true)
	private String title;
	private BigDecimal price;
	private Integer quantity;
	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", title=" + title + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
}
