package com.dreamlayer.api.service;

import com.dreamlayer.api.dto.CommonResponse;
import com.dreamlayer.api.dto.ProductRequest;

public interface IProductService {

	public CommonResponse createProduct(ProductRequest productRequest);
	
	public CommonResponse getAllProducts();
}

