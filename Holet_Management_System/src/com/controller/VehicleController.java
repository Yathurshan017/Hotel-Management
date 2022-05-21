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

import com.data.VehicleDAOImpl;
import com.model.Transport;
import com.model.Vehicle;

/**
 * Servlet implementation class VehicleController
 */
@WebServlet("/VehicleController")
public class VehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
VehicleDAOImpl vehicleUtil;
	
	
	String message = null;
	
	@Override
	public void init() throws ServletException {

		super.init();
		vehicleUtil = new VehicleDAOImpl();
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
					listVehicle(request, response);
				}
				break;
				
				
				
			case "ADD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					addVehicle(request, response);
				}
				break;
				
			case "DELETE":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					deleteVehicle(request,response);
				}
				break;
			
			case "SEARCH":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					SearchVehicle(request,response);
				}
				break;
				
			case "LOAD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					loadVehicle(request,response);
				}
				break;
				
			case "UPDATE": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					updateVehicle(request,response);
				}
				break;
				
			case "CHECK": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					checkVehicle(request,response);
				}
				break;
				
			default:
				listVehicle(request, response);
			}
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
	
	private void checkVehicle(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
	private void loadVehicle(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		Vehicle vehicle=vehicleUtil.getVehicle(id);
		request.setAttribute("VEHICLE",vehicle);
		RequestDispatcher rd=request.getRequestDispatcher("update-transport-details.jsp");
		rd.forward(request, response);
		
		
	}

	private void updateVehicle(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		String vehicleName=request.getParameter("vehicleName");
		String vehicleNumber=request.getParameter("vehicleNumber");
		String facilities=request.getParameter("facilities");
		double cost=Double.parseDouble(request.getParameter("cost"));	
		String vehicleType=request.getParameter("vehicleType");
		
		
		
		
		
		
		Vehicle vehicle=new Vehicle(id,vehicleName, vehicleNumber,facilities, cost,vehicleType);
		vehicleUtil.updateVehicle(vehicle);
		
		listVehicle(request,response);
	}


	private void SearchVehicle(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String vehicleName=request.getParameter("theSearchName");
		List<Vehicle> vehicleList = vehicleUtil.searchVehicles(vehicleName);
		request.setAttribute("VEHICLE_LIST", vehicleList);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin-view-transport-details2.jsp");
		
		rd.forward(request, response);
		listVehicle(request,response);
		
	}



	private void deleteVehicle(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		vehicleUtil.deleteVehicle(id);
		listVehicle(request,response);
		
	}


	private void addVehicle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String vehicleName = request.getParameter("vehicleName");
		String vehicleNumber = request.getParameter("vehicleNumber");
		String facilities = request.getParameter("facilities");
		double cost = Double.valueOf(request.getParameter("cost"));
		String vehicleType = request.getParameter("vehicleType");
		
		
		

		
		Vehicle vehicle = new Vehicle(vehicleName, vehicleNumber, facilities, cost, vehicleType);
		
		vehicleUtil.addVehicle(vehicle);
		
		response.sendRedirect("VehicleController");
	}


	private void listVehicle(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Vehicle> vehicleList = vehicleUtil.getVehicles();
		request.setAttribute("VEHICLE_LIST", vehicleList);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin-view-transport-details2.jsp");
		
		rd.forward(request, response);
		
	}


}
