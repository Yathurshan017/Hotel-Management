package com.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.model.Transport;

public class TransportDAOImpl implements TransportDAO{

	@Override
	public List<Transport> getTransports() throws Exception {
		List<Transport> transportList = new ArrayList<Transport>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("select * from transport order by id");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String fullName = rs.getString("fullName");
				Date chekcIn = rs.getDate("checkIn");
				String nic = rs.getString("nic");
				double cost = rs.getDouble("cost");				
				String email = rs.getString("email");
				int noOfKm = rs.getInt("noOfKm");
				
				Transport transport = new Transport(id, fullName, chekcIn,nic,cost, email, noOfKm);
				
				transportList.add(transport);
				
			}
		}
		finally {
			close(rs, ps, con);
		}
		
		return transportList;
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
	public void addTransport(Transport transport) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		
		

		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("insert into transport(fullName, checkIn,nic, cost, email, noOfKm) values( ?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, transport.getFullName());
			ps.setTimestamp(2, new java.sql.Timestamp(transport.getCheckIn().getTime()));
			ps.setString(3, transport.getNic());
			ps.setDouble(4, transport.getCost());
			ps.setString(5, transport.getEmail());		
			ps.setInt(6, transport.getNoOfKm());
			
			
			ps.executeUpdate();
		}
		finally {
			close(null, ps, con);
		}
		
	}

	@Override
	public void deleteTransport(int id) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("delete from transport where id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
		}
		finally {
			close(null,ps,con);
		}
		
	}

	@Override
	public List<Transport> searchTransports(String fullname) throws Exception {
		List<Transport> searchList=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("select * from transport where fullName=?");
			ps.setString(1, fullname);
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String fullName=rs.getString(2);
				Date checkIn=rs.getDate(3);
				String nic=rs.getString(4);
				double cost = rs.getDouble(5);
		        String email=rs.getString(6);
		        int noOfKm=rs.getInt(7);
		      
		        
		        Transport transport=new Transport(id, fullName, checkIn, nic, cost, email, noOfKm);
		        
		        searchList.add(transport);
			}
		}
		finally {
			close(rs,ps,con);
		}
		return searchList;
	}

	@Override
	public Transport getTransport(int id) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Transport transport = null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("select * from transport where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				String fullName=rs.getString(2);
				Date checkIn=rs.getDate(3);
				String nic=rs.getString(4);
				double cost=rs.getDouble(5);
		        String email=rs.getString(6);
		        int noOfKm=rs.getInt(7);
		       
		        
		        transport=new Transport(id, fullName, checkIn, nic, cost, email,noOfKm);
		        
			}
			else {
				throw new Exception("Item Not Found");
			}
		}
		finally {
			close(rs,ps,con);
		}
		return transport;
	}

	@Override
	public void updateTransport(Transport transport) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("update transport set fullName=?,checkIn=?,nic=?,cost=?,email=?,noOfKm=? where id=?");
			ps.setString(1, transport.getFullName());
			ps.setTimestamp(2, new java.sql.Timestamp(transport.getCheckIn().getTime()));
			ps.setString(3, transport.getNic());
			ps.setDouble(4, transport.getCost());
			ps.setString(5,transport.getEmail());
			ps.setInt(6,transport.getNoOfKm());
			ps.setInt(7,transport.getId());
			ps.executeUpdate();
		}
		finally {
			close(null,ps,con);
		}
		
		
	}

}
