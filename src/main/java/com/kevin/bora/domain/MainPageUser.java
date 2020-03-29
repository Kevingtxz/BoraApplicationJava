package com.kevin.bora.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("MainPageUser")
public class MainPageUser extends MainPage {
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public MainPageUser() {
	}

	public MainPageUser(Integer id, User user) {
		super(id);
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}