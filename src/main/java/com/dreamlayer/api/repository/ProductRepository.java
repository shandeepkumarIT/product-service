package com.dreamlayer.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dreamlayer.api.modal.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
