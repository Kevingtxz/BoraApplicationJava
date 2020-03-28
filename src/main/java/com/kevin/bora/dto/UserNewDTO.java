package com.kevin.bora.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UserNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Length(min=5, max=50, message="O tamnho deve ser entre 5 e 50 caracteres")
	private String userName;
	
	@Length(min=5, max=20, message="O tamnho deve ser entre 5 e 20 caracteres")
	@NotEmpty
	private String name;
	
	@Length(min=5, max=50, message="O tamnho deve ser entre 5 e 50 caracteres")
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	@Length(min=6, max=6, message="A data não está como o esperado")
	private String birth;
	
	@NotEmpty
	@Length(min=5, max=50, message="O tamnho deve ser entre 5 e 30 caracteres")
	@Email(message="Email inválido")
	private String email;
	
	@NotEmpty
	@Length(min=8, max=255, message="O tamnho deve ser entre 8 e 255 caracteres")
	private String password;
	
	@NotEmpty
	@Length(max=300, message="O tamnho deve ser entre 0 e 300 caracteres")
	private String notes;
	
	@Length(max=1, message="O tamnho deve ser entre 0 e 1 caracteres")
	private String gender;
	
	@Length(max=10, message="O tamnho deve ser entre 0 e 10 caracteres")
	@NotEmpty
	private String number;
	
	private String complement;
	
	@NotEmpty
	private Integer neighborhoodId;
	
	@NotEmpty
	private String neighborhood;

	@NotEmpty
	private Integer cityId;
	
	@NotEmpty
	private Integer addressId;
	
	@NotEmpty
	private String phone1;
	private String phone2;
	
	public UserNewDTO() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Integer getNeighborhoodId() {
		return neighborhoodId;
	}

	public void setNeighborhoodId(Integer neighborhoodId) {
		this.neighborhoodId = neighborhoodId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}	
}