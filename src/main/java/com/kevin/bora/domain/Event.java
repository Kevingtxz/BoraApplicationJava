package com.kevin.bora.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Event  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String date;
	private String time;
	
	@JsonBackReference	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name="eventusers_id")
	private EventUsers eventUsers;

	/*
	@OneToMany
	private List<Status> status = new ArrayList<>();
	
	@OneToMany
	private List<Category> = new ArrayList<>();
	
	
	@ManyToMany
	private List<Users> users = new ArrayList<>();
*/
	public Event() {
	}

	public Event(Integer id, String name, String date, String time, Category category, Address address) {
	super();
	this.id = id;
	this.name = name;
	this.date = date;
	this.time = time;
	this.category = category;
	this.address = address;
}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public EventUsers getEventUsers() {
		return eventUsers;
	}

	public void setEventUsers(EventUsers eventUsers) {
		this.eventUsers = eventUsers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	 
	
}