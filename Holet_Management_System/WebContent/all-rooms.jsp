<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Room Reservation</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Hotel Deluxe Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script src="js/jquery.easydropdown.js"></script>
<script src="js/wow.min.js"></script>
<link href="css/animate.css" rel='stylesheet' type='text/css' />
<script>
	new WOW().init();
</script>
</head>
<body>
<div class="header">
		   <div class="col-sm-8 header-left">
					 <div class="logo">
						<a href="index.html"><img Style="max-width:148px;" src="images/download.png" alt=""/></a>
					 </div>
					 
				     <!-- start search-->
				      <div class="search-box">
							<div id="sb-search" class="sb-search">
								<form>
									<input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
									<input class="sb-search-submit" type="submit" value="">
									<span class="sb-icon-search"> </span>
								</form>
							</div>
						</div>
						<!----search-scripts---->
						<script src="js/classie.js"></script>
						<script src="js/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
						<!----//search-scripts---->						
	    		    <div class="clearfix"> </div>
	    	    </div>
	            <div class="col-sm-4 header_right">
	    		      <div id="loginContainer"><a href="index.jsp" id="loginButton"><img src="images/login.png"><span> Logout</span></a>
						    
			             </div>
		                 <div class="clearfix"> </div>
	                 </div>
	                <div class="clearfix"> </div>
    </div>
    <div class="banner">
   	  <div class="container_wrap">
   		<h1>What are you looking for?</h1>
   	       <div class="dropdown-buttons"> 
   	       
            		  <div class="dropdown-button">           			
            			<select onChange="window.location.href=this.value" class="dropdown" tabindex="9" data-settings='{"wrapperClass":"flat"}'>
            			<option value="#">All Rooms</option>
						<option value="availablerooms.jsp">Available Rooms</option>
						<option value="availablerooms.jsp">Single Rooms</option>
						<option value="availablerooms.jsp">Dual Rooms</option>
						<option value="availablerooms.jsp">Luxury Rooms</option>
						<option value="availablerooms.jsp">Normal Rooms</option>
						
					
					  </select>
					</div>
			 <!-- 
				     <div class="dropdown-button">
					  <select class="dropdown" tabindex="9" data-settings='{"wrapperClass":"flat"}'>
            			<option value="0">Hotels</option>	
						<option value="1">tempor</option>
						<option value="2">congue</option>
						<option value="3">maxim </option>
						<option value="4">mutationem</option>
						<option value="5">hendrerit </option>
						<option value="5"></option>
						<option value="5"></option>
					  </select>
					 </div>
					 -->
				   </div>  
				   
		    <form>
				
			    <div class="contact_btn">
	            
