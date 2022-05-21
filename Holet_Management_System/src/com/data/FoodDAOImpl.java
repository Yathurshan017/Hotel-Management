package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.Food;


public class FoodDAOImpl implements FoodDAO{

	@Override
	public List<Food> getFoods() throws Exception {
		List<Food> foodList = new ArrayList<Food>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("select * from food order by id");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String foodName = rs.getString("foodName");
				String foodCode = rs.getString("foodCode");
				String description = rs.getString("description");
				
				
				Food food = new Food(id, foodName, foodCode,description);
				
				foodList.add(food);
				
			}
		}
		finally {
			close(rs, ps, con);
		}
		
		return foodList;
	}

	private void close(ResultSet rs, PreparedStatement ps, Connection con) {
		
		try {
			
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
			
		}
		catch(Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public void addFood(Food food) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		
		

		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("insert into food(foodName, foodCode,description) values( ?, ?, ?)");
			
			ps.setString(1, food.getFoodName());
			ps.setString(2, food.getFoodCode());
			ps.setString(3, food.getDescription());
			
			
			
			ps.executeUpdate();
		}
		finally {
			close(null, ps, con);
		}
		
	}

	@Override
	public void deleteFood(int id) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("delete from food where id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
		}
		finally {
			close(null,ps,con);
		}
		
	}

	@Override
	public List<Food> searchFoods(String foodname) throws Exception {
		List<Food> searchList=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("select * from food where foodName=?");
			ps.setString(1, foodname);
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String foodName=rs.getString(2);
				
				String foodCode=rs.getString(3);
			
		        String description=rs.getString(4);
		       
		      
		        
		        Food food=new Food(id, foodName, foodCode, description);
		        
		        searchList.add(food);
			}
		}
		finally {
			close(rs,ps,con);
		}
		return searchList;
	}

	@Override
	public Food getFood(int id) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Food food = null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("select * from food where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				String foodName=rs.getString(2);
				
				String foodCode=rs.getString(3);
				
		        String description=rs.getString(4);
		  
		       
		        
		        food=new Food(id, foodName, foodCode, description);
		        
			}
			else {
				throw new Exception("Item Not Found");
			}
		}
		finally {
			close(rs,ps,con);
		}
		return food;
	}

	@Override
	public void updateFood(Food food) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("update food set foodName=?,foodCode=?,description=? where id=?");
			ps.setString(1, food.getFoodName());
			ps.setString(2, food.getFoodCode());
			ps.setString(3, food.getDescription());
			ps.setInt(4,food.getId());
			ps.executeUpdate();
		}
		finally {
			close(null,ps,con);
		}
		
	}

}
