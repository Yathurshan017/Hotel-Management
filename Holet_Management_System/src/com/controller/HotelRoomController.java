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

import com.data.HotelRoomDAOImpl;

import com.model.HotelRoom;


/**
 * Servlet implementation class HotelRoomController
 */
@WebServlet("/HotelRoomController")
public class HotelRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
HotelRoomDAOImpl hotelroomUtil;
	
	String resource = "login.jsp";
	String message = null;
	
	@Override
	public void init() throws ServletException {

		super.init();
		hotelroomUtil = new HotelRoomDAOImpl();
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
					listHotelRoom(request, response);
				}
				break;
				
				
				
			case "ADD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					addHotelRoom(request, response);
				}
				break;
				
			case "DELETE":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					deleteHotelRoom(request,response);
				}
				break;
			
			case "SEARCH":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					SearchHotelRoom(request,response);
				}
				break;
				
			case "LOAD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					loadHotelRoom(request,response);
				}
				break;
				
			case "UPDATE": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					updateHotelRoom(request,response);
				}
				break;
				
			case "CHECK": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					checkHotelRoom(request,response);
				}
				break;
				
			default:
				listHotelRoom(request, response);
			}
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
	
	private void checkHotelRoom(HttpServletRequest request, HttpServletResponse response) throws Exception {

		RequestDispatcher rd=request.getRequestDispatcher("admin-add-hotel-rooms.jsp");
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
	
	private void loadHotelRoom(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		HotelRoom hotelroom=hotelroomUtil.getHotelRoom(id);
		request.setAttribute("HOTELROOM",hotelroom);
		RequestDispatcher rd=request.getRequestDispatcher("admin-update-hotel-rooms.jsp");
		rd.forward(request, response);
		
		
	}

	private void updateHotelRoom(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		String roomType=request.getParameter("roomType");
		String facilities=request.getParameter("facilities");
		
		double cost=Double.parseDouble(request.getParameter("cost"));	
		
		
		
		
		HotelRoom hotelroom=new HotelRoom(id,roomType, facilities, cost);
		hotelroomUtil.updateHotelRoom(hotelroom);
		
		listHotelRoom(request,response);
	}


	private void SearchHotelRoom(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String roomType=request.getParameter("theSearchName");
		List<HotelRoom> hotelroomList = hotelroomUtil.searchHotelRooms(roomType);
		request.setAttribute("HOTELROOM_LIST", hotelroomList);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin-view-added-hotel-rooms.jsp");
		
		rd.forward(request, response);
		listHotelRoom(request,response);
		
	}



	private void deleteHotelRoom(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		hotelroomUtil.deleteHotelRoom(id);
		listHotelRoom(request,response);
		
	}


	private void addHotelRoom(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String roomType = request.getParameter("roomType");
		String facilities = request.getParameter("facilities");
	
		double cost = Double.valueOf(request.getParameter("cost"));
		

		if(roomType.isEmpty()|| facilities.isEmpty()) {
	
			request.setAttribute("error", "All Field are required");
			//String errorMsg=(String)request.getAttribute("ErrorMessage");
			RequestDispatcher dispatcher =  request.getRequestDispatcher("admin-add-hotel-rooms.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("msg", "Successfully Saved");
			// String errorMsg=(String)request.getAttribute("ErrorMessage");
			RequestDispatcher dispatcher =  request.getRequestDispatcher("admin-add-hotel-rooms.jsp");
			dispatcher.forward(request, response);
		}

		HotelRoom hotelroom = new HotelRoom(roomType, facilities, cost);
		
		hotelroomUtil.addHotelRoom(hotelroom);
		
		response.sendRedirect("HotelRoomController");
	}


	private void listHotelRoom(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<HotelRoom> hotelroomList = hotelroomUtil.getHotelRooms();
		request.setAttribute("HOTELROOM_LIST", hotelroomList);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin-view-added-hotel-rooms.jsp");
		
		rd.forward(request, response);
		
	}


}
