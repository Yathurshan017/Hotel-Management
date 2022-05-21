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
	<title>Booked List</title>
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
			<h2>List of Booked</h2>
		</div>
	</nav>
	
	<div class="container" style="text-align:center; padding-top: 10px;">
	
		<div class="row">
			<div class="col-sm-6">
				<form action="VehicleController" method="get" class="form-horizontal" style="padding: 10px 0 10px 0;">
					<div class="input-group">
						<input type="hidden" class="form-control" name="COMMAND" value="SEARCH"/>			    
						<input type="text" class="form-control" placeholder="Search" name="theSearchName">
						<div class="input-group-append">
							<c:url var="searchLink" value="VehicleController">
								<c:param name="COMMAND" value="SEARCH"/>
							</c:url>
							<button type="submit" class="btn btn-success" value="Search"><a href="${searchLink}" style="color: #ffffff; text-decoration: none;">Go</a></button> 
						</div>
					</div>
				</form>	
			</div>
			
			<div class="col-sm-6" style="padding: 10px 15px 10px 15px;">
				<c:url var="checkLink" value="AdminTransportController">
					<c:param name="COMMAND" value="CHECK"/>
				</c:url>
				<a href="${checkLink}" class="btn btn-success btn-block">Book Transport</a>
			</div>
		</div>  
	  	
	    <br>
		
		<div class="table-responsive">
			<table id="tab-01" class="table table-striped table-hover">
				<thead style="background-color: #007bff; color:#ffffff;">
					<tr>
						<th>Vehicle Name</th>			
						<th>NIC</th>
						<th>Email</th>
						
						<th>No Of KM</th>					
						<th>Check-In</th>
						<th>Payment</th>
						<th>Action</th>
						
						
					</tr>
				</thead>
				
				<tbody>
				
					<c:forEach var="tempItem" items="${ TRANSPORT_LIST }">
						<c:url var="updateLink" value="AdminTransportController">
							<c:param name="COMMAND" value="LOAD"/>
							<c:param name="id" value="${tempItem.id}"/>
						</c:url>
						<c:url var="deleteLink" value="AdminTransportController">
							<c:param name="COMMAND" value="DELETE"/>
							<c:param name="id" value="${tempItem.id}"/>
						</c:url>
						<tr>
							<td> ${tempItem.fullName} </td>
							<td> ${tempItem.nic} </td>
							<td> ${tempItem.email} </td>						
							
							<td> ${tempItem.noOfKm} </td>
							<td> ${tempItem.checkIn} </td>
							<td> ${tempItem.cost} </td>
							
							<td>
								<a href="${updateLink}" style="color:green;">Update</a>
								|
								<a href="${deleteLink}" style="color:red;">Delete</a>
							</td>
							
						</tr>
					</c:forEach>
				</tbody>

				</table>
				</div>
				
				<br><br>
				<button type="button" id="btnExport" class="btn btn-primary" Style="float:right">Report</button>
				<button type="button" class="btn btn-primary" Style="float:left">Add Book</button>
			</div>
			
	<footer class="page-footer font-small navbar-dark bg-dark" style="color:#ffffff; position: fixed; left: 0; bottom: 0; width: 100%;">
		<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
	</footer>
	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
    <script type="text/javascript">
        $("body").on("click", "#btnExport", function () {
            html2canvas($('#tab-01')[0], {
                onrendered: function (canvas) {
                    var data = canvas.toDataURL();
                    var docDefinition = {
                        content: [{
                            image: data,
                            width: 500
                        }]
                    };
                    pdfMake.createPdf(docDefinition).download("Booked-Vehicles.pdf");
                }
            });
        });
    </script>
	
</body>
</html>