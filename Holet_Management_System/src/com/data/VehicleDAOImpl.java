package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.Transport;
import com.model.Vehicle;

public class VehicleDAOImpl implements VehicleDAO{

	@Override
	public List<Vehicle> getVehicles() throws Exception {
List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("select * from vehicle order by id");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String vehicleName = rs.getString("vehicleName");			
				String vehicleNumber = rs.getString("vehicleNumber");
				String facilities = rs.getString("facilities");
				double cost = rs.getDouble("cost");								
				String vehicleType = rs.getString("vehicleType");
				
				
				Vehicle vehicle = new Vehicle(id, vehicleName, vehicleNumber, facilities,cost, vehicleType);
				
				vehicleList.add(vehicle);
				
			}
		}
		finally {
			close(rs, ps, con);
		}
		
		return vehicleList;
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
	public void addVehicle(Vehicle vehicle) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		
		

		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("insert into vehicle(vehicleName, vehicleNumber,facilities, cost, vehicleType) values( ?, ?, ?, ?, ?)");
			
			ps.setString(1, vehicle.getVehicleName());
			ps.setString(2, vehicle.getVehicleNumber());
			ps.setString(3, vehicle.getFacilities());
			ps.setDouble(4, vehicle.getCost());
				
			ps.setString(5, vehicle.getVehicleType());
			
			
			ps.executeUpdate();
		}
		finally {
			close(null, ps, con);
		}
		
		
	}

	@Override
	public void deleteVehicle(int id) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("delete from vehicle where id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
		}
		finally {
			close(null,ps,con);
		}
		
	}

	@Override
	public List<Vehicle> searchVehicles(String vehicleNumbers) throws Exception {
		List<Vehicle> searchList=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("select * from vehicle where vehicleNumber=?");
			ps.setString(1, vehicleNumbers);
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String vehicleName=rs.getString(2);
			
				String vehicleNumber=rs.getString(3);
				double cost = rs.getDouble(4);
		        String facilities=rs.getString(5);
		        String vehicleType=rs.getString(6);
		      
		        
		        Vehicle vehicle=new Vehicle(id, vehicleNumber, vehicleName, facilities, cost,vehicleType);
		        
		        searchList.add(vehicle);
			}
		}
		finally {
			close(rs,ps,con);
		}
		return searchList;
	}

	@Override
	public Vehicle getVehicle(int id) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Vehicle vehicle = null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("select * from vehicle where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				String vehicleName=rs.getString(2);
				String vehicleNumber=rs.getString(3);
				String facilities=rs.getString(4);
				double cost=rs.getDouble(5);
		        String vehicleType=rs.getString(6);
		      
		       
		        
		        vehicle =new Vehicle(id, vehicleName, vehicleNumber, facilities, cost, vehicleType);
		        
			}
			else {
				throw new Exception("Item Not Found");
			}
		}
		finally {
			close(rs,ps,con);
		}
		return vehicle;
	}

	@Override
	public void updateVehicle(Vehicle vehicle) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("update vehicle set vehicleName=?,vehicleNumber=?,facilities=?,cost=?,vehicleType=? where id=?");
			ps.setString(1, vehicle.getVehicleName());
			
			ps.setString(2, vehicle.getVehicleNumber());
			ps.setString(3,vehicle.getFacilities());
			ps.setDouble(4, vehicle.getCost());	
			ps.setString(5,vehicle.getVehicleType());
			ps.setInt(6,vehicle.getId());
			ps.executeUpdate();
		}
		finally {
			close(null,ps,con);
		}
		
	}

}
