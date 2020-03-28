package com.kevin.bora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.kevin.bora.domain.Address;
import com.kevin.bora.domain.City;
import com.kevin.bora.domain.Neighborhood;
import com.kevin.bora.domain.User;
import com.kevin.bora.domain.enums.Permission;
import com.kevin.bora.dto.UserDTO;
import com.kevin.bora.dto.UserNewDTO;
import com.kevin.bora.repositories.AddressRepository;
import com.kevin.bora.repositories.CityRepository;
import com.kevin.bora.repositories.NeighborhoodRepository;
import com.kevin.bora.repositories.UserRepository;
import com.kevin.bora.services.exceptions.DataIntegrityException;
import com.kevin.bora.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private NeighborhoodRepository neighborhoodRepository;
	@Autowired
	private CityRepository cityRepository;
	
	
	public User find( Integer id ) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not find! Id: " + id + ", Type: " + User.class.getName()));
	}
	
	public User insert(User obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public User update(User obj) {
		User newObj = find(obj.getId());
		updataData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("It's impossible to delete a user now");
		}
	}
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public Page<User> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(
				objDto.getId(), 
				objDto.getUserName(), null, null, null, 
				objDto.getEmail(), 
				objDto.getPassword(), 
				objDto.getNotes(), 
				objDto.getGender(), 
				Permission.toEnum(objDto.getPermission()),
				objDto.getAddress());
	}
	
	public User fromDTO(UserNewDTO objDto) {
		Optional<Address> address = addressRepository.findById(objDto.getAddressId());
		if(address == null) {
			Optional<Neighborhood> neighborhood = neighborhoodRepository.findById(objDto.getNeighborhoodId());
			Optional<City> city = cityRepository.findById(objDto.getCityId());
			Neighborhood newNeighborhood = new Neighborhood(null, objDto.getNeighborhood(),city.orElse(null));
			Address newAddress = new Address(null, objDto.getNumber(), objDto.getComplement(), neighborhood.orElse(newNeighborhood));
			if(newAddress.getNeighborhood() == newNeighborhood) {
				neighborhoodRepository.save(newNeighborhood);
			}
			addressRepository.save(newAddress);
		}
		User user  = new User(null, objDto.getUserName(), objDto.getName(), objDto.getLastName(), objDto.getBirth(), objDto.getEmail(), 
				objDto.getPassword(), objDto.getNotes(), objDto.getGender(), null, address.orElse(null));		
		user.getPhones().add(objDto.getPhone1());
		if(objDto.getPhone2() != null) {
			user.getPhones().add(objDto.getPhone2());
		}
		return user;
	}
	
	private void updataData(User newObj, User obj) {

		if(obj.getUserName() != null) {
			newObj.setUserName(obj.getUserName());
		}
		if(obj.getEmail() != null) {
			newObj.setUserName(obj.getEmail());
		}
		if(obj.getPassword() != null) {
			newObj.setPassword(obj.getPassword());
		}
		if(obj.getNotes() != null) {
			newObj.setNotes(obj.getNotes());
		}
		if(obj.getGender() != null) {
			newObj.setGender(obj.getGender());
		}
		if(newObj.getPermission() != null) {
			newObj.setPermission(obj.getPermission());
		}
		if(obj.getAddress() != null) {
			newObj.setAddress(obj.getAddress());
		}			
	}	
}