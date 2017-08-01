package com.gtm.proxybanque.metier;

public class Action {

	private String code;
	private String name;
	private float prix;
	
	public Action(String code, String name, float prix) {
		super();
		this.name = name;
		this.prix = prix;
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Action [name=" + name + ", prix=" + prix + "]";
	}
	
	
	
}
