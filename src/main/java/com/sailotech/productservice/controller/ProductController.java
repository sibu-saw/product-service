package com.sailotech.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sailotech.productservice.business.ProductService;
import com.sailotech.productservice.dto.ProductDto;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService prodService;
	
	@GetMapping()
	public List<ProductDto> getAll() {
		return prodService.getAll();
	}

	@GetMapping("{productId}")
	public ResponseEntity<ProductDto> getByProductId(@PathVariable int productId) {
		var prodDto = prodService.getByProductId(productId);
		return ResponseEntity.of(prodDto);
	}
	
	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody ProductDto product) {
		prodService.addProduct(product);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
