package com.sailotech.productservice.business;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sailotech.productservice.dto.ProductDto;
import com.sailotech.productservice.persistence.entity.Product;
import com.sailotech.productservice.persistence.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository prodRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public List<ProductDto> getAll() {
		return prodRepository.findAll().stream()
				.map(prod -> modelMapper.map(prod, ProductDto.class))
				.toList();
	}

	public Optional<ProductDto> getByProductId(int productId) {
		Optional<Product> product = prodRepository.findById(productId);
		return Optional.of(modelMapper.map(product.get(), ProductDto.class));
	}

	public int addProduct(ProductDto productDto) {
		Product newProduct = prodRepository.save(modelMapper.map(productDto, Product.class));
		return newProduct.getProductId();
	}
	
	/*
	private ProductDto mapToProductDto(Product product) {

		if (product == null)
			return null;

		ProductDto prodDto = new ProductDto();
		prodDto.setDescription(product.getDescription());
		prodDto.setName(product.getName());
		prodDto.setPrice(product.getPrice());
		
		return prodDto;
	}

	private Product mapToProduct(ProductDto productDto) {

		if (productDto == null)
			return null;

		Product product = new Product();
		product.setDescription(productDto.getDescription());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		
		return product;
	}
	
	*/
}
