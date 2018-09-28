package com.kish.jpa.tutorial.dao.onetoone.service;

import com.kish.jpa.tutorial.dao.onetoone.model.Husband;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HusbandRepoService extends JpaRepository<Husband,Integer> {
}
