package com.dreamlayer.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import com.dreamlayer.api.dto.CommonResponse;
import com.dreamlayer.api.dto.ProductRequest;
import com.dreamlayer.api.dto.ProductResponse;
import com.dreamlayer.api.manage.IProductManage;
import com.dreamlayer.api.modal.Product;
import com.dreamlayer.api.service.IProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductService implements IProductService {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private IProductManage iProductManage;
	
	@Override
	public CommonResponse createProduct(ProductRequest productRequest) {
		
		CommonResponse commonResponse = new CommonResponse();
		Product product = Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.build();
		
		iProductManage.createProduct(product);

		commonResponse.setStatus_code(00);
		commonResponse.setStatus("Success");
		commonResponse.setTitle("Create Product");
		commonResponse.setMessage(getLocalizedMessage("successOrder") + " - " + product.getId());
		return commonResponse;
	}
	
	@Override
	public CommonResponse getAllProducts() {
		
		CommonResponse commonResponse = new CommonResponse();
		List<ProductResponse> result = iProductManage.getAllProducts();
		
		commonResponse.setStatus_code(00);
		commonResponse.setStatus("Success");
		commonResponse.setTitle("Create Product");
		commonResponse.setMessage(getLocalizedMessage("getProducts"));
		commonResponse.setResponse(result);
		return commonResponse;
	}
	
	public String getLocalizedMessage(String translationKey) {
		
		return messageSource.getMessage(translationKey, null, LocaleContextHolder.getLocale());
	}
	
	
}
