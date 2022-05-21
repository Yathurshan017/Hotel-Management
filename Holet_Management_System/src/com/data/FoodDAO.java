package com.data;

import java.util.List;

import com.model.Food;

public interface FoodDAO {
public List<Food> getFoods() throws Exception;
	
//	void addItem(HttpServletRequest request) throws Exception;
	
	void addFood(Food food) throws Exception;
	
	public void deleteFood(int id) throws Exception;
	
	public List<Food> searchFoods(String foodname) throws Exception;
	
	public Food getFood(int id) throws Exception;
	
	public void updateFood(Food food) throws Exception;

}
