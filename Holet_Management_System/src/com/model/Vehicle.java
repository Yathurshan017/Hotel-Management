package com.model;

import java.util.Date;

import com.mysql.cj.jdbc.Blob;

public class Vehicle {
	
	private int id;
	private String vehicleName;
	private String vehicleNumber;
	private String facilities;
	private String vehicleType;
	private double cost;
	

	
	public Vehicle(String vehicleName,String vehicleNumber, String facilities,double cost,String vehicleType) {
		super();
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.facilities = facilities;
	
		this.vehicleType = vehicleType;
		this.cost = cost;
	}
	public Vehicle(int id, String vehicleName,String vehicleNumber, String facilities,double cost,String vehicleType) {
		super();
		this.id = id;
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.facilities = facilities;
		this.vehicleType = vehicleType;

		this.cost = cost;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vehicleName=" + vehicleName + ", vehicleNumber=" + vehicleNumber
				+ ", facilities=" + facilities + ", vehicleType=" + vehicleType + ", cost=" + cost + "]";
	}
	
	
	
	
	

}
