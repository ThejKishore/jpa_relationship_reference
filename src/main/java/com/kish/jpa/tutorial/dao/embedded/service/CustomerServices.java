package com.kish.jpa.tutorial.dao.embedded.service;

import com.kish.jpa.tutorial.dao.embedded.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServices {

    @Autowired
    CustomerRepository customerRepository;

    public void deleteAll(){
        customerRepository.deleteAll();
    }

    public void save(Customer customer){
        customerRepository.save(customer);
        customerRepository.flush();
    }

    @Transactional
    public void showAll(){
        List<Customer> custs = customerRepository.findAll();
        custs.forEach(System.out::println);
    }
}