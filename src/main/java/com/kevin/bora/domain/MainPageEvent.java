package com.kevin.bora.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("MainPageEvent")
public class MainPageEvent extends MainPage {
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name="event_id")
	private Event event;
	
	public MainPageEvent() {
	}

	public MainPageEvent(Integer id, Event event) {
		super(id);
		this.event = event;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}