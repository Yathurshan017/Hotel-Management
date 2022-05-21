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

import com.data.FoodDAOImpl;

import com.model.Food;


/**
 * Servlet implementation class FoodController
 */
@WebServlet("/FoodController")
public class FoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
FoodDAOImpl foodUtil;
	
	String resource = "login.jsp";
	String message = null;
	
	@Override
	public void init() throws ServletException {

		super.init();
		foodUtil = new FoodDAOImpl();
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
					listFood(request, response);
				}
				break;
				
				
				
			case "ADD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					addFood(request, response);
				}
				break;
				
			case "DELETE":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					deleteFood(request,response);
				}
				break;
			
			case "SEARCH":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					SearchFood(request,response);
				}
				break;
				
			case "LOAD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					loadFood(request,response);
				}
				break;
				
			case "UPDATE": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					updateFood(request,response);
				}
				break;
				
			case "CHECK": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					checkFood(request,response);
				}
				break;
				
			default:
				listFood(request, response);
			}
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
	
	private void checkFood(HttpServletRequest request, HttpServletResponse response) throws Exception {

		RequestDispatcher rd=request.getRequestDispatcher("add-food-items.jsp");
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
	
	private void loadFood(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		Food food=foodUtil.getFood(id);
		request.setAttribute("FOOD",food);
		RequestDispatcher rd=request.getRequestDispatcher("admin-update-food.jsp");
		rd.forward(request, response);
		
		
	}

	private void updateFood(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		String foodName=request.getParameter("foodName");
		String foodCode=request.getParameter("foodCode");
		String description=request.getParameter("description");
		
		
		
		
		Food food=new Food(id,foodName, foodCode, description );
		foodUtil.updateFood(food);
		
		listFood(request,response);
	}


	private void SearchFood(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String foodName=request.getParameter("theSearchName");
		List<Food> foodList = foodUtil.searchFoods(foodName);
		request.setAttribute("FOOD_LIST", foodList);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin-view-food-details.jsp");
		
		rd.forward(request, response);
		listFood(request,response);
		
	}



	private void deleteFood(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		foodUtil.deleteFood(id);
		listFood(request,response);
		
	}


	private void addFood(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String foodName = request.getParameter("foodName");
		String foodCode = request.getParameter("foodCode");
		String description = request.getParameter("description");
		
		
		
		

		
		Food food = new Food(foodName, foodCode, description);
		
		foodUtil.addFood(food);
		
		response.sendRedirect("FoodController");
	}


	private void listFood(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Food> foodList = foodUtil.getFoods();
		request.setAttribute("FOOD_LIST", foodList);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin-view-food-details.jsp");
		
		rd.forward(request, response);
		
	}

}
