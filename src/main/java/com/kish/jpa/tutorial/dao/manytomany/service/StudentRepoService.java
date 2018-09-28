package com.kish.jpa.tutorial.dao.manytomany.service;

import com.kish.jpa.tutorial.dao.manytomany.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepoService extends JpaRepository<Student,Integer> {
}
