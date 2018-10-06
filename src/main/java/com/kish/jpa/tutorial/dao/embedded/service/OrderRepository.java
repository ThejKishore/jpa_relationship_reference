package com.kish.jpa.tutorial.dao.embedded.service;

import com.kish.jpa.tutorial.dao.embedded.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<OrderDetail, Integer>{
}