package com.kevin.bora.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.kevin.bora.domain.enums.Permission;

@Entity
@JsonTypeName("User")
public class User extends MainPage {
	private static final long serialVersionUID = 1L;
	

	private String lastName;
	private String gender;
	
	private Integer permission; 

	@Column(unique=true)
	private String userName;
	@Column(unique=true)
	private String email;
	
	@JsonIgnore
	@ElementCollection
	@CollectionTable(name="Phones")
	private Set<String> phones = new HashSet<>();
	
	public User() {
	}
	
	public User(Integer id, String userName, String name, String lastName, String birth, String email, String password, String notes, String gender,
			Permission permission, Address address) {
		super(id, name, birth, password, notes, address);
		this.lastName = lastName;
		this.gender = gender;
		this.permission = permission.getCod();
		this.userName = userName;
		this.email = email;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<String> getPhones() {
		return phones;
	}
	
	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}
	
	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}