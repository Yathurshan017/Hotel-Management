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
	<title>Book Vehicles</title>
</head>
<body>

	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="RoomController"><img Style="max-width:148px;" src="images/download.png"></a>
			
			<ul class="navbar-nav">
				
				
			</ul>
		</div>
	</nav>
	
	<nav class="navbar navbar-light" style="background-color:#ffc107;">
		<div class="container">
			<h2><i class="fas fa-folder-plus"></i> Book Vehicles</h2>
		</div>
	</nav>
	
	<div class="container" style="max-width: 800px; box-shadow: 5px 10px 18px #888888;">
		
		<br>
		
		<div>
			<form action="TransportController" method="get">
			
				<input type="hidden" name="COMMAND" value="ADD">
				
			
				<div class="form-group">
					<label for="inputName">Full Name: </label>
					<input type="text" id="inputName" name="fullName" placeholder="Full Name" class="form-control" required="required">	
				</div>
				
				
				
				<div class="form-group">
					<label for="inputNIC">NIC: </label>
					<input type="text" id="NIC" name="nic" placeholder="Enter Your NIC Number" class="form-control" required="required" pattern="^[0-9+]{9}[vV|xX]$">
				</div>
				
				<div class="form-group">
					<label for="inputEmail">Email: </label>
					<input type="text" id="Email" name="email" placeholder="Enter Email Address" class="form-control" required="required" pattern="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?">
				</div>
				
				<div class="form-group">
					<label for="inputDOD">Check-In: </label>
					<input type="date" id="inputDOC" name="checkIn" placeholder="Date Of CheckIn" class="form-control" required="required">
				</div>
				
				<div class="form-group">
					<label for="inputnoOfKm">No Of KM: </label>
					<input type="number" id="KM" name="noOfKm" placeholder=" Total KM" class="form-control" onchange="calculateAmount(this.value)" required="required">
				</div>
										
				
				<div class="form-group">
					<label for="inputMobile">Cost: </label>
					<input type="text" id="tot_amount" name="cost"  class="form-control" required="required" readonly>
				</div>
			
				
					<br>
				
				
				<div class="row">
					<div class="col text-center">
						<input type="submit" value="Book" class="btn btn-success btn-block">
					</div>
				</div>
					
			</form>
			
			<br><br>
			
			<div style="text-align:center; margin-bottom: 20px;">
				
				<button  class="btn btn-link" type="submit"><a href="transport-home.jsp">Back to Home</a></button>
			</div>
			
			<br>
		</div>
		
	</div>
	
	<footer class="page-footer font-small navbar-dark bg-dark" style="color:#ffffff; left: 0; bottom: 0; width: 100%; margin-top: 20px;">
		<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
	</footer>
	
	<script >
	function calculateAmount(val) {
        var tot_price = val * 100;
        /*display the result*/
        var divobj = document.getElementById('tot_amount');
        divobj.value = tot_price;
    }
	</script>
	
</body>
</html>