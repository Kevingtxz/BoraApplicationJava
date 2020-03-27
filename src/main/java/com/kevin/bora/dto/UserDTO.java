package com.kevin.bora.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import com.kevin.bora.domain.City;
import com.kevin.bora.domain.EventUsers;
import com.kevin.bora.domain.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@Length(min=5, max=30, message="O tamnho deve ser entre 5 e 30 caracteres")
	private String userName;
	@Length(min=5, max=50, message="O tamnho deve ser entre 5 e 30 caracteres")
	@Email(message="Email inválido")
	private String email;
	@Length(min=8, max=255, message="O tamnho deve ser entre 8 e 255 caracteres")
	private String password;
	@Length(max=300, message="O tamnho deve ser entre 0 e 300 caracteres")
	private String notes;
	private Integer permission; 
	private City city;
	private EventUsers eventUsers;
	private String gender;

	public UserDTO() {
	}

	public UserDTO(User obj) {
		this.id = obj.getId();
		this.userName = obj.getUserName();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.notes = obj.getNotes();
		this.setGender(obj.getGender());
		this.permission = obj.getPermission();
		this.city = obj.getCity();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public EventUsers getEventUsers() {
		return eventUsers;
	}

	public void setEventUsers(EventUsers eventUsers) {
		this.eventUsers = eventUsers;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}