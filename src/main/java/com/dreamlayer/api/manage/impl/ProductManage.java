package com.dreamlayer.api.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dreamlayer.api.dto.ProductResponse;
import com.dreamlayer.api.manage.IProductManage;
import com.dreamlayer.api.modal.Product;
import com.dreamlayer.api.repository.ProductRepository;

@Component
public class ProductManage implements IProductManage {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void createProduct(Product product) {

		productRepository.save(product);
	}
	
	@Override
	public List<ProductResponse> getAllProducts() {
		
		List<Product> products = productRepository.findAll();
		return products.stream().map(this::mapToProductResponse).toList();
	}
	
	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
	}

}
