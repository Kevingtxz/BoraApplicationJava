package com.kevin.bora.dto;

import javax.validation.constraints.NotEmpty;

import com.kevin.bora.domain.City;
import com.kevin.bora.domain.Neighborhood;

public class AddressNewDTO {
	
	@NotEmpty
	private String number;
	@NotEmpty
	private String complement;
	@NotEmpty
	private City city;
	@NotEmpty
	private Neighborhood neighborhood;

	public AddressNewDTO(){
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Neighborhood getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(Neighborhood neighborhood) {
		this.neighborhood = neighborhood;
	}
}