package com.data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.model.Employee;
import com.data.ConnectionFactory;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public List<Employee> getEmployees() throws Exception {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("select * from employee order by id");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String fullName = rs.getString("fullName");
				String address = rs.getString("address");
				String nic = rs.getString("nic");
				String employeeId = rs.getString("employeeId");
				String jobPost = rs.getString("jobPost");
				Date dateOfBirth = rs.getDate("dateOfBirth");				
				String email = rs.getString("email");
				int mobile = rs.getInt("mobile");
				
				Employee employee = new Employee(id, fullName, address,nic, employeeId, jobPost, dateOfBirth, email, mobile);
				
				employeeList.add(employee);
				
			}
		}
		finally {
			close(rs, ps, con);
		}
		
		return employeeList;
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
	public void addEmployee(Employee employee) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		
		

		try {
			
			con = ConnectionFactory.getCon();
			ps = con.prepareStatement("insert into employee(fullName, address, nic, employeeId, jobPost, dateOfBirth, email, mobile) values( ?, ?, ?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, employee.getFullName());
			ps.setString(2, employee.getAddress());
			ps.setString(3, employee.getNic());
			ps.setString(4, employee.getEmployeeId());
			ps.setString(5, employee.getJobPost());
			ps.setTimestamp(6, new java.sql.Timestamp(employee.getDateOfBirth().getTime()));
			ps.setString(7, employee.getEmail());
			ps.setInt(8, employee.getMobile());
			
			
			ps.executeUpdate();
			
		}
		finally {
			close(null, ps, con);
		}
	}

	@Override
	public void deleteEmployee(int id) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("delete from employee where id=?");
			ps.setInt(1,id);
			ps.executeUpdate();
		}
		finally {
			close(null,ps,con);
		}
		
	}

	@Override
	public List<Employee> searchEmployees(String fullname) throws Exception {
		List<Employee> searchList=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("select * from employee where fullName=?");
			ps.setString(1, fullname);
			rs=ps.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String fullName=rs.getString(2);
				String address=rs.getString(3);
				String nic=rs.getString(4);
				String employeeId=rs.getString(5);
				String jobPost=rs.getString(6);
		        Date dateOfBirth=rs.getDate(7);
		        String email=rs.getString(8);
		        int mobile=rs.getInt(9);
		      
		        
		        Employee employee=new Employee(id, fullName, address, nic, employeeId, jobPost,dateOfBirth, email, mobile);
		        
		        searchList.add(employee);
			}
		}
		finally {
			close(rs,ps,con);
		}
		return searchList;
	}

	@Override
	public Employee getEmployee(int id) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Employee employee = null;
		try {
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("select * from employee where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				String fullName=rs.getString(2);
				String address=rs.getString(3);
				String nic=rs.getString(4);
				String employeeId=rs.getString(5);
				String jobPost=rs.getString(6);
		        Date dateOfBirth=rs.getDate(7);
		        String email=rs.getString(8);
		        int mobile=rs.getInt(9);
		       
		        
		        employee=new Employee(id, fullName, address, nic, employeeId, jobPost, dateOfBirth, email,mobile);
		        
			}
			else {
				throw new Exception("Item Not Found");
			}
		}
		finally {
			close(rs,ps,con);
		}
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=ConnectionFactory.getCon();
			ps=con.prepareStatement("update employee set fullName=?,address=?,nic=?,employeeId=?,jobPost=?,dateOfBirth=?,email=?,mobile=? where id=?");
			ps.setString(1, employee.getFullName());
			ps.setString(2,employee.getAddress());
			ps.setString(3, employee.getNic());
			ps.setString(4, employee.getEmployeeId());
			ps.setString(5,employee.getJobPost());
			ps.setTimestamp(6, new java.sql.Timestamp(employee.getDateOfBirth().getTime()));
			ps.setString(7,employee.getEmail());
			ps.setInt(8,employee.getMobile());
			ps.setInt(9,employee.getId());
			ps.executeUpdate();
		}
		finally {
			close(null,ps,con);
		}
		
	}

}
