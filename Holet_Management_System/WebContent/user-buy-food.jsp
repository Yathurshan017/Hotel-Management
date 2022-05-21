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
	<title>Buy Food</title>
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
			<h2><i class="fas fa-folder-plus"></i> Buy Food</h2>
		</div>
	</nav>
	
	<div class="container" style="max-width: 800px; box-shadow: 5px 10px 18px #888888;">
		
		<br>
		
		<div>
			<form action="BuyController" method="get">
			
				<input type="hidden" name="COMMAND" value="ADD">
				
			
				<div class="form-group">
					<label for="inputName">Food Name: </label><br>
					<input type="text" value="Checken Briyani" id="inputName" name="foodName" placeholder="Unit Price" class="form-control" required="required">	
				</div>
				
				<div class="form-group">
					<label for="inputName">Quantity: </label>
					<input type="number" id="inputName" name="qty" placeholder="Enter Quantity" class="form-control" onchange="calculateAmount(this.value)" required="required">	
				</div>
				
				<div class="form-group">
					<label for="inputNIC">Unit Price: </label>
					<input type="number" value="650.00" id="inputName" name="unitPrice" placeholder="Unit Price" class="form-control" required="required">	
				</div>
				
				<div class="form-group">
					<label for="inputNIC">Total Price: </label>
					<input type="text" id="tot_amount" name="totalPrice" placeholder="Click Here" class="form-control" required="required" readonly>	
				</div>
				
				
			
				
					<br>
				
				
				<div class="row">
					<div class="col text-center">
						<input type="submit" value="Buy" class="btn btn-success btn-block">
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
	
	<script >
	function calculateAmount(val) {
        var tot_price = val * 650.00;
        /*display the result*/
        var divobj = document.getElementById('tot_amount');
        divobj.value = tot_price;
    }
	</script>
	
	<footer class="page-footer font-small navbar-dark bg-dark" style="color:#ffffff; left: 0; bottom: 0; width: 100%; margin-top: 20px;">
		<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
	</footer>
	
	
	
</body>
</html>