package com.kevin.bora.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("Event")
public class Event extends MainPage{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

	public Event() {
	}

	public Event(Integer id, String name, String birth, String password, String notes, Category category, Address address) {
		super(id, name, birth, password, notes, address);
		this.category = category;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}