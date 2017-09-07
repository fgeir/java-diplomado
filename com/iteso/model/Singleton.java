package com.iteso.model;

public class Singleton {
	
	private static Singleton instance = null; // new Singleton();

	private String username = "", password = "";
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Singleton() {
		System.out.println("Singleton created");
	}

	public static Singleton getInstance() {
		if(instance == null) instance = new Singleton();
		return instance;
	}
	
}
