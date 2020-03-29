package com.kevin.bora.dto;

public class ChatDTO {
	private String message;
	private Integer sender;

	public ChatDTO() {
	}
	
	public ChatDTO(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getSender() {
		return sender;
	}

	public void setSender(Integer sender) {
		this.sender = sender;
	}
}