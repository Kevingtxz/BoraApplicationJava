package com.kevin.bora.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Address;
import com.kevin.bora.domain.Category;
import com.kevin.bora.domain.Chat;
import com.kevin.bora.domain.City;
import com.kevin.bora.domain.Event;
import com.kevin.bora.domain.EventUsers;
import com.kevin.bora.domain.MainPageEvent;
import com.kevin.bora.domain.MainPageUser;
import com.kevin.bora.domain.Neighborhood;
import com.kevin.bora.domain.State;
import com.kevin.bora.domain.User;
import com.kevin.bora.domain.enums.Participation;
import com.kevin.bora.domain.enums.Permission;
import com.kevin.bora.repositories.AddressRepository;
import com.kevin.bora.repositories.CategoryRepository;
import com.kevin.bora.repositories.ChatRepository;
import com.kevin.bora.repositories.CityRepository;
import com.kevin.bora.repositories.EventRepository;
import com.kevin.bora.repositories.EventUsersRepository;
import com.kevin.bora.repositories.MainPageEventRepository;
import com.kevin.bora.repositories.MainPageUserRepository;
import com.kevin.bora.repositories.MessageRepository;
import com.kevin.bora.repositories.NeighborhoodRepository;
import com.kevin.bora.repositories.StateRepository;
import com.kevin.bora.repositories.UserRepository;

@Service
public class DBService {


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
	@Autowired
	private NeighborhoodRepository neighborhoodRepository;
	@Autowired
	private ChatRepository chatRepository;
	@Autowired
	private MessageRepository MessageRepository;
	@Autowired
	private MainPageEventRepository  mainPageEventRepository;
	@Autowired
	private MainPageUserRepository mainPageUserRepository;
	
