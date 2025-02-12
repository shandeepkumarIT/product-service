package com.dreamlayer.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dreamlayer.api.dto.CommonResponse;
import com.dreamlayer.api.dto.ProductRequest;
import com.dreamlayer.api.dto.ProductResponse;
import com.dreamlayer.api.modal.Product;
import com.dreamlayer.api.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;

	public void createProduct(ProductRequest productRequest) {
		
		Product product = Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.build();
		
		productRepository.save(product);
		log.info("Product {} is saved.", product.getId());
	}
	
	public CommonResponse getAllProducts() {
		
		List<Product> products = productRepository.findAll();
		
		List<ProductResponse> result = products.stream().map(this::mapToProductResponse).toList();
		CommonResponse commonResponse = new CommonResponse();
		commonResponse.setStatus("Success");
		commonResponse.setStatus_code(00);
		commonResponse.setTitle("Product Details");		
		commonResponse.setMessage("Successfully received all products");
		commonResponse.setResponse(result);
		return commonResponse;
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
