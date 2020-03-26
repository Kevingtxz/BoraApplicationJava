package com.kevin.bora.domain.enums;

public enum Participation {
	
	NOTHING(0, "Nothing"),
	FOLLOWER(1, "Follower"),
	ACTIVE(2, "Active"),
	MEMBER(3,"Member"),
	HIGHMEMBER(4, "High level member");
	
	private int cod;
	private String description;
	
	private Participation(int cod, String description) {
		this.cod = cod;
		this.description = description;		
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	public static Participation toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}	
		for(Participation x : Participation.values()) {
			if(cod.equals(x.getCod()));
				return x;
		}
		throw new IllegalArgumentException("Id invalid : "+cod);
	}
}