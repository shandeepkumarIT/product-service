package com.dreamlayer.api.controller;

import static com.dreamlayer.api.utils.Constants.RequestMappings.PRODUCT;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dreamlayer.api.dto.CommonResponse;
import com.dreamlayer.api.dto.ProductRequest;
import com.dreamlayer.api.service.IProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCT)
public class ProductController {

	private final IProductService iProductService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<CommonResponse> createProduct(@RequestBody ProductRequest productRequest) {
		
		return ResponseEntity.ok(iProductService.createProduct(productRequest));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<CommonResponse> getAllProducts() {
		
		 return ResponseEntity.ok(iProductService.getAllProducts());
	}
}
