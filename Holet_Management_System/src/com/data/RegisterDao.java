package com.data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.model.Register;



public class RegisterDao {

	public int registeruser(Register register)throws ClassNotFoundException{
		//String insert_user = "INSERT INTO my(FirstName, LastName, Address, Username, Password, Confirmpassword, ContactNo, Email)" + "values(?,?,?,?,?,?,?,?)";
		String insert_user = (" INSERT INTO `users`(`FirstName`, `LastName`, `Address`, `Username`, `Password`, `Confirmpassword`, `ContactNo`, `Email`)VALUES(?,?,?,?,?,?,?,?)");
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","");
			
			PreparedStatement preparedStmt = connection.prepareStatement(insert_user);
			
			preparedStmt.setString(1, register.getFirstName());
			preparedStmt.setString(2, register.getLastName());
			preparedStmt.setString(3, register.getAddress());
			preparedStmt.setString(4, register.getUsername());
			preparedStmt.setString(5, register.getPassword());
			preparedStmt.setString(6, register.getConfirmPassword());
			preparedStmt.setString(7, register.getContactNo());
			preparedStmt.setString(8, register.getEmail());
			
			
			System.out.println(preparedStmt);
			
			result = preparedStmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
}
