<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
	<link rel="stylesheet" href="css/universal_style.css">
	<title>Update Booked</title>
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
			<h2><i class="fas fa-pen-square"></i> Update Booking</h2>
		</div>
	</nav>
	
	<div class="container" style="max-width: 800px; box-shadow: 5px 10px 18px #888888;">
		
		<br>
		
		<div>
			<form action="AdminRoomController" method="get">
			
				<input type="hidden" name="COMMAND" value="UPDATE">
				<input type="hidden" name="id" value="${ROOM.id}">
				
			
				<div class="form-group">
					<label for="inputName">Full Name: </label>
					<input type="text" id="inputName" name="fullName" placeholder="Full Name" class="form-control" value="${ROOM.fullName}" required="required">	
				</div>
				
				<div class="form-group">
					<label for="inputAddress">Address: </label>
					<input type="text" id="inputAddress" name="address" placeholder="Address" class="form-control" value="${ROOM.address}" required="required">
				</div>
				
				<div class="form-group">
					<label for="inputNic">NIC: </label>
					<input type="text" id="inputNic" name="nic" placeholder="nic" class="form-control" value="${ROOM.nic}" required="required">
				</div>
				
				<div class="form-group">
					<label for="inputMembers">Members: </label>
					<input type="number" id="inputMembers" name="members" placeholder="Current Total Stock" class="form-control" value="${ROOM.members}" required="required">
				</div>
				
				<div class="form-group">
					<label for="inputRooms">No Of Rooms: </label>
					<input type="number" id="inputRooms" name="noOfRooms" placeholder="Rooms" class="form-control" value="${ROOM.noOfRooms}" required="required">
				</div>
				
				<div class="form-group">
					<label for="inputDOM">Date Of Arrival: </label>
					<input type="date" id="inputDOA" name="dateOfArrival" placeholder="Date Of Arrival" class="form-control" value="${ROOM.dateOfArrival}" required="required">
				</div>
				
				<div class="form-group">
					<label for="inputDOE">Date Of Departure: </label>
					<input type="date" id="inputDOD" name="dateOfDeparture" placeholder="Date Of Departure" class="form-control" value="${ROOM.dateOfDeparture}" required="required">
				</div>
				
				<div class="form-group">
					<label for="inputEmail">Email: </label>
					<input type="text" id="email" name="email" placeholder="email" class="form-control" value="${ROOM.email}" required="required">
				</div>
				
				<div class="form-group">
					<label for="inputRtype">Room Type: </label>
					<input type="text" id="inputRtype" name="roomType" placeholder="email" class="form-control" value="${ROOM.roomType}" required="required">
				</div>
				
				<div class="form-group">
					<label for="inputMobile">Mobile: </label>
					<input type="number" id="mobile" name="mobile" placeholder="mobile" class="form-control" value="${ROOM.mobile}" required="required">
				</div>
				
				
				
				
				<div class="row">
					<div class="col text-center">
						<input type="submit" value="Update Booking" class="btn btn-success btn-block">
					</div>
				</div>
					
			</form>
			
			<br><br>
			
			<div style="text-align:center; margin-bottom: 20px;">
				<c:url var="listLink" value="AdminRoomController">
					<c:param name="COMMAND" value="LIST"/>
				</c:url>
				<button  class="btn btn-link" type="submit"><a href="${listLink}">Back to List</a></button>
			</div>
			
			<br>
		</div>
		
	</div>
	
	<footer class="page-footer font-small navbar-dark bg-dark" style="color:#ffffff; left: 0; bottom: 0; width: 100%; margin-top: 20px;">
		<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
	</footer>
	
</body>
</html>