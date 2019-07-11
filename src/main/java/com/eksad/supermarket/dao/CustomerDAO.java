package com.eksad.supermarket.dao;

import org.springframework.data.repository.CrudRepository;

import com.eksad.supermarket.entity.Customer;

public interface CustomerDAO extends CrudRepository<Customer, Long> {

}
