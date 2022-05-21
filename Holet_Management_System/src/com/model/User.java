package com.model;

public class User {
	
	private String firstName;
	private String lastName;
	private String address;
	private String username;
	private String password;
	private String confirmpassword;
	private String contact;
	private String email;
	
	
	
	
	public User() {
		
	}
	public User(String username, String password, String confirmpassword, String firstName, String lastName, String address, String contact, String email) {
		super();
		this.username = username;
		this.password = password;
		this.password = confirmpassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contact = contact;
		this.email = email;
	}
	public User(String username, String firstName, String lastName, String address, String contact, String email) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contact = contact;
		this.email = email;
	}
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return contact;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "user [userId=" + username + ", password=" + password + ",confirmpassword=" + confirmpassword + ", firstName=" + firstName + ", lastName="
				+ lastName + ", address=" + address + ", contact=" + contact + ", email=" + email + "]";
	}
	
	
	
	

}
