package com.kevin.bora.domain.enums;

public enum Permission {

	USER(0, "Usuário Padrão"),
	OWNER(1, "Proprietário"),
	MANAGER(2, "Gerente"),
	LIMITEDUSER(4, "Uso limitado"),
	BLOQUEAD(5, "Bloqueado");	
	
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