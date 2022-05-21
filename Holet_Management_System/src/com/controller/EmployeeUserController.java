package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeUserController
 */
@WebServlet("/EmployeeUserController")
public class EmployeeUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public EmployeeUserController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			String command = request.getParameter("command");
			
			switch(command) {
				
				case "LOGOUT":
					logout(request, response);
					break;
			}
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}
	
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		doGet(request,response);
		
		PrintWriter out = response.getWriter();
		String Username = request.getParameter("Username");
		String pwd = request.getParameter("Password");
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery ("select Username,Password from users where Username='"+Username+"' and Password='"+pwd+"'");
			
			if(Username.equals("Admin") && pwd.equals("Admin")) {
				response.sendRedirect("employee-home.jsp");
				
			}
			else {
				request.setAttribute("error", "Invalid User Name or Password");
//              String errorMsg=(String)request.getAttribute("ErrorMessage");
              RequestDispatcher dispatcher =  request.getRequestDispatcher("employee-admin-login.jsp");
              dispatcher.forward(request, response);
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
private void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		String resource = "employee-admin-login.jsp";
		String message = null;
		
		session.invalidate();
		message = "Successfully Logged Out";
		RequestDispatcher rd = request.getRequestDispatcher(resource);
		request.setAttribute("msg", message);			
		
		rd.forward(request, response);

//		String resource = "login.jsp";
//		String message = null;
//		
//		if(session.isNew()) {
//			message = "Session Expired : TRY AGAIN";
//			RequestDispatcher rd = request.getRequestDispatcher(resource);
//			request.setAttribute("msg", message);			
//			
//			rd.forward(request, response);
//		}
		
	}

}
