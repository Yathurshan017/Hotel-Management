package com.model;

public class HotelRoom {
	
	private int id;
	private String roomType;
	private String facilities;
	private double cost;
	
	
	public HotelRoom(String roomType,String facilities,double cost) {
		super();
		this.roomType = roomType;
		this.facilities = facilities;
		this.cost = cost;
	}
	
	public HotelRoom(int id, String roomType,String facilities,double cost) {
		super();
		this.id = id;
		this.roomType = roomType;
		this.facilities = facilities;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "HotelRoom [id=" + id + ", roomType=" + roomType + ", facilities=" + facilities + ", cost=" + cost + "]";
	}
	
	

}
