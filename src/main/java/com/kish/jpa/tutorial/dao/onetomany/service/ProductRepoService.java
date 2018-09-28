package com.kish.jpa.tutorial.dao.onetomany.service;

import com.kish.jpa.tutorial.dao.onetomany.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepoService extends JpaRepository<Product,Long> {
}
