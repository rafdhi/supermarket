package com.eksad.supermarket.dao;

import org.springframework.data.repository.CrudRepository;

import com.eksad.supermarket.entity.Product;

public interface ProductDao extends CrudRepository<Product, Long> {

}

