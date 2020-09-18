package com.example.GuavaCacheDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GuavaCacheDemo.entity.Person;
import com.example.GuavaCacheDemo.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Person findById(Integer id) {
		try {
			return personRepository.findById(id).get();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}
}
