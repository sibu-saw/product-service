package com.sailotech.productservice.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.sailotech.productservice.persistence.entity.Product;

public interface ProductRepository extends ListCrudRepository<Product, Integer> {

}
