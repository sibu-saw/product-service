package com.sailotech.productservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDto {

	@NotNull
	@NotBlank
	private String name;
	
	@NotNull
	@NotBlank
	private String description;
	
	@Min(1000)
	private double price;
	
	@NotBlank
	@NotNull
	private String skuCode;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
}
