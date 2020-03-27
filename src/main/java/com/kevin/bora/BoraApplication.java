package com.kevin.bora;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kevin.bora.domain.Address;
import com.kevin.bora.domain.Category;
import com.kevin.bora.domain.City;
import com.kevin.bora.domain.Event;
import com.kevin.bora.domain.EventUsers;
import com.kevin.bora.domain.State;
import com.kevin.bora.domain.User;
import com.kevin.bora.domain.enums.Participation;
import com.kevin.bora.domain.enums.Permission;
import com.kevin.bora.repositories.AddressRepository;
import com.kevin.bora.repositories.CategoryRepository;
import com.kevin.bora.repositories.CityRepository;
import com.kevin.bora.repositories.EventRepository;
import com.kevin.bora.repositories.EventUsersRepository;
import com.kevin.bora.repositories.StateRepository;
import com.kevin.bora.repositories.UserRepository;

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
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EventUsersRepository eventUsersRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BoraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		State s1 = new State(null, "RJ");
		State s2 = new State(null, "SP");
		State s3 = new State(null, "RG");
		
		City c1 = new City(null, "Macaé", s1);
		City c2 = new City(null, "São Paulo", s2);
		City c3 = new City(null, "Rio Grande", s3);
		
		Address a1 = new Address(null, "1024", "White House", "Mirante Da Lagoa", c1);
		Address a2 = new Address(null, "108", "Black", "Lagomar", c1);
		Address a3 = new Address(null, "24", "Grey", "Rio Grande", c3);
		
		
		User u1 = new User(null, "Kevingtxz", "Kevin", "Gonçalves", "21/10", "kevingtxz@gmail.com", "ratao", "macaco", "M", Permission.OWNER, c1);
		User u2 = new User(null, "BUGZONA", "Bug", "Mello", "10/2", "melo@hotmail.com", "vaca", "sapo", "F", Permission.BLOQUEAD, c1);
		User u3 = new User(null, "Jack Tatue", "Walter", "Vargas", "25/03", "waltinho@wal.com", "soco", "vrawl", "M", Permission.MANAGER, c1);

		Category cat1 = new Category(null, "Sport");
		Category cat2 = new Category(null, "Party");	
		Category cat3 = new Category(null, "Sport3");
		Category cat4 = new Category(null, "Party4");	
		Category cat5 = new Category(null, "Sport5");
		Category cat6 = new Category(null, "Party6");

		Event e1 = new Event(null, "Futebol", "24/03/2020", "22:53", cat1, c1);
		Event e2 = new Event(null, "Vôlei", "21/10/2020", "22:53", cat1, c2);
		Event e3 = new Event(null, "Boate", "01/01/2020", "22:53", cat2, c2);
		Event e4 = new Event(null, "Axe", "20/01/2020", "22:53", cat2, c1);
		
		cat1.getEvents().addAll(Arrays.asList(e1,e2));
		cat2.getEvents().addAll(Arrays.asList(e3, e4));
		cat3.getEvents().addAll(Arrays.asList(e1,e2, e3));
		cat4.getEvents().addAll(Arrays.asList(e3));
		cat5.getEvents().addAll(Arrays.asList(e1));
		cat6.getEvents().addAll(Arrays.asList(e3, e4, e1, e2));
		
		s1.getCities().addAll(Arrays.asList(c1));
		s2.getCities().addAll(Arrays.asList(c2));
		s3.getCities().addAll(Arrays.asList(c3));

		u1.getPhones().addAll(Arrays.asList("90909090"));
		u2.getPhones().addAll(Arrays.asList("50909090"));
		u3.getPhones().addAll(Arrays.asList("00909090"));

		EventUsers eu1 = new EventUsers(null, Permission.OWNER, Participation.HIGHMEMBER, u1, e4);
		EventUsers eu2 = new EventUsers(null, Permission.NOTMEMBER, Participation.NOTHING, u2, e1);
		EventUsers eu3 = new EventUsers(null, Permission.LIMITEDUSER, Participation.ACTIVE, u3, e1);

		stateRepository.saveAll(Arrays.asList(s1, s2, s3));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		addressRepository.saveAll(Arrays.asList(a1, a2, a3));
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
		eventRepository.saveAll(Arrays.asList(e1, e2, e3, e4));
		eventUsersRepository.saveAll(Arrays.asList(eu1, eu2, eu3));
	}
}