	public void instantiateTestDatabase() {
		
		
		State s1 = new State(null, "RJ");
		State s2 = new State(null, "SP");
		State s3 = new State(null, "RG");
		
		City c1 = new City(null, "Macaé", s1);
		City c2 = new City(null, "São Paulo", s2);
		City c3 = new City(null, "Rio Grande", s3);

		Neighborhood n1 = new Neighborhood(null, "Mirante da Lagoa", c1);
		Neighborhood n2 = new Neighborhood(null, "Cassino", c1);
		Neighborhood n3 = new Neighborhood(null, "Lagomar", c3);
		
		Address a1 = new Address(null, "1024", "Casa Branca", n1);
		Address a2 = new Address(null, "108", "Preto", n3);
		Address a3 = new Address(null, "24", "Cinza", n2);
		
		User u1 = new User(null, "Kevingtxz", "Kevin", "Gonçalves", "21/10", "kevingtxz@gmail.com", "ratao", "macaco","M", Permission.OWNER, a3);
		User u2 = new User(null, "BUGZONA", "Bug", "Mello", "10/2", "melo@hotmail.com", "vaca", "sapo", "F", Permission.BLOQUEAD, a2);
		User u3 = new User(null, "Jack Tatue", "Walter", "Vargas", "25/03", "waltinho@wal.com", "soco", "vrawl", "M", Permission.MANAGER, a1);
		User u4 = new User(null, "FernandoZ", "Fernando", "Rogzar", "31/10", "feZ@yahoo.com", "xatuba", "lalala","M", Permission.OWNER, a3);
		User u5 = new User(null, "Rona", "Fox", "Megalo", "30/2", "rox@hotmail.com", "raposa", "xave", "F", Permission.LIMITEDUSER, a1);
		User u6 = new User(null, "Mtz", "Matheus", "Cordeiro", "29/03", "cord@cod.com", "zap", "vraw", "F", Permission.USER, a2);

		
		Category cat1 = new Category(null, "Esporte");
		Category cat2 = new Category(null, "Festa");	
		Category cat3 = new Category(null, "Rolê");
		Category cat4 = new Category(null, "Voluntário");	
		Category cat5 = new Category(null, "Dança");
		Category cat6 = new Category(null, "Atividade em grupo");

		
		Event e1 = new Event(null, "Futebol", "24/03/2020", "22:53", cat1, a1);
		Event e2 = new Event(null, "Vôlei", "21/10/2020", "22:53", cat1, a2);
		Event e3 = new Event(null, "Boate", "01/01/2020", "22:53", cat2, a2);
		Event e4 = new Event(null, "Axe", "20/01/2020", "22:53", cat2, a1);
		Event e5 = new Event(null, "Basquete", "10/03/20", "30:40", cat1, a1);
		Event e6 = new Event(null, "Caminhada", "10/03/20", "30:40", cat6, a2);
		Event e7 = new Event(null, "Dança do avião", "10/03/20", "30:40", cat5, a1);
		Event e8 = new Event(null, "Doações", "10/03/20", "30:40", cat4, a1);
		Event e9 = new Event(null, "Corrida em conjunto", "10/03/20", "30:40", cat6, a1);
		Event e10 = new Event(null, "Festa do João", "10/03/20", "30:40", cat2, a1);

		

		Chat chat1 = new Chat(null);
		Chat chat2 = new Chat(null);
		Chat chat3 = new Chat(null);
		Chat chat4 = new Chat(null);
		Chat chat5 = new Chat(null);
		Chat chat6 = new Chat(null);
		Chat chat7 = new Chat(null);
		Chat chat8 = new Chat(null);
		Chat chat9 = new Chat(null);
		Chat chat10 = new Chat(null);

		MainPageEvent mPE1 = new MainPageEvent(null, e3);
		MainPageEvent mPE2 = new MainPageEvent(null, e5);
		MainPageEvent mPE3 = new MainPageEvent(null, e7);
		MainPageEvent mPE4 = new MainPageEvent(null, e8);
		MainPageEvent mPE5 = new MainPageEvent(null, e10);

		MainPageUser mPU1 = new MainPageUser(null, u2);
		MainPageUser mPU2 = new MainPageUser(null, u5);
		MainPageUser mPU3 = new MainPageUser(null, u6);
		MainPageUser mPU4 = new MainPageUser(null, u3);
		MainPageUser mPU5 = new MainPageUser(null, u1);

		chat1.getMainPages().addAll(Arrays.asList(mPE1, mPU1));
		chat2.getMainPages().addAll(Arrays.asList(mPE4, mPE2));
		chat3.getMainPages().addAll(Arrays.asList(mPU1, mPU4));
		chat4.getMainPages().addAll(Arrays.asList(mPE2, mPU1));
		chat5.getMainPages().addAll(Arrays.asList(mPE5, mPU4));		
		chat6.getMainPages().addAll(Arrays.asList(mPE3, mPU5));
		chat7.getMainPages().addAll(Arrays.asList(mPU5, mPE1));
		chat8.getMainPages().addAll(Arrays.asList(mPU2, mPU4));
		chat9.getMainPages().addAll(Arrays.asList(mPU5, mPU4));
		chat10.getMainPages().addAll(Arrays.asList(mPU4, mPU3));		
		
		
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
		EventUsers eu2 = new EventUsers(null, Permission.USER, Participation.NOTHING, u2, e1);
		EventUsers eu3 = new EventUsers(null, Permission.LIMITEDUSER, Participation.ACTIVE, u3, e1);

		stateRepository.saveAll(Arrays.asList(s1, s2, s3));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));
		neighborhoodRepository.saveAll(Arrays.asList(n1, n2, n3));
		addressRepository.saveAll(Arrays.asList(a1, a2, a3));
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
		eventRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10));
		
		chatRepository.saveAll(Arrays.asList(chat1, chat2, chat3, chat4, chat5, chat6, chat7, chat8, chat9, chat10));
		mainPageEventRepository.saveAll(Arrays.asList(mPE1, mPE2, mPE3, mPE4, mPE5));
		mainPageUserRepository.saveAll(Arrays.asList(mPU1, mPU2, mPU3, mPU4, mPU5));
		
		eventUsersRepository.saveAll(Arrays.asList(eu1, eu2, eu3));
	
	}
}
