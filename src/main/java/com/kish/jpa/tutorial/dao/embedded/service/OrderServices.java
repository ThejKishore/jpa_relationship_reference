package com.kish.jpa.tutorial.dao.embedded.service;


import com.kish.jpa.tutorial.dao.embedded.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServices {

    @Autowired
    OrderRepository orderRepository;

    public void save(OrderDetail order){
        orderRepository.save(order);
    }

    public void deleteAll(){
        orderRepository.deleteAll();
    }
}