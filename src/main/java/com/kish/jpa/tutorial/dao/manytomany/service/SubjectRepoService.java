package com.kish.jpa.tutorial.dao.manytomany.service;

import com.kish.jpa.tutorial.dao.manytomany.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepoService extends JpaRepository<Subject,Integer> {
}