<button type="button" class="btn btn-warning btn-lg" onclick="location.href = 'availablerooms.jsp';">Check Available</button>


	            </div>
			</form>        		
   		    <div class="clearfix"> </div>
         </div>
    </div>
      <div class="content_top">
   	  <div class="container">
   		<div class="col-md-4 bottom_nav">
   		   
		</div>
		
   	</div>
   </div>
   <div class="living_middle">
   	  <div class="container">
   	  		<h2 class="title block-title">All Rooms</h2>
   	  		 <div class="entertain_box wow fadeInLeft" data-wow-delay="0.4s">
		   <div class="col-md-3 grid_box">
		   	   <div class="living_box"><a href="#">
			    <img src="images/l1.jpg" class="img-responsive" alt=""/>
				<span class="sale-box">
				  <span class="sale-label">Rooms</span>
			    </span>
				</a>
				<div class="living_desc">
				<h3><a href="#">Hilton Hottel</a></h3>
				<p>Lorem ipsum consectetuer adipiscing </p>
				<a href="add-rooms.jsp" class="btn3">Rent</a>
				<p class="price">$99.00</p>
				</div>
			    <table border="1" class="propertyDetails">
                <tbody><tr>
                   <td><img src="images/area.png" alt="" style="margin-right:7px;">2,412m</td>
                   <td><img src="images/bed.png" alt="" style="margin-right:7px;">6 Beds</td>
                   <td><img src="images/drop.png" alt="" style="margin-right:7px;">3 Baths</td>
                    </tr>
                </tbody></table>
			</div>
		   </div>
		   <div class="col-md-3 grid_box">
		   	   <div class="living_box"><a href="#">
			    <img src="images/l1.jpg" class="img-responsive" alt=""/>
				<span class="sale-box">
				  <span class="sale-label">Rooms</span>
			    </span>
				</a>
				<div class="living_desc">
				<h3><a href="#">Cinnamon Grand</a></h3>
				<p>Lorem ipsum consectetuer adipiscing </p>
				<a href="add-rooms.jsp" class="btn3">Rent</a>
				<p class="price">$100.00</p>
				</div>
			    <table border="1" class="propertyDetails">
                <tbody><tr>
                   <td><img src="images/area.png" alt="" style="margin-right:7px;">2,412m</td>
                   <td><img src="images/bed.png" alt="" style="margin-right:7px;">6 Beds</td>
                   <td><img src="images/drop.png" alt="" style="margin-right:7px;">3 Baths</td>
                    </tr>
                </tbody></table>
			</div>
		   </div>
		   <div class="col-md-3 grid_box">
		   	   <div class="living_box"><a href="#">
			    <img src="images/l1.jpg" class="img-responsive" alt=""/>
				<span class="sale-box">
				  <span class="sale-label">Rooms</span>
			    </span>
				</a>
				<div class="living_desc">
				<h3><a href="#">Kingsberry Hottel</a></h3>
				<p>Lorem ipsum consectetuer adipiscing </p>
				<a href="add-rooms.jsp" class="btn3">Rent</a>
				<p class="price">$100.00</p>
				</div>
			    <table border="1" class="propertyDetails">
                <tbody><tr>
                   <td><img src="images/area.png" alt="" style="margin-right:7px;">2,412m</td>
                   <td><img src="images/bed.png" alt="" style="margin-right:7px;">6 Beds</td>
                   <td><img src="images/drop.png" alt="" style="margin-right:7px;">3 Baths</td>
                    </tr>
                </tbody></table>
			</div>
		   </div>
		   <div class="col-md-3 grid_box">
		   	   <div class="living_box"><a href="#">
			    <img src="images/l2.jpg" class="img-responsive" alt=""/>
				<span class="sale-box">
				  <span class="sale-label">Rooms</span>
			    </span>
				</a>
				<div class="living_desc">
				<h3><a href="#">aliquam volutp</a></h3>
				<p>Lorem ipsum consectetuer adipiscing </p>
				<a href="add-rooms.jsp" class="btn3">Rent</a>
				<p class="price">$89.00</p>
				</div>
			    <table border="1" class="propertyDetails">
                <tbody><tr>
                   <td><img src="images/area.png" alt="" style="margin-right:7px;">2,412m</td>
                   <td><img src="images/bed.png" alt="" style="margin-right:7px;">6 Beds</td>
                   <td><img src="images/drop.png" alt="" style="margin-right:7px;">3 Baths</td>
                    </tr>
                </tbody></table>
			</div>
		   </div>
		   <div class="clearfix"> 
		   </div>
		 </div>	
		 <div class="entertain_box1 wow fadeInRight" data-wow-delay="0.4s">
		 <div class="col-md-3 grid_box">
		   <div class="living_box"><a href="#">
			    <img src="images/l1.jpg" class="img-responsive" alt=""/>
				<span class="sale-box">
				  <span class="sale-label">Rooms</span>
			    </span>
				</a>
				<div class="living_desc">
				<h3><a href="#">aliquam volutp</a></h3>
				<p>Lorem ipsum consectetuer adipiscing </p>
				<a href="add-rooms.jsp" class="btn3">Rent</a>
				<p class="price">$100.00</p>
				</div>
			    <table border="1" class="propertyDetails">
                <tbody><tr>
                   <td><img src="images/area.png" alt="" style="margin-right:7px;">2,412m</td>
                   <td><img src="images/bed.png" alt="" style="margin-right:7px;">6 Beds</td>
                   <td><img src="images/drop.png" alt="" style="margin-right:7px;">3 Baths</td>
                    </tr>
                </tbody></table>
			</div>
		   </div>
		   <div class="col-md-3 grid_box">
		   	   <div class="living_box"><a href="#">
			    <img src="images/l1.jpg" class="img-responsive" alt=""/>
				<span class="sale-box">
				  <span class="sale-label">Rooms</span>
			    </span>
				</a>
				<div class="living_desc">
				<h3><a href="#">aliquam volutp</a></h3>
				<p>Lorem ipsum consectetuer adipiscing </p>
				<a href="add-rooms.jsp" class="btn3">Rent</a>
				<p class="price">$100.00</p>
				</div>
			    <table border="1" class="propertyDetails">
                <tbody><tr>
                   <td><img src="images/area.png" alt="" style="margin-right:7px;">2,412m</td>
                   <td><img src="images/bed.png" alt="" style="margin-right:7px;">6 Beds</td>
                   <td><img src="images/drop.png" alt="" style="margin-right:7px;">3 Baths</td>
                    </tr>
                </tbody></table>
			</div>
		   </div>
		   <div class="col-md-3 grid_box">
		   	   <div class="living_box"><a href="#">
			    <img src="images/l2.jpg" class="img-responsive" alt=""/>
				<span class="sale-box">
				  <span class="sale-label">Rooms</span>
			    </span>
				</a>
				<div class="living_desc">
				<h3><a href="#">aliquam volutp</a></h3>
				<p>Lorem ipsum consectetuer adipiscing </p>
				<a href="add-rooms.jsp" class="btn3">Rent</a>
				<p class="price">$89.00</p>
				</div>
			    <table border="1" class="propertyDetails">
                <tbody><tr>
                   <td><img src="images/area.png" alt="" style="margin-right:7px;">2,412m</td>
                   <td><img src="images/bed.png" alt="" style="margin-right:7px;">6 Beds</td>
                   <td><img src="images/drop.png" alt="" style="margin-right:7px;">3 Baths</td>
                    </tr>
                </tbody></table>
			</div>
		   </div>
		   <div class="col-md-3 grid_box">
			<div class="living_box"><a href="#">
			    <img src="images/l1.jpg" class="img-responsive" alt=""/>
				<span class="sale-box">
				  <span class="sale-label">Rooms</span>
			    </span>
				</a>
				<div class="living_desc">
				<h3><a href="#">aliquam volutp</a></h3>
				<p>Lorem ipsum consectetuer adipiscing </p>
				<a href="add-rooms.jsp" class="btn3">Rent</a>
				<p class="price">$100.00</p>
				</div>
			    <table border="1" class="propertyDetails">
                <tbody><tr>
                   <td><img src="images/area.png" alt="" style="margin-right:7px;">2,412m</td>
                   <td><img src="images/bed.png" alt="" style="margin-right:7px;">6 Beds</td>
                   <td><img src="images/drop.png" alt="" style="margin-right:7px;">3 Baths</td>
                    </tr>
                </tbody></table>
			</div>		   
			</div>
		   <div class="clearfix"> </div>
		 </div>
		 
   	    
   	    </div>
   </div>

   <div class="footer">
   	
   	 
	  <footer class="page-footer font-small navbar-dark bg-dark" style="color:#ffffff; left: 0; bottom: 0; width: 100%; margin-top: 20px;">
		<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
	</footer>
      </div>
  
</body>
</html>		