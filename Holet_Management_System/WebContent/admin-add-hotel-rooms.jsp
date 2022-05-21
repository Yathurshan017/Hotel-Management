<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- Designined by CodingLab | www.youtube.com/codinglabyt -->
<html lang="en" dir="ltr">

  <head>
  <title>Admin Add Hotel Rooms</title>
    <meta charset="UTF-8">
    <!--<title> Responsiive Admin Dashboard | CodingLab </title>-->
    <link rel="stylesheet" href="css/dashboard.css">
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
	<link rel="stylesheet" href="css/universal_style.css">
   </head>
<body>
  <div class="sidebar">
    <div class="logo-details">
     
      <span class="logo_name" >Hotel Management</span>
    </div>
      <ul class="nav-links">
       
        <li>
          <a href="#">
            <i class='bx bx-box' ></i>
            <span class="links_name">Inventory</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-list-ul' ></i>
            <span class="links_name">Room Booking</span>
          </a>
        </li>
        <li>
          <a href="#" class="active">
            <i class='bx bx-pie-chart-alt-2' ></i>
            <span class="links_name">Hotel Rooms</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-coin-stack' ></i>
            <span class="links_name">Transport</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-book-alt' ></i>
            <span class="links_name">Employee</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-user' ></i>
            <span class="links_name">Restaurant</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-message' ></i>
            <span class="links_name">Banquet Hall</span>
          </a>
        </li>
         <li>
          <a href="#" >
            <i class='bx bx-grid-alt' ></i>
            <span class="links_name">Vehicle Booking </span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-heart' ></i>
            <span class="links_name">Favrorites</span>
          </a>
        </li>
        <li>
          <a href="#">
            <i class='bx bx-cog' ></i>
            <span class="links_name">Setting</span>
          </a>
        </li>
		
        <li class="log_out">
          <a href="#">
            <i class='bx bx-log-out'></i>
            <span class="links_name">Log out</span>
          </a>
        </li>
      </ul>
  </div>
  <section class="home-section">
    <nav>
      <div class="sidebar-button">
        <i class='bx bx-menu sidebarBtn'></i>
        <span class="dashboard">Dashboard</span>
      </div>
      <div class="search-box">
        <input type="text" placeholder="Search...">
        <i class='bx bx-search' ></i>
      </div>
      <div class="profile-details">
        <img src="images/profile.png" alt="">
        <span class="admin_name">Hello!! Admin</span>
        
      </div>
    </nav>
    <br><br> <br><br>
    
    <div class="container" style="max-width: 600px; max-height:750px; box-shadow: 5px 10px 18px #888888;">
    <br>
    <h4 style="text-align:center;">Add New Room</h4>
		
		<br>
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
		<div>
			<form action="HotelRoomController" method="get">
			
			<input type="hidden" name="COMMAND" value="ADD">
				
			
				<div class="input-group">
  				<div class="your-class">
        			<!-- declaration for first field -->
        			<p>Room Type:</p>
  					<input type="radio" id="Single" name="roomType" value="Single" >
  					<label for="Single">Single</label>
  					<input type="radio" id="Double" name="roomType" value="Double" >
  					<label for="Double" >Double</label>
				</div>
				</div>
				<br>
				<div class="jumbotron" style="max-width:50%;max-height:250px;">
  				<div class="your-class" >
        			<!-- declaration for first field -->
        			<p>Facilities:</p>
  					<input type="checkbox" id="AttachBathroom" name="facilities" value="AttachBathroom" >
  					<label for="AttachBathroom">Attach Bathroom</label><br>
  					<input type="checkbox" id="AC" name="facilities" value="AC" >
  					<label for="AC" >AC</label><br>
					<input type="checkbox" id="WashingMachine" name="facilities" value="WashingMachine" >
  					<label for="WashingMachine" >Washing Machine</label><br>
  					<input type="checkbox" id="Heater" name="facilities" value="Heater" >
  					<label for="Heater" >Heater</label><br>
					<!--  <input type="checkbox" id="WashingMachine" name="facilities" value="WashingMachine" >
  					<label for="WashingMachine" >Washing Machine</label>-->
				</div>
				</div>
				<div class="form-group">
					<label for="inputType">Cost Per Day: </label>
					<input type="text" id="inputype" name="cost" placeholder="Enter Cost" class="form-control" required="required">
				</div>
				
				
		
				
					<br>
				
				
				<div class="row">
					<div class="col text-center">
						<input type="submit" value="Add" class="btn btn-success btn-block">
					</div>
				</div>
					
			</form>
			
			<br>
			<div style="text-align:center; margin-bottom: 20px;">
				
				<button  class="btn btn-link" type="submit"><a href="admin-view-added-hotel-rooms.jsp">Back to List</a></button>
			</div>
			
			<br>
		</div>
		
		
		
		
		
	</div>
	
		
	
 
 
  

  <script>
   let sidebar = document.querySelector(".sidebar");
let sidebarBtn = document.querySelector(".sidebarBtn");
sidebarBtn.onclick = function() {
  sidebar.classList.toggle("active");
  if(sidebar.classList.contains("active")){
  sidebarBtn.classList.replace("bx-menu" ,"bx-menu-alt-right");
}else
  sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
}
 </script>

</body>
</html>