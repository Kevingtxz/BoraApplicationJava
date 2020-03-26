package com.kevin.bora.domain.domain;

import java.util.Date;

public class Notification {

	private Integer id;
	private Date date;
	private String title;
	private boolean invitation;

	
/*
 	private User user;
 	
 	private Event event;
 */

	public Notification() {
	}

	public Notification(Integer id, String title, boolean invitation) {
		super();
		this.id = id;
		this.date = new java.util.Date(System.currentTimeMillis());
		this.title = title;
		this.invitation = invitation;
	}
 }
