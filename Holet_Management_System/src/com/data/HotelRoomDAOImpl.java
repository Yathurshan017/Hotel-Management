package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.HotelRoom;


public class HotelRoomDAOImpl implements HotelRoomDAO{

	@Override
	public List<HotelRoom> getHotelRooms() throws Exception {
		List<HotelRoom> hotelroomList = new ArrayList<HotelRoom>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("select * from hotelroom order by id");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String roomType = rs.getString("roomType");
				String facilities = rs.getString("facilities");
				double cost = rs.getDouble("cost");				
				
				
				HotelRoom hotelroom = new HotelRoom(id, roomType,facilities, cost);
				
				hotelroomList.add(hotelroom);
				
			}
		}
		finally {
			close(rs, ps, con);
		}
		
		return hotelroomList;
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
	public void addHotelRoom(HotelRoom hotelroom) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		
		

		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("insert into hotelroom(roomType, facilities, cost) values( ?, ?, ?)");
			
			ps.setString(1, hotelroom.getRoomType());
			ps.setString(2, hotelroom.getFacilities());
			ps.setDouble(3, hotelroom.getCost());
			
			
			
			ps.executeUpdate();
		}
		finally {
			close(null, ps, con);
		}
		
		
	}

	@Override
	public void deleteHotelRoom(int id) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("delete from hotelroom where id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
		}
		finally {
			close(null,ps,con);
		}
		
	}

	@Override
	public List<HotelRoom> searchHotelRooms(String roomtype) throws Exception {
		List<HotelRoom> searchList=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("select * from hotelroom where roomType=?");
			ps.setString(1, roomtype);
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String roomType=rs.getString(2);
				
				String facilities=rs.getString(3);
				double cost = rs.getDouble(4);
		      
		      
		        
		        HotelRoom hotelroom=new HotelRoom(id, roomType, facilities, cost);
		        
		        searchList.add(hotelroom);
			}
		}
		finally {
			close(rs,ps,con);
		}
		return searchList;
	}

	@Override
	public HotelRoom getHotelRoom(int id) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		HotelRoom hotelroom = null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("select * from hotelroom where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				String roomType=rs.getString(2);
				
				String facilities=rs.getString(3);
				double cost=rs.getDouble(4);
		       
		       
		        
		        hotelroom=new HotelRoom(id, roomType, facilities, cost);
		        
			}
			else {
				throw new Exception("Item Not Found");
			}
		}
		finally {
			close(rs,ps,con);
		}
		return hotelroom;
	}

	@Override
	public void updateHotelRoom(HotelRoom hotelroom) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("update hotelroom set roomType=?,facilities=?,cost=? where id=?");
			ps.setString(1, hotelroom.getRoomType());
			ps.setString(2, hotelroom.getFacilities());
			ps.setDouble(3, hotelroom.getCost());
		
			ps.setInt(4,hotelroom.getId());
			ps.executeUpdate();
		}
		finally {
			close(null,ps,con);
		}
		
	}

}
