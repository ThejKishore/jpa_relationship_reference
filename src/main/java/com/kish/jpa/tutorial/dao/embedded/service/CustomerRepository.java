package com.kish.jpa.tutorial.dao.embedded.service;


import com.kish.jpa.tutorial.dao.embedded.model.Customer;
import com.kish.jpa.tutorial.dao.embedded.model.CustomerId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, CustomerId>{
}