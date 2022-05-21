package com.model;

import java.util.Date;

public class Food {
	
	private int id;
	private String foodName;
	private String foodCode;
	private String description;
	
	public Food(String foodName, String foodCode, String description) {
		super();
		this.foodName = foodName;
		this.foodCode = foodCode;
		this.description = description;
	}
	public Food(int id, String foodName, String foodCode, String description) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.foodCode = foodCode;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodCode() {
		return foodCode;
	}
	public void setFoodCode(String foodCode) {
		this.foodCode = foodCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", foodName=" + foodName + ", foodCode=" + foodCode + ", description=" + description
				+ "]";
	}
	
	

}
