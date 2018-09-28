package com.kish.jpa.tutorial.dao.onetoone.service;

import com.kish.jpa.tutorial.dao.onetoone.model.Wife;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WifeRepoService extends JpaRepository<Wife,Integer> {
}
