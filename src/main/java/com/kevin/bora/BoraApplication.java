package com.kevin.bora;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kevin.bora.domain.Category;
import com.kevin.bora.domain.City;
import com.kevin.bora.domain.Event;
import com.kevin.bora.domain.State;
import com.kevin.bora.repositories.CategoryRepository;
import com.kevin.bora.repositories.CityRepository;
import com.kevin.bora.repositories.EventRepository;
import com.kevin.bora.repositories.StateRepository;

@SpringBootApplication
public class BoraApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private StateRepository stateRepository;
	
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
		
		
		State s1 = new State(null, "RJ");
		State s2 = new State(null, "SP");
		State s3 = new State(null, "RG");
		
		City c1 = new City(null, "Macaé", s1);
		City c2 = new City(null, "São Paulo", s2);
		City c3 = new City(null, "Rio Grande", s3);
		
		s1.getCities().addAll(Arrays.asList(c1));
		s2.getCities().addAll(Arrays.asList(c2));
		s3.getCities().addAll(Arrays.asList(c3));
		

		stateRepository.saveAll(Arrays.asList(s1, s2, s3));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		
	}
}
