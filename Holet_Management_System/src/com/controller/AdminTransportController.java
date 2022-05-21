package com.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.TransportDAOImpl;
import com.model.Transport;

/**
 * Servlet implementation class AdminTransportController
 */
@WebServlet("/AdminTransportController")
public class AdminTransportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	TransportDAOImpl transportUtil;
	
	
	String message = null;
	
	@Override
	public void init() throws ServletException {

		super.init();
		transportUtil = new TransportDAOImpl();
    }
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {
				
			String COMMAND = request.getParameter("COMMAND");
			
			if(COMMAND == null) {
				COMMAND = "LIST";
			}
			
			switch(COMMAND) {
				
			case "LIST":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					listTransport(request, response);
				}
				break;
				
				
				
			case "ADD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					addTransport(request, response);
				}
				break;
				
			case "DELETE":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					deleteTransport(request,response);
				}
				break;
			
			case "SEARCH":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					SearchTransport(request,response);
				}
				break;
				
			case "LOAD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					loadTransport(request,response);
				}
				break;
				
			case "UPDATE": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					updateTransport(request,response);
				}
				break;
				
			case "CHECK": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					checkTransport(request,response);
				}
				break;
				
			default:
				listTransport(request, response);
			}
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
	
	private void checkTransport(HttpServletRequest request, HttpServletResponse response) throws Exception {

		RequestDispatcher rd=request.getRequestDispatcher("admin-add-new-transport.jsp");
		rd.forward(request, response);
		
	}


	private void sessionChecker(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void loadTransport(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		Transport transport=transportUtil.getTransport(id);
		request.setAttribute("TRANSPORT",transport);
		RequestDispatcher rd=request.getRequestDispatcher("admin-update-vehicle-booking.jsp");
		rd.forward(request, response);
		
		
	}

	private void updateTransport(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		String fullName=request.getParameter("fullName");
		String checkIn=request.getParameter("checkIn");
		String nic=request.getParameter("nic");
		double cost=Double.parseDouble(request.getParameter("cost"));	
		String email=request.getParameter("email");
		int noOfKm= Integer.parseInt(request.getParameter("noOfKm"));
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dom=new Date();
		dom=sdf.parse(checkIn);
		
		
		
		Transport transport=new Transport(id,fullName, dom,nic, cost,email,noOfKm);
		transportUtil.updateTransport(transport);
		
		listTransport(request,response);
	}


	private void SearchTransport(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String vehicleName=request.getParameter("theSearchName");
		List<Transport> transportList = transportUtil.searchTransports(vehicleName);
		request.setAttribute("TRANSPORT_LIST", transportList);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin-view-booked-vehicles.jsp");
		
		rd.forward(request, response);
		listTransport(request,response);
		
	}



	private void deleteTransport(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		transportUtil.deleteTransport(id);
		listTransport(request,response);
		
	}


	private void addTransport(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String fullName = request.getParameter("fullName");
		String checkIn = request.getParameter("checkIn");
		String nic = request.getParameter("nic");
		double cost = Double.valueOf(request.getParameter("cost"));
		String email = request.getParameter("email");
		int noOfKm = Integer.valueOf(request.getParameter("noOfKm"));
		
		
		
//		System.out.println(location + "   " + itemCategory + "   " + itemSubCategory);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dateOfCheck = new Date();
		
		
		try {
			
			dateOfCheck = sdf.parse(checkIn);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		
		Transport transport = new Transport(fullName, dateOfCheck, nic, cost, email, noOfKm);
		
		transportUtil.addTransport(transport);
		
		response.sendRedirect("AdminTransportController");
	}


	private void listTransport(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Transport> transportList = transportUtil.getTransports();
		request.setAttribute("TRANSPORT_LIST", transportList);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin-view-booked-vehicles.jsp");
		
		rd.forward(request, response);
		
	}

}
