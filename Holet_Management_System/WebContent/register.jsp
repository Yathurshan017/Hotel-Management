<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
	<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/universal_style.css">
	
	<title>Sign Up</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand text-center" href="index.jsp" style="margin: 0 auto;"><img Style="max-width:148px;" src="images/download.png"></a>
		</div>
	</nav>
	
	<nav class="navbar navbar-light" style="background-color:#007bff; color:#ffffff;">
		<div class="container">
			<h2><i class="fas fa-user-plus"></i> Registration</h2>
		</div>
	</nav>
	
	<div class="container" style="max-width: 800px; box-shadow: 5px 10px 18px #888888;">
		<form class="form-horizontal" action="RegisterServlet" method="post">
			
			<input type="hidden" name="command" value="ADD" />
			
			<div class="form-group"> 
				<label for="inputUserid" class="control-label"></label>
    			<div class="col-sm-10">
	       			<% 
	             		String str=(String)request.getAttribute("msg");
	            
	              		if(str != null){
	            	%> 
	            	  <h4 style="color: red;">  <%= str %></h4>
	            	<%
	              	}
	              	%>
    			</div>
				
            </div>
            
            <div class="form-group" >
    			<label for="inputFirstName">First Name</label>
    			<input type="text" name="FirstName" class="form-control" id="inputFirstName" placeholder="First Name" required="required" pattern="[A-Za-z]{3,}" title="Must contain at least 3 or more characters">
  			</div>
  
  			<div class="form-group">
    			<label for="inputLastName">Last Name</label>
    			<input type="text" name="LastName" class="form-control" id="inputLastName" placeholder="Last Name" required="required" pattern="[A-Za-z]{3,}" title="Must contain at least 3 or more characters">
  			</div>
  			
  			<div class="form-group">
    			<label for="inputAddress">Address</label>
    			<textarea class="form-control" name="Address" rows="5" id="inputAddress" placeholder="Address" required="required"></textarea>
  			</div>
  			
  			<div class="form-group">
    			<label for="inputUserid">User name</label>
    			<input type="text" name="Username" class="form-control" id="inputUserid" placeholder="User Name or Email" required="required">
  			</div>
  
  			<div class="form-group">
    			<label for="inputPassword">Password</label>
    			<input type="password" name="Password" class="form-control" id="password" placeholder="Password" required="required" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters">
  			</div>
  			
  			<div class="form-group">
    			<label for="inputConfirmPassword">Confirm password</label>
    			<input type="password" name="Confirmpassword" class="form-control" id="confirm_password" placeholder="Confirm Password" required="required" >
  			</div>
  
  			<div class="form-group">
    			<label for="inputCity">ContactNo</label>
    			<input type="text" name="ContactNo" class="form-control" id="inputCity" placeholder="Contact Number" required="required" pattern="07[1,2,5,6,7,8][0-9]+" maxlength="10">
  			</div>
  			
  			<div class="form-group">
    			<label for="inputCity">Email</label>
    			<input type="text" name="Email" class="form-control" id="email" placeholder="example@gmail.com" required="required" pattern="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?">
  			</div>
  			
  
			<div class="form-group">
				<button type="submit" class="btn btn-success btn-block">Sign Up</button>
			</div>
		</form>
		
		<div style="text-align: center; padding: 10px;">				
			<p>or</p>
			<a href="login.jsp">Login here</a>
		</div>
		
		<br>
		
	</div>
	
	<br><br>
	
	<footer class="page-footer font-small navbar-dark bg-dark" style="color:#ffffff; left: 0; bottom: 0; width: 100%;">
		<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
	</footer>
	
	<script type="text/javascript">
	var password = document.getElementById("password")
	  , confirm_password = document.getElementById("confirm_password");

	function validatePassword(){
	  if(password.value != confirm_password.value) {
	    confirm_password.setCustomValidity("Passwords Don't Match");
	  } else {
	    confirm_password.setCustomValidity('');
	  }
	}

	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
	</script>

</body>
</html>