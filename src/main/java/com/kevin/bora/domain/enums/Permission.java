package com.kevin.bora.domain.enums;

public enum Permission {

	OWNER(1, "Owner"),
	MANAGER(2, "Manager"),
	USER(3, "User"),
	LIMITEDUSER(4, "Limited User"),
	BLOQUEAD(5, "Bloquead");
	
	private int cod;
	private String description;
	
	private Permission(int cod, String description) {
		this.cod = cod;
		this.description = description;		
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	public static Permission toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}	
		for(Permission x : Permission.values()) {
			if(cod.equals(x.getCod()));
				return x;
		}
		throw new IllegalArgumentException("Id invalid : "+cod);
	}
}