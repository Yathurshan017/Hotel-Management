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
	<title>Update Food </title>
</head>
<body>

	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="RoomController"><img src="images/download.png" Style="max-width:42%;"></a>
			
			<ul class="navbar-nav">
				
				<li class="nav-item">
				
					<a class="nav-link" href="restaurant-home.jsp" style="color: #F1F1F1;"><i class="fas fa-sign-out-alt"></i> Logout</a>
				</li>
			</ul>
		</div>
	</nav>
	
	<nav class="navbar navbar-light" style="background-color:#ffc107;">
		<div class="container">
			<h2><i class="fas fa-pen-square"></i> Update Food Details</h2>
		</div>
	</nav>
	
	<div class="container" style="max-width: 800px; box-shadow: 5px 10px 18px #888888;">
		
		<br>
		
		<div>
			<form action="FoodController" method="get">
			
				<input type="hidden" name="COMMAND" value="UPDATE">
				<input type="hidden" name="id" value="${FOOD.id}">
				
			
				<div class="form-group">
					<label for="inputfoodName">Food Name: </label>
					<input type="text" id="inputfoodName" name="foodName" placeholder="Food Name" class="form-control" value="${FOOD.foodName}" required="required">	
				</div>
				
				<div class="form-group">
					<label for="inputfoodCode">Food Code: </label>
					<input type="text" id="inputfoodCode" name="foodCode" placeholder="foodCode" class="form-control" value="${FOOD.foodCode}" required="required">
				</div>
				
				<div class="form-group">
					<label for="inputdescriptiion">Description: </label>
					<input type="text" id="inputdescription" name="description" placeholder="description" class="form-control" value="${FOOD.description}" required="required">
				</div>
				
				
				
				
				
				<div class="row">
					<div class="col text-center">
						<input type="submit" value="Update Food" class="btn btn-success btn-block">
					</div>
				</div>
					
			</form>
			
			<br><br>
			
			<div style="text-align:center; margin-bottom: 20px;">
				<c:url var="listLink" value="FoodController">
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