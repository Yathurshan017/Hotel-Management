package com.model;

public class Buy {
	
	private int id;
	private String foodName;
	private int qty;
	private double unitPrice;
	private double totalPrice;
	
	public Buy(String foodName, int qty, double unitPrice, double totalPrice) {
		super();
		this.foodName = foodName;
		this.qty = qty;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}
	public Buy(int id, String foodName, int qty, double unitPrice, double totalPrice) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.qty = qty;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Buy [id=" + id + ", foodName=" + foodName + ", qty=" + qty + ", unitPrice=" + unitPrice
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	

}
