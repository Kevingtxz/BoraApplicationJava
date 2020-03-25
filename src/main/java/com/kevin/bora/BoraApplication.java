package com.kevin.bora;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kevin.bora.domain.Category;
import com.kevin.bora.repositories.CategoryRepository;

@SpringBootApplication
public class BoraApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BoraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Sport");
		Category cat2 = new Category(null, "Party");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
	}
}
