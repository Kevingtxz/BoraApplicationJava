package com.kevin.bora.dto;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.kevin.bora.domain.Event;

public class EventDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String date;
	private String time;
	
	public EventDTO() {
	}

	public EventDTO(Integer id, String name, String date, String time) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.time = time;
	}
	
	public EventDTO(Event event) {
		super();
		this.id = event.getId();
		this.name = event.getName();
		this.date = event.getDate();
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
}