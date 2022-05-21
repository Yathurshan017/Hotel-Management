package com.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.Room;
import com.data.ConnectionFactory;


public class RoomDAOImpl implements RoomDAO{

	@Override
	public List<Room> getRooms() throws Exception {
	List<Room> roomList = new ArrayList<Room>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("select * from rooms order by id");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String fullName = rs.getString("fullName");
				String address = rs.getString("address");
				String nic = rs.getString("nic");
				int members = rs.getInt("members");
				int noOfRooms = rs.getInt("noOfRooms");
				Date dateOfArrival = rs.getDate("dateOfArrival");
				Date dateOfDeparture = rs.getDate("dateOfDeparture");				
				String email = rs.getString("email");
				String roomType = rs.getString("roomType");
				int mobile = rs.getInt("mobile");
				
				Room room = new Room(id, fullName, address,nic, members, noOfRooms, dateOfArrival, dateOfDeparture, email,roomType, mobile);
				
				roomList.add(room);
				
			}
		}
		finally {
			close(rs, ps, con);
		}
		
		return roomList;
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
	public void addRoom(Room room) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		
		

		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("insert into rooms(fullName, address, nic, members, noOfRooms, dateOfArrival, dateOfDeparture, email,roomType, mobile) values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, room.getFullName());
			ps.setString(2, room.getAddress());
			ps.setString(3, room.getNic());
			ps.setInt(4, room.getMembers());
			ps.setInt(5, room.getNoOfRooms());
			ps.setTimestamp(6, new java.sql.Timestamp(room.getDateOfArrival().getTime()));
			ps.setTimestamp(7, new java.sql.Timestamp(room.getDateOfDeparture().getTime()));
			ps.setString(8, room.getEmail());
			ps.setString(9, room.getRoomType());
			ps.setInt(10, room.getMobile());
			
			
			ps.executeUpdate();
		}
		finally {
			close(null, ps, con);
		}
		
	}

	@Override
	public void deleteRoom(int id) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("delete from rooms where id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
		}
		finally {
			close(null,ps,con);
		}
		
	}

	@Override
	public List<Room> searchRooms(String fullname) throws Exception {
		List<Room> searchList=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("select * from rooms where fullName=?");
			ps.setString(1, fullname);
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String fullName=rs.getString(2);
				String address=rs.getString(3);
				String nic=rs.getString(4);
		        int members =rs.getInt(5);
		        int noOfRooms=rs.getInt(6);
		        Date dateOfArrival=rs.getDate(7);
		        Date dateOfDeparture=rs.getDate(8);
		        String email=rs.getString(9);
		        String roomType=rs.getString(10);
		        int mobile=rs.getInt(11);
		      
		        
		        Room room=new Room(id, fullName, address, nic, members, noOfRooms, dateOfArrival, dateOfDeparture, email,roomType, mobile);
		        
		        searchList.add(room);
			}
		}
		finally {
			close(rs,ps,con);
		}
		return searchList;
	}

	@Override
	public Room getRoom(int id) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Room room = null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("select * from rooms where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				String fullName=rs.getString(2);
				String address=rs.getString(3);
				String nic=rs.getString(4);
		        int members =rs.getInt(5);
		        int noOfRooms=rs.getInt(6);
		        Date dateOfArrival=rs.getDate(7);
		        Date dateOfDeparture=rs.getDate(8);
		        String email=rs.getString(9);
		        String roomType=rs.getString(10);
		        int mobile=rs.getInt(11);
		       
		        
		        room=new Room(id, fullName, address, nic, members, noOfRooms, dateOfArrival, dateOfDeparture, email,roomType,mobile);
		        
			}
			else {
				throw new Exception("Item Not Found");
			}
		}
		finally {
			close(rs,ps,con);
		}
		return room;
	}

	@Override
	public void updateRoom(Room room) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("update rooms set fullName=?,address=?,nic=?,members=?,noOfRooms=?,dateOfArrival=?,dateOfDeparture=?,email=?,roomType=?,mobile=? where id=?");
			ps.setString(1, room.getFullName());
			ps.setString(2,room.getAddress());
			ps.setString(3, room.getNic());
			ps.setInt(4, room.getMembers());
			ps.setInt(5,room.getNoOfRooms());
			ps.setTimestamp(6, new java.sql.Timestamp(room.getDateOfArrival().getTime()));
			ps.setTimestamp(7, new java.sql.Timestamp(room.getDateOfDeparture().getTime()));
			ps.setString(8,room.getEmail());
			ps.setString(9,room.getRoomType());
			ps.setInt(10,room.getMobile());
			ps.setInt(11,room.getId());
			ps.executeUpdate();
		}
		finally {
			close(null,ps,con);
		}
		
	}

		
	

}
