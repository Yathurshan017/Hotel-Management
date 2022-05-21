package com.model;
import java.util.Date;

public class Room {
	
	private int id;
	private String fullName;
	private String address;
	private String nic;
	private int members;
	private int noOfRooms;
	private Date dateOfArrival;
	private Date dateOfDeparture;
	private String email;
	private String roomType;
	private int mobile;

	
	public Room(String fullName, String address,String nic, int members, int noOfRooms, 
			Date dateOfArrival, Date dateOfDeparture, String email,String roomType, int mobile) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.nic = nic;
		this.members = members;
		this.noOfRooms = noOfRooms;
		this.dateOfArrival = dateOfArrival;
		this.dateOfDeparture = dateOfDeparture;
		this.email = email;
		this.roomType = roomType;
		this.mobile = mobile;
		
		
	}

	public Room(int id, String fullName, String address,String nic, int members, int noOfRooms,
			 Date dateOfArrival, Date dateOfDeparture, String email,String roomType,int mobile) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.nic = nic;
		this.members = members;
		this.noOfRooms = noOfRooms;
		this.dateOfArrival = dateOfArrival;
		this.dateOfDeparture = dateOfDeparture;
		this.email = email;
		this.roomType = roomType;
		this.mobile = mobile;
		
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public Date getDateOfArrival() {
		return dateOfArrival;
	}

	public void setDateOfArrival(Date dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", fullName=" + fullName + ", address=" + address + ", nic=" + nic + ", members="
				+ members + ", noOfRooms=" + noOfRooms + ", dateOfArrival=" + dateOfArrival + ", dateOfDeparture="
				+ dateOfDeparture + ", email=" + email + ", roomType=" + roomType + ", mobile=" + mobile + "]";
	}
	

}
