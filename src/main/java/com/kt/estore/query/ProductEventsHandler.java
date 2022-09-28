package com.kt.estore.query;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.kt.estore.entity.ProductEntity;
import com.kt.estore.event.ProductCreatedEvent;
import com.kt.estore.repository.ProductRepo;

@Component
public class ProductEventsHandler {
	private final ProductRepo prodRepo;
	public ProductEventsHandler(ProductRepo prodRepo ) {
		this.prodRepo = prodRepo;
		
	}
	@EventHandler
	public void on(ProductCreatedEvent productCreatedEvent) {
			ProductEntity prodEntity=new ProductEntity();
			BeanUtils.copyProperties(productCreatedEvent, prodEntity);
			
			try {
				ProductEntity save = prodRepo.save(prodEntity);
				System.out.println("******************Saved Product*********************\n"+save.toString());
			} catch(Exception e) {
				System.err.println("Exception while saving"+e.getLocalizedMessage());
				e.printStackTrace();
				throw new RuntimeException(e.getLocalizedMessage());
			}
			System.out.println(" ****************saved to DB*************\n: "+prodEntity.getProductId()+"\n");
	}
}
