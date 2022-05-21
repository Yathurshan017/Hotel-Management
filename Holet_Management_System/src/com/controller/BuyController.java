package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.data.BuyDAOImpl;

import com.model.Buy;


/**
 * Servlet implementation class BuyController
 */
@WebServlet("/BuyController")
public class BuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
BuyDAOImpl buyUtil;
	
	String resource = "login.jsp";
	String message = null;
	
	@Override
	public void init() throws ServletException {

		super.init();
		buyUtil = new BuyDAOImpl();
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
					listBuy(request, response);
				}
				break;
				
				
				
			case "ADD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					addBuy(request, response);
				}
				break;
				
		
				case "CHECK": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					checkBuy(request,response);
				}
				break;
				
			default:
				listBuy(request, response);
			}
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
	
	private void checkBuy(HttpServletRequest request, HttpServletResponse response) throws Exception {

		RequestDispatcher rd=request.getRequestDispatcher("user-buy-food.jsp");
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
	
	


	private void addBuy(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String foodName = request.getParameter("foodName");
		int qty = Integer.valueOf(request.getParameter("qty"));
		double unitPrice = Double.valueOf(request.getParameter("unitPrice"));
		double totalPrice = Double.valueOf(request.getParameter("totalPrice"));
		
		
		
		

		
		Buy buy = new Buy(foodName, qty, unitPrice, totalPrice);
		
		buyUtil.addBuy(buy);
		
		response.sendRedirect("BuyController");
	}


	private void listBuy(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Buy> buyList = buyUtil.getBuys();
		request.setAttribute("BUY_LIST", buyList);
		
		RequestDispatcher rd = request.getRequestDispatcher("user-view-buy-food.jsp");
		
		rd.forward(request, response);
		
	}

}
