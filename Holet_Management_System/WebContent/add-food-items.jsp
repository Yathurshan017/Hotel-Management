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
	<title>Add Food</title>
</head>
<body>

	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="RoomController"><img src="images/download.png" Style="max-width:42%;"></a>
			
			<ul class="navbar-nav">
				
				
			</ul>
		</div>
	</nav>
	
	<nav class="navbar navbar-light" style="background-color:#ffc107;">
		<div class="container">
			<h2><i class="fas fa-folder-plus"></i> Add Food</h2>
		</div>
	</nav>
	
	<div class="container" style="max-width: 800px; box-shadow: 5px 10px 18px #888888;">
		
		<br>
		
		<div>
			<form action="FoodController" method="get">
			
				<input type="hidden" name="COMMAND" value="ADD">
				
			
				<div class="form-group">
					<label for="inputName">Food Name: </label>
					<input type="text" id="inputName" name="foodName" placeholder="Food Name" class="form-control" required="required">	
				</div>
				
				<div class="form-group">
					<label for="inputName">Food Code: </label>
					<input type="text" id="inputName" name="foodCode" placeholder="Food Code" class="form-control" required="required">	
				</div>
				
				<div class="form-group">
					<label for="inputNIC">Description: </label>
					<textarea name="description" cols="50" rows="5" placeholder="Enter Food Description" class="form-control" required="required"></textarea> 
				</div>
				
				<div class="form-group">
					<label for="inputEmail">Image: </label><br>
					<input type="file" id="avatar" name="avatar">
				</div>
				
				
			
				
					<br>
				
				
				<div class="row">
					<div class="col text-center">
						<input type="submit" value="Add" class="btn btn-success btn-block">
					</div>
				</div>
					
			</form>
			
			<br><br>
			
			<div style="text-align:center; margin-bottom: 20px;">
				
				<button  class="btn btn-link" type="submit"><a href="restaurant-home.jsp">Back to Home</a></button>
			</div>
			
			<br>
		</div>
		
	</div>
	
	<footer class="page-footer font-small navbar-dark bg-dark" style="color:#ffffff; left: 0; bottom: 0; width: 100%; margin-top: 20px;">
		<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
	</footer>
	
	
	
</body>
</html>