package com.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.entity.student;

public interface studentrepository extends CrudRepository<student, Integer> {

}
