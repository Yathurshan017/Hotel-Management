package com.model;

import java.io.Serializable;

public class Register implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String FirstName;
    private String LastName;
    private String Address;
    private String Username;
    private String Password;
    private String Confirmpassword;
    private String ContactNo;
    private String Email;
    
    
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public String getConfirmPassword() {
		return Confirmpassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		Confirmpassword = confirmPassword;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
    
   
	

	
    
    
    
	
}
