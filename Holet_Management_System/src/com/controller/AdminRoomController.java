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

import com.data.RoomDAOImpl;
import com.model.Room;

/**
 * Servlet implementation class AdminRoomController
 */
@WebServlet("/AdminRoomController")
public class AdminRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	RoomDAOImpl roomUtil;
	
	String resource = "login.jsp";
	String message = null;

	@Override
	public void init() throws ServletException {

		super.init();
		roomUtil = new RoomDAOImpl();
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
					listRoom(request, response);
				}
				break;
				
				
				
			case "ADD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					addRoom(request, response);
				}
				break;
				
			case "DELETE":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					deleteRoom(request,response);
				}
				break;
			
			case "SEARCH":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					SearchRoom(request,response);
				}
				break;
				
			case "LOAD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					loadRoom(request,response);
				}
				break;
				
			case "UPDATE": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					updateRoom(request,response);
				}
				break;
				
			case "CHECK": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					checkRoom(request,response);
				}
				break;
				
			default:
				listRoom(request, response);
			}
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void checkRoom(HttpServletRequest request, HttpServletResponse response) throws Exception {

		RequestDispatcher rd=request.getRequestDispatcher("admin-add-rooms.jsp");
		rd.forward(request, response);
		
	}


	private void sessionChecker(HttpServletRequest request, HttpServletResponse response) throws Exception {

		message = "Session Expired : TRY AGAIN";
		RequestDispatcher rd = request.getRequestDispatcher(resource);
		request.setAttribute("msg", message);
		rd.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void loadRoom(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		Room room=roomUtil.getRoom(id);
		request.setAttribute("ROOM",room);
		RequestDispatcher rd=request.getRequestDispatcher("admin-edit-booked-rooms.jsp");
		rd.forward(request, response);
		
		
	}

	private void updateRoom(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		String fullName=request.getParameter("fullName");
		String address=request.getParameter("address");
		String nic=request.getParameter("nic");
		int members=Integer.parseInt(request.getParameter("members"));
		int noOfRooms=Integer.parseInt(request.getParameter("noOfRooms"));
		String dateOfArrival=request.getParameter("dateOfArrival");
		String dateOfDeparture=request.getParameter("dateOfDeparture");
		String email=request.getParameter("email");
		String roomType=request.getParameter("roomType");
		int mobile=Integer.parseInt(request.getParameter("mobile"));
	
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dom=new Date();
		dom=sdf.parse(dateOfArrival);
		Date doe=new Date();
		doe=sdf.parse(dateOfDeparture);
		
		
		Room room=new Room(id,fullName, address, nic, members, noOfRooms, dom, doe, email, roomType,mobile);
		roomUtil.updateRoom(room);
		
		listRoom(request,response);
	}


	private void SearchRoom(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String fullName=request.getParameter("theSearchName");
		List<Room> roomList = roomUtil.searchRooms(fullName);
		request.setAttribute("ROOM_LIST", roomList);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin-view-room-booked.jsp");
		
		rd.forward(request, response);
		listRoom(request,response);
		
	}



	private void deleteRoom(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		roomUtil.deleteRoom(id);
		listRoom(request,response);
		
	}


	private void addRoom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String fullName = request.getParameter("fullName");
		String address = request.getParameter("address");
		String nic = request.getParameter("nic");
		int members = Integer.valueOf(request.getParameter("members"));
		int noOfRooms = Integer.valueOf(request.getParameter("noOfRooms"));
		String dateOfArrival = request.getParameter("dateOfArrival");
		String dateOfDeparture = request.getParameter("dateOfDeparture");
		String email = request.getParameter("email");
		String roomType=request.getParameter("roomType");
		int mobile = Integer.valueOf(request.getParameter("mobile"));
		
		
		
//		System.out.println(location + "   " + itemCategory + "   " + itemSubCategory);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dateOfarriv = new Date();
		Date dateOfdep= new Date();
		
		try {
			dateOfarriv = sdf.parse(dateOfArrival);
			dateOfdep = sdf.parse(dateOfDeparture);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		
		Room room = new Room(fullName, address, nic, members, noOfRooms, dateOfarriv, dateOfdep, email,roomType, mobile);
		
		roomUtil.addRoom(room);
		
		response.sendRedirect("AdminRoomController");
	}


	private void listRoom(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Room> roomList = roomUtil.getRooms();
		request.setAttribute("ROOM_LIST", roomList);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin-view-room-booked.jsp");
		
		rd.forward(request, response);
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	}

}
