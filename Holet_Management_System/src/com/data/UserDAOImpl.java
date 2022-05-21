package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public void addUser(User user) throws Exception {
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("insert into users values(?,?,?,?,?,?,?,?)");
			
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getConfirmpassword());
			ps.setString(7, user.getContact());
			ps.setString(8, user.getEmail());
					
			ps.executeUpdate();
			
		}
		finally {
			close(null, ps, con);
		}
		
	}

	@Override
	public User getUser(String username) throws Exception {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("select * from users where Username =?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setFirstName(rs.getString(1));
				user.setLastName(rs.getString(2));
				user.setAddress(rs.getString(3));
				user.setUsername(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setConfirmpassword(rs.getString(6));
				user.setContact(rs.getString(7));
				user.setEmail(rs.getString(8));
				
			}
			else {
				throw new Exception("Invalid user id");
			}
		}
		finally {
			close(rs, ps, con);
		}
		
		return user;
	}
	
	private void close(ResultSet rs, PreparedStatement ps, Connection con) {
		try {
			if(rs != null) {
				rs.close();
			}
			if( ps != null) {
				ps.close();
			}
			if(con != null) {
				con.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
