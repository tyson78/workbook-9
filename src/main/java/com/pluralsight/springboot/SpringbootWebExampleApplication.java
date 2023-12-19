package com.pluralsight.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootWebExampleApplication implements CommandLineRunner {
	@Autowired @Qualifier("mysql")
	ProductDao productDao;

	public static void main(String[] args) {
		ApplicationContext context;
		context = SpringApplication.run(SpringbootWebExampleApplication.class, args);

		// ProductDao productDao = context.getBean(ProductDao.class);
		// ProductDao productDao = context.getBean("simpleDao", ProductDao.class);

	}

	@Override
	public void run(String... args) throws Exception {


		System.out.println(productDao.getAll());

	}
}
