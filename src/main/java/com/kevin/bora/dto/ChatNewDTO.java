package com.kevin.bora.dto;

import java.io.Serializable;
import java.util.List;

public class ChatNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private List<Integer> mainPages_ids;

	public ChatNewDTO() {
	}

	public ChatNewDTO(List<Integer> mainPages_ids) {
		super();
		this.mainPages_ids = mainPages_ids;
	}

	public List<Integer> getMainPages_ids() {
		return mainPages_ids;
	}

	public void setMainPages_ids(List<Integer> mainPages_ids) {
		this.mainPages_ids = mainPages_ids;
	}
}