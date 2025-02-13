package com.dreamlayer.api.manage;

import java.util.List;

import com.dreamlayer.api.dto.ProductResponse;
import com.dreamlayer.api.modal.Product;

public interface IProductManage {

	public void createProduct(Product product);
	
	public List<ProductResponse> getAllProducts();
}
