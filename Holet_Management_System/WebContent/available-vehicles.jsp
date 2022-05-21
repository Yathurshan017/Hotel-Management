<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Available Vehicles</title>
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
<!------ Light Box ------>
<link rel="stylesheet" href="css/swipebox.css">
<script src="js/jquery.swipebox.min.js"></script> 
    <script type="text/javascript">
		jQuery(function($) {
			$(".swipebox").swipebox();
		});
	</script>
<!------ Eng Light Box ------>	
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
	    		    <div class="clearfix"></div>
	    	    </div>
	            <div class="col-sm-4 header_right">
	    		      <div id="loginContainer"><a href="index.jsp" id="loginButton"><img src="images/login.png"><span> Logout</span></a>
						    
			             </div>
		                 <div class="clearfix"></div>
	                 </div>
	                <div class="clearfix"></div>
   </div>
    <div class="banner">
   	  <div class="container_wrap">
   		<h1>What are you looking for?</h1>
   	       <div class="dropdown-buttons">   
            		  <div class="dropdown-button">           			
            			<select onChange="window.location.href=this.value" class="dropdown" tabindex="9" data-settings='{"wrapperClass":"flat"}'>
            			<option value="#">Available Vehicles</option>	
						<option value="transport-home.jsp">All Available Vehicles</option>
						<option value="#">Car</option>
						<option value="#">Van</option>
						<option value="#">Bike</option>
						<option value="#">Auto </option>
						
					
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
	               <button type="button" class="btn btn-warning btn-lg" onclick="location.href = 'available-vehicles.jsp';">Check Available</button>
	            </div>
			</form>        		
   		    <div class="clearfix"></div>
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
   	  	<h2 class="title block-title">Available Vehicles</h2>
   	   <div class="col-md-4 wow fadeInLeft" data-wow-delay="0.4s">
   <div class="living_box"><a href="#">
			    <img src="images/car2.jpg" class="img-responsive" alt=""/>
				<span class="sale-box">
				  <span class="sale-label">Car</span>
			    </span>
				</a>
				<div class="living_desc">
				<h3><a href="#">aliquam volutp</a></h3>
				<p>Lorem ipsum consectetuer adipiscing </p>
				<a href="book-vehicles.jsp" class="btn3">Book</a>
				<p class="price">$10.00</p>
				</div>
			    <table border="1" class="propertyDetails">
                <tbody><tr>
                   <td><img src="images/area.png" alt="" style="margin-right:7px;">1 KM</td>
                   <td><img src="" alt="" style="margin-right:7px;">$10.00</td>
                  
                    </tr>
                </tbody></table>
			</div>
		 </div>
   	     <div class="col-md-4 wow fadeInLeft" data-wow-delay="0.4s">
   	     	<div class="living_box"><a href="#">
			    <img src="images/van.jpg" class="img-responsive" alt=""/>
				<span class="sale-box">
				  <span class="sale-label">Van</span>
			    </span>
				</a>
				<div class="living_desc">
				<h3><a href="#">aliquam volutp</a></h3>
				<p>Lorem ipsum consectetuer adipiscing </p>
				<a href="book-vehicles.jsp" class="btn3">Book</a>
				<p class="price">$30.00</p>
				</div>
			    <table border="1" class="propertyDetails">
                <tbody><tr>
                   <td><img src="images/area.png" alt="" style="margin-right:7px;">1 KM</td>
                   <td><img src="" alt="" style="margin-right:7px;">$ 30.00</td>
                   
                    </tr>
                </tbody></table>
			</div>
   	     </div>
   	     <div class="col-md-4 wow fadeInLeft" data-wow-delay="0.4s">
   	     	<div class="living_box"><a href="#">
			    <img src="images/car1.jpg" class="img-responsive" alt=""/>
				<span class="sale-box">
				  <span class="sale-label">Car</span>
			    </span>
				</a>
				<div class="living_desc">
				<h3><a href="#">aliquam volutp</a></h3>
				<p>Lorem ipsum consectetuer adipiscing </p>
				<a href="book-vehicles.jsp" class="btn3">Book</a>
				<p class="price">$20.00</p>
				</div>
			    <table border="1" class="propertyDetails">
                <tbody><tr>
                   <td><img src="images/area.png" alt="" style="margin-right:7px;">1 KM</td>
                   <td><img src="" alt="" style="margin-right:7px;">$ 10.00</td>
                  
                    </tr>
                </tbody></table>
			</div>
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