package com.kt.estore.repository;

import org.springframework.data.repository.CrudRepository;

import com.kt.estore.entity.ProductEntity;

public interface ProductRepo extends CrudRepository<ProductEntity, String> {

}
