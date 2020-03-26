package com.kevin.bora.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.kevin.bora.domain.enums.Participation;
import com.kevin.bora.domain.enums.Permission;

@Entity
public class EventUsers implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer permission;
	private Integer participation;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	@OneToOne
	@JoinColumn(name="event_id")
	private Event event;
	
	public EventUsers() {
	}

	public EventUsers(Integer id, Permission permission, Participation participation, User user, Event event) {
		super();
		this.id = id;
		this.user = user;
		this.event = event;
		this.permission = permission.getCod();
		this.participation = participation.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPermission() {
		return permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	public Integer getParticipation() {
		return participation;
	}

	public void setParticipation(Integer participation) {
		this.participation = participation;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
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
		EventUsers other = (EventUsers) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}