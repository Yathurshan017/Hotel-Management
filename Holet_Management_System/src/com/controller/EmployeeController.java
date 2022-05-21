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

import com.data.EmployeeDAOImpl;
import com.model.Employee;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	EmployeeDAOImpl employeeUtil;
	
	String resource = "employee-admin-login.jsp";
	String message = null;

	@Override
	public void init() throws ServletException {

		super.init();
		employeeUtil = new EmployeeDAOImpl();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
					listEmployee(request, response);
				}
				break;
				
			case "ADD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					addEmployee(request, response);
				}
				break;
				
			case "DELETE":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					deleteEmployee(request,response);
				}
				break;
			
			case "SEARCH":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					SearchEmployee(request,response);
				}
				break;
				
			case "LOAD":
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					loadEmployee(request,response);
				}
				break;
				
			case "UPDATE": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					updateEmployee(request,response);
				}
				break;
				
			case "CHECK": 
				if(session.isNew()) {
					sessionChecker(request, response);
				}
				else {
					checkEmployee(request,response);
				}
				break;
				
			default:
				listEmployee(request, response);
			}
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
	
	private void checkEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {

		RequestDispatcher rd=request.getRequestDispatcher("add-employee.jsp");
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
	private void loadEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		Employee employee=employeeUtil.getEmployee(id);
		request.setAttribute("EMPLOYEE",employee);
		RequestDispatcher rd=request.getRequestDispatcher("update-employee-details.jsp");
		rd.forward(request, response);
		
		
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int id=Integer.parseInt(request.getParameter("id"));
		String fullName=request.getParameter("fullName");
		String address=request.getParameter("address");
		String nic=request.getParameter("nic");
		String employeeId=request.getParameter("employeeId");
		String jobPost=request.getParameter("jobPost");
		String dateOfBirth=request.getParameter("dateOfBirth");
		String email=request.getParameter("email");
		int mobile=Integer.parseInt(request.getParameter("mobile"));
	
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dob=new Date();
		dob=sdf.parse(dateOfBirth);
		
		
		
		Employee employee=new Employee(id,fullName, address, nic, employeeId, jobPost, dob, email, mobile);
		employeeUtil.updateEmployee(employee);
		
		listEmployee(request,response);
	}


	private void SearchEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String fullName=request.getParameter("theSearchName");
		List<Employee> employeeList = employeeUtil.searchEmployees(fullName);
		request.setAttribute("EMPLOYEE_LIST", employeeList);
		
		RequestDispatcher rd = request.getRequestDispatcher("view-employee.jsp");
		
		rd.forward(request, response);
		listEmployee(request,response);
		
	}



	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
		int id=Integer.parseInt(request.getParameter("id"));
		employeeUtil.deleteEmployee(id);
		listEmployee(request,response);
		
		request.setAttribute("error", "Deleted Successfully");
//      String errorMsg=(String)request.getAttribute("ErrorMessage");
      RequestDispatcher dispatcher =  request.getRequestDispatcher("view-employee.jsp");
      dispatcher.forward(request, response);
		
	}


	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String fullName = request.getParameter("fullName");
		String address = request.getParameter("address");
		String nic = request.getParameter("nic");
		String employeeId = request.getParameter("employeeId");
		String jobPost = request.getParameter("jobPost");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String email = request.getParameter("email");
		int mobile = Integer.valueOf(request.getParameter("mobile"));
		
		
		
//		System.out.println(location + "   " + itemCategory + "   " + itemSubCategory);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dateOfbirth = new Date();
		
		
		try {
			
			dateOfbirth = sdf.parse(dateOfBirth);
			
			if(fullName.isEmpty()|| address.isEmpty()|| nic.isEmpty()|| employeeId.isEmpty()|| dateOfBirth.isEmpty()|| email.isEmpty()|| jobPost.isEmpty()) {
				
				request.setAttribute("error", "All Field are required");
//              String errorMsg=(String)request.getAttribute("ErrorMessage");
              RequestDispatcher dispatcher =  request.getRequestDispatcher("add-employee.jsp");
              dispatcher.forward(request, response);
			}
			else {
				request.setAttribute("msg", "Successfully Inserted");
//              String errorMsg=(String)request.getAttribute("ErrorMessage");
              RequestDispatcher dispatcher =  request.getRequestDispatcher("add-employee.jsp");
             dispatcher.forward(request, response);
			}
		} catch (ParseException e) {

			e.printStackTrace();
		}
		
		Employee employee = new Employee(fullName, address, nic, employeeId, jobPost, dateOfbirth, email, mobile);
		
		employeeUtil.addEmployee(employee);
		
		response.sendRedirect("EmployeeController");
	}


	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Employee> employeeList = employeeUtil.getEmployees();
		request.setAttribute("EMPLOYEE_LIST", employeeList);
		
		RequestDispatcher rd = request.getRequestDispatcher("view-employee.jsp");
		
		rd.forward(request, response);
		
	}

}
