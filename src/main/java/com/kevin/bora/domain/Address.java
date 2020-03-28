package com.kevin.bora.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String number;
	private String complement;
	
	@ManyToOne
	@JoinColumn(name="neighborhood_id")
	private Neighborhood neighborhood;
	
	@OneToMany(mappedBy="address", cascade=CascadeType.ALL)
	private List<User> users = new ArrayList<>();
	
	@OneToMany(mappedBy="address", cascade=CascadeType.ALL)
	private List<Event> events= new ArrayList<>();

		
	public Address() {
	}
	
	public Address(Integer id, String number, String complement, Neighborhood neighborhood) {
		super();
		this.id = id;
		this.number = number;
		this.complement = complement;
		this.neighborhood = neighborhood;
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

	public Neighborhood getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(Neighborhood neighborhood) {
		this.neighborhood = neighborhood;
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
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}