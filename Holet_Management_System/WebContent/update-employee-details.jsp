<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
	<link rel="stylesheet" href="css/universal_style.css">
	<title>Update Employee</title>
</head>
<body>

	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="RoomController"><img Style="max-width:148px;" src="images/download.png"></a>
			
			<ul class="navbar-nav">
				
				<li class="nav-item">
					<c:url var="logoutLink" value="UserController">
						<c:param name="command" value="LOGOUT"/>
					</c:url>
					<a class="nav-link" href="${logoutLink}" style="color: #F1F1F1;"><i class="fas fa-sign-out-alt"></i> Logout</a>
				</li>
			</ul>
		</div>
	</nav>
	
	<nav class="navbar navbar-light" style="background-color:#ffc107;">
		<div class="container">
			<h2><i class="fas fa-folder-plus"></i> Update Employee Details</h2>
		</div>
	</nav>
	
	<div class="container" style="max-width: 800px; box-shadow: 5px 10px 18px #888888;">
		
		<br>
		
		<div>
			<form action="EmployeeController" method="get">
			
				<input type="hidden" name="COMMAND" value="UPDATE">
				<input type="hidden" name="id" value="${EMPLOYEE.id}">
				
			
				<div class="form-group">
					<label for="inputName">Full Name: </label>
					<input type="text" id="inputName" name="fullName" placeholder="Full Name" class="form-control" value="${EMPLOYEE.fullName}"required="required">	
				</div>
				
				<div class="form-group">
					<label for="inputAddress">Address: </label>
					<input type="text" id="address" name="address" placeholder=" Current Address" class="form-control" value="${EMPLOYEE.address}"required="required">
				</div>
				
				<div class="form-group">
					<label for="inputNIC">NIC: </label>
					<input type="text" id="NIC" name="nic" placeholder="Enter  NIC Number" class="form-control" value="${EMPLOYEE.nic}"required="required">
				</div>
				<div class="form-group">
					<label for="inputEmpId">Employee ID: </label>
					<input type="text" id="EmpId" name="employeeId" placeholder="Enter  ID" class="form-control" value="${EMPLOYEE.employeeId}"required="required">
				</div>
				
				
				<div class="form-group">
					<label for="inputEmail">Email: </label>
					<input type="text" id="Email" name="email" placeholder="Enter Email Address" class="form-control" value="${EMPLOYEE.email}"required="required">
				</div>
				
				<div class="form-group">
					<label for="inputMobile">Mobile: </label>
					<input type="number" id="Mobile" name="mobile" placeholder="Enter Mobile Number" class="form-control" value="${EMPLOYEE.mobile}"required="required">
				</div>
				
				<div class="form-group">
					<label for="inputDOB">Date Of Birth: </label>
					<input type="date" id="inputDOB" name="dateOfBirth" placeholder="Date Of Birth" class="form-control" value="${EMPLOYEE.dateOfBirth}"required="required">
				</div>
				
				<div class="form-group">
					<label for="inputJobPost">Job Post: </label>
					<input type="text" id="inputJobPost" name="jobPost" placeholder="Enter Job Post" class="form-control" value="${EMPLOYEE.jobPost}"required="required">
				</div>
			
				
					<br>
				
				
				<div class="row">
					<div class="col text-center">
						<input type="submit" value="Update" class="btn btn-success btn-block">
					</div>
				</div>
					
			</form>
			
			<br><br>
			
			<div style="text-align:center; margin-bottom: 20px;">
				
				<button  class="btn btn-link" type="submit"><a href="view-employee.jsp">Back to List</a></button>
			</div>
			
			<br>
		</div>
		
	</div>
	
	<footer class="page-footer font-small navbar-dark bg-dark" style="color:#ffffff; left: 0; bottom: 0; width: 100%; margin-top: 20px;">
		<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
	</footer>
	
	
	
</body>
</html>