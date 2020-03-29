package com.kevin.bora.dto;

public class ChatDTO {
	private Integer id;
	private String message;
	private Integer receptor;

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

	public Integer getReceptor() {
		return receptor;
	}

	public void setReceptor(Integer receptor) {
		this.receptor = receptor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}