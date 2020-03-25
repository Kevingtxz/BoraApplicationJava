package com.kevin.bora.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String number;
	private String complement;
	private String neighborhood;
	
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@OneToOne(mappedBy="address")
	private User user;
	

	@OneToOne(mappedBy="address")
	private Event event;

	public Address() {
	}
	
	public Address(Integer id, String number, String complement, String neighborhood, City city) {
		super();
		this.id = id;
		this.number = number;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public User getuser() {
		return user;
	}

	public void setuser(User user) {
		this.user = user;
	}
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

/*
	public Event getevent() {
		return event;
	}

	public void setevent(Event event) {
		this.event = event;
	}
*/

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
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}