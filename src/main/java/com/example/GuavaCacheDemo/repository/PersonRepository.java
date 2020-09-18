package com.example.GuavaCacheDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GuavaCacheDemo.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
