package com.kish.jpa.tutorial.dao.onetomany.service;

import com.kish.jpa.tutorial.dao.onetomany.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepoService extends JpaRepository<Company,Long> {
}
