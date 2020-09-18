package com.example.GuavaCacheDemo.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.GuavaCacheDemo.entity.Person;
import com.example.GuavaCacheDemo.service.PersonService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Configuration
public class CacheConfig {

	@Autowired
	private PersonService personService;

	private LoadingCache<Integer, Person> loadingCache = CacheBuilder.newBuilder()
			.refreshAfterWrite(1, TimeUnit.MILLISECONDS).maximumSize(1).build(new CacheLoader<Integer, Person>() {

				@Override
				public Person load(Integer key) throws Exception {
					// TODO Auto-generated method stub
					return personService.findById(key);
				}

			});

	public void add(Person person) throws Exception {
		loadingCache.put(person.getId(), person);
	}

	public Person getPerson(Integer id) throws Exception {
		return loadingCache.get(id);
	}
}
