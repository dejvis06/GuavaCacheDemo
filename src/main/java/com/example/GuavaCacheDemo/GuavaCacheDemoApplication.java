package com.example.GuavaCacheDemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.GuavaCacheDemo.config.CacheConfig;
import com.example.GuavaCacheDemo.entity.Person;

@SpringBootApplication
@Component
@EnableScheduling
public class GuavaCacheDemoApplication {

	@Autowired
	private CacheConfig cache;

	public static void main(String[] args) {
		SpringApplication.run(GuavaCacheDemoApplication.class, args);
	}

	@PostConstruct
	public void testCache() {

		try {

			Person person = cache.getPerson(1);

			System.err.println("post construct: " + person.toString());

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Scheduled(fixedRate = 10000)
	void testRefresh() {
		try {
			System.err.println("test schedule");
			System.err.println("person: " + cache.getPerson(1).toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
