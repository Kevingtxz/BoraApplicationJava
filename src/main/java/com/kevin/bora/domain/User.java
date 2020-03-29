package com.kevin.bora.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kevin.bora.domain.enums.Permission;

@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String lastName;
	private String birth;
	private String password;
	private String notes;
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

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="eventUsers_id")
	private EventUsers eventUsers;

	@JsonIgnore
	@ManyToMany(mappedBy="users")
	private List<Chat> chats = new ArrayList<>();
	
	/*
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="mainPageUser_id")
	private MainPageUser mainPageUser;

 	private List<Location> location = new ArrayList<>();
*/		
	public User() {
	}
	
	public User(Integer id, String userName, String name, String lastName, String birth, String email, String password, String notes,
			String gender, Permission permission, Address address) {
		super();
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.lastName = lastName;
		this.birth = birth;
		this.email = email;
		this.password = password;
		this.notes = notes;
		this.gender = gender;
		this.permission =  (permission==null) ? Permission.USER.getCod() : permission.getCod();
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

	public Set<String> getPhones() {
		return phones;
	}
	
	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	public EventUsers getEventUsers() {
		return eventUsers;
	}

	public void setEventUsers(EventUsers eventUsers) {
		this.eventUsers = eventUsers;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public List<Chat> getChats() {
		return chats;
	}

	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}

	/*
	public MainPageUser getMainPageUser() {
		return mainPageUser;
	}

	public void setMainPageUser(MainPageUser mainPageUser) {
		this.mainPageUser = mainPageUser;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}