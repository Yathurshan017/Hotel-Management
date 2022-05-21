package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.Buy;



public class BuyDAOImpl implements BuyDAO{

	@Override
	public List<Buy> getBuys() throws Exception {
List<Buy> buyList = new ArrayList<Buy>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("select * from buyfood order by id");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String foodName = rs.getString("foodName");
				int qty = rs.getInt("qty");
				double unitPrice = rs.getDouble("unitPrice");				
				double totalPrice = rs.getDouble("totalPrice");
				
				
				Buy buy = new Buy(id, foodName,qty,unitPrice, totalPrice);
				
				buyList.add(buy);
				
			}
		}
		finally {
			close(rs, ps, con);
		}
		
		return buyList;
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
	public void addBuy(Buy buy) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		
		

		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("insert into buyfood(foodName, qty,unitPrice, totalPrice) values( ?, ?, ?, ?)");
			
			ps.setString(1, buy.getFoodName());
			ps.setInt(2, buy.getQty());
			ps.setDouble(3, buy.getUnitPrice());
			ps.setDouble(4, buy.getTotalPrice());
					
			
			
			
			ps.executeUpdate();
		}
		finally {
			close(null, ps, con);
		}
		
	}

	@Override
	public void deleteBuy(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Buy> searchBuys(String fullName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Buy getBuy(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBuy(Buy buy) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
