package com.model;

import java.util.Date;

public class Transport {
	
	private int id;
	private String fullName;
	private String nic;
	private Date checkIn;
	private String email;
	private int noOfKm;
	private double cost;

	
	public Transport(String fullName, Date checkIn,String nic,double cost,String email, int noOfKm) {
		super();
		this.fullName = fullName;
		this.checkIn = checkIn;
		this.nic = nic;
		this.noOfKm = noOfKm;
		this.email = email;
		this.cost = cost;
	}
	public Transport(int id, String fullName, Date checkIn,String nic,double cost,String email, int noOfKm) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.checkIn = checkIn;
		this.nic = nic;
		this.noOfKm = noOfKm;
		this.email = email;
		this.cost = cost;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNoOfKm() {
		return noOfKm;
	}
	public void setNoOfKm(int noOfKm) {
		this.noOfKm = noOfKm;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Transport [id=" + id + ", fullName=" + fullName + ", nic=" + nic + ", checkIn=" + checkIn + ", email="
				+ email + ", noOfKm=" + noOfKm + ", cost=" + cost + "]";
	}
	
	

}
