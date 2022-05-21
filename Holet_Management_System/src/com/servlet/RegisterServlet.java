package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Register;
import com.data.RegisterDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RegisterDao registerDao;

	public void init(){
		registerDao = new RegisterDao();
    }
    
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String fname = request.getParameter("FirstName");
        String lname = request.getParameter("LastName");
        String address = request.getParameter("Address");
        String Username = request.getParameter("Username");
        String password = request.getParameter("Password");
        String confirmpassword = request.getParameter("Confirmpassword");
        String phone = request.getParameter("ContactNo");
        String email = request.getParameter("Email");
       
        
        
        Register register = new Register();
        
        register.setFirstName(fname);
        register.setLastName(lname);
        register.setAddress(address);
        register.setUsername(Username);
        register.setPassword(password);
        register.setConfirmPassword(confirmpassword);
        register.setContactNo(phone);
        register.setEmail(email);
        
        
        try {
        	registerDao.registeruser(register);
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        response.sendRedirect("login.jsp");
       

    }
}
