package com.kevin.bora;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kevin.bora.domain.Category;
import com.kevin.bora.domain.Event;
import com.kevin.bora.repositories.CategoryRepository;
import com.kevin.bora.repositories.EventRepository;

@SpringBootApplication
public class BoraApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private EventRepository eventRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BoraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Sport");
		Category cat2 = new Category(null, "Party");

		Event e1 = new Event(null, "Futebol", "24/03/2020", "22:53", cat1);
		Event e2 = new Event(null, "Vôlei", "21/10/2020", "22:53", cat1);
		Event e3 = new Event(null, "Boate", "01/01/2020", "22:53", cat2);
		Event e4 = new Event(null, "Axe", "20/01/2020", "22:53", cat2);
		
		cat1.getEvents().addAll(Arrays.asList(e1,e2));
		cat2.getEvents().addAll(Arrays.asList(e3, e4));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		eventRepository.saveAll(Arrays.asList(e1, e2, e3, e4));
	}
}
