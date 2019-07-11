package com.eksad.supermarket.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.eksad.supermarket.entity.Person;

public interface PersonDao extends PagingAndSortingRepository<Person, Long>{

}
