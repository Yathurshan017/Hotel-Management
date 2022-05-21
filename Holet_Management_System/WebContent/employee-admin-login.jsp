<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
	<link rel="stylesheet" href="css/universal_style.css">
</head>
<body>
<div class="container" style="float:center;margin-top:200px">
	
		<div class="card bg-light mb-3" style="max-width: 30rem; margin: 30px auto; float: none;">
			<div class="card-header"><h3>LogIn</h3></div>
			<div class="card-body" style="background-color: #ffffff;">
				<form class="loginform" action="EmployeeUserController" method="post">
					<input type="hidden" name="command" value="USER" />
					<div class="form-group"> 
					<% 
	             		String str=(String)request.getAttribute("msg");
						String str1=(String)request.getAttribute("error");
					
	            	%><%
	            	if(str!=null){
	            	%> 
	            		<h4 style="color: green; text-align: center;"> <%=str%></h4>
	            		
	            	<%
	            	}
	            	%>
	            	<%
	            	 if(str1!=null){
	            	%> 
	            		<h4 style="color: red; text-align: center;"> <%=str1%></h4>
	            		
	            	<%
	            	}
	            	%>
	            	
					</div>
						<div class="form-group">
						<label for="inputUsername">User Name</label> 
						<input type="text" name="Username" class="form-control" id="inputUsername" placeholder="User name" required="required">
					</div>
					
					<div class="form-group">
						<label for="inputPassword">Password</label> 
						<input type="password" name="Password" class="form-control" id="inputPassword" placeholder="Password" required="required">
					</div>

					<button type="submit" class="btn btn-success btn-block">Login</button>
				</form>
				<br>
				<div style="text-align: center; padding: 10px;">				
  					
  					<a href="index.jsp">Home</a>
				</div>

				
			</div>
		</div>
	</div>
</body>
</html>