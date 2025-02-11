package com.dreamlayer.api.controller;

import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_200_CODE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_200_MESSAGE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_201_CODE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_201_MESSAGE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_400_CODE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_400_MESSAGE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_401_CODE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_401_MESSAGE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_403_CODE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_403_MESSAGE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_404_CODE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_404_MESSAGE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_429_CODE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_429_MESSAGE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_500_CODE;
import static com.dreamlayer.api.utils.Constants.HttpCodes.HTTP_500_MESSAGE;

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
import com.dreamlayer.api.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCT)
@Tag(name = PRODUCT, description = "Product details display")
public class ProductController {

	private final ProductService productService;
	
	@Operation(summary = "Create the Product")
	@ApiResponses({
		@ApiResponse(responseCode = HTTP_201_CODE, description = HTTP_201_MESSAGE),
		@ApiResponse(responseCode = HTTP_400_CODE, description = HTTP_400_MESSAGE),
		@ApiResponse(responseCode = HTTP_401_CODE, description = HTTP_401_MESSAGE),
		@ApiResponse(responseCode = HTTP_403_CODE, description = HTTP_403_MESSAGE),
		@ApiResponse(responseCode = HTTP_404_CODE, description = HTTP_404_MESSAGE),
		@ApiResponse(responseCode = HTTP_429_CODE, description = HTTP_429_MESSAGE),
		@ApiResponse(responseCode = HTTP_500_CODE, description = HTTP_500_MESSAGE)
	})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(produces = APPLICATION_JSON_VALUE)
	public void ResponseEntitycreateProduct(@RequestBody ProductRequest productRequest) {
		
		productService.createProduct(productRequest);
	}
	
	@Operation(summary = "get all available products")
	@ApiResponses({
		@ApiResponse(responseCode = HTTP_200_CODE, description = HTTP_200_MESSAGE, content = { @Content(schema = @Schema(implementation = CommonResponse.class), mediaType=APPLICATION_JSON_VALUE) }),
		@ApiResponse(responseCode = HTTP_400_CODE, description = HTTP_400_MESSAGE),
		@ApiResponse(responseCode = HTTP_401_CODE, description = HTTP_401_MESSAGE),
		@ApiResponse(responseCode = HTTP_403_CODE, description = HTTP_403_MESSAGE),
		@ApiResponse(responseCode = HTTP_404_CODE, description = HTTP_404_MESSAGE),
		@ApiResponse(responseCode = HTTP_429_CODE, description = HTTP_429_MESSAGE),
		@ApiResponse(responseCode = HTTP_500_CODE, description = HTTP_500_MESSAGE)
	})
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<CommonResponse> getAllProducts() {
		
		return ResponseEntity.ok(productService.getAllProducts());
	}
}
