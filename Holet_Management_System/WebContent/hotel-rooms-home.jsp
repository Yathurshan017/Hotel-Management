<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Hotel Rooms</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
	<link rel="stylesheet" href="css/universal_style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


<style>
.cards-wrapper {
  display: flex;
  justify-content: center;
}
.card img {
  max-width: 100%;
  max-height: 100%;
}
.card {
  margin: 0 0.5em;
  box-shadow: 2px 6px 8px 0 rgba(22, 22, 26, 0.18);
  border: none;
  border-radius: 0;
  margin-top:2%;
}
.carousel-inner {
  padding: 1em;
}
.carousel-control-prev,
.carousel-control-next {
  background-color: #e1e1e1;
  width: 50px;
  height: 50px;
  border-radius: 50%;
  margin-top:15%;
  transform: translateY(-50%);
  
}
@media (min-width: 768px) {
  .card img {
    height: 11em;
  }
}
.carousel-control-next {
margin-right:7%;
}

.carousel-control-prev {
margin-left:7%;
}


 



</style>
</head>
<body>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand text-center" href="index.jsp" style="margin: 0 auto;"><img Style="max-width:148px;" src="images/download.png"></a>
			
			<ul class="navbar-nav">
				
				<li class="nav-item">
					
					<a class="nav-link" href="index.jsp" style="color: #F1F1F1;"><i class="fas fa-sign-out-alt"></i> Home</a>
				</li>
			</ul>
		</div>
	</nav>
	
	<nav class="navbar navbar-light" style="background-color:#007bff; color:#ffffff;">
		<div class="container">
			<h2><i class="fas fa-sign-in-alt"></i> Hotel Rooms</h2>
		</div>
	</nav>
<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <div class="cards-wrapper">
      <div class="card" style="width:400px">
        <img src="images/pic3.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          
          <p class="card-text">Room Type : Double</p>
          <p class="card-text">Facilities : AC / 3 Bathrooms / TV</p>
          <p class="card-text">Cost Per Day : $100.00</p>
          <p class="card-text">Room No : R001</p>
          <a href="admin-add-hotel-rooms.jsp" class="btn btn-primary">Book This</a>
        </div>
      </div>
      <div class="card d-none d-md-block" style="width:400px">
        <img src="images/pic6.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          <p class="card-text">Room Type : Double</p>
          <p class="card-text">Facilities : AC / 3 Bathrooms / TV</p>
          <p class="card-text">Cost Per Day : $100.00</p>
          <p class="card-text">Room No : R001</p>
          <a href="admin-add-hotel-rooms.jsp" class="btn btn-primary">Book This</a>
        </div>
      </div>
      <div class="card d-none d-md-block" style="width:400px">
        <img src="images/pic4.jpg" class="card-img-top" alt="...">
        <div class="card-body">
          <p class="card-text">Room Type : Double</p>
          <p class="card-text">Facilities : AC / 3 Bathrooms / TV</p>
          <p class="card-text">Cost Per Day : $100.00</p>
          <p class="card-text">Room No : R001</p>
          <a href="admin-add-hotel-rooms.jsp" class="btn btn-primary">Book This</a>
        </div>
      </div>
    </div>
    </div>
    <div class="carousel-item">
      <div class="cards-wrapper">
        <div class="card" style="width:400px">
          <img src="images/pic6.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Room Type : Double</p>
          <p class="card-text">Facilities : AC / 3 Bathrooms / TV</p>
          <p class="card-text">Cost Per Day : $100.00</p>
          <p class="card-text">Room No : R001</p>
          <a href="admin-add-hotel-rooms.jsp" class="btn btn-primary">Book This</a>
          </div>
        </div>
        <div class="card d-none d-md-block" style="width:400px">
          <img src="images/s3.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Room Type : Double</p>
          <p class="card-text">Facilities : AC / 3 Bathrooms / TV</p>
          <p class="card-text">Cost Per Day : $100.00</p>
          <p class="card-text">Room No : R001</p>
          <a href="admin-add-hotel-rooms.jsp" class="btn btn-primary">Book This</a>
          </div>
        </div>
        <div class="card d-none d-md-block" style="width:400px">
          <img src="images/s2.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Room Type : Double</p>
          <p class="card-text">Facilities : AC / 3 Bathrooms / TV</p>
          <p class="card-text">Cost Per Day : $100.00</p>
          <p class="card-text">Room No : R001</p>
          <a href="admin-add-hotel-rooms.jsp" class="btn btn-primary">Book This</a>
          </div>
        </div>
      </div>
    </div>
    <div class="carousel-item">
      <div class="cards-wrapper">
        <div class="card" style="width:400px">
          <img src="images/pic3.jpg" class="card-img-top" alt="...">
          <div class="card-body">
           <p class="card-text">Room Type : Double</p>
          <p class="card-text">Facilities : AC / 3 Bathrooms / TV</p>
          <p class="card-text">Cost Per Day : $100.00</p>
          <p class="card-text">Room No : R001</p>
          <a href="admin-add-hotel-rooms.jsp" class="btn btn-primary">Book This</a>
          </div>
        </div>
        <div class="card d-none d-md-block" style="width:400px">
          <img src="images/pic6.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Room Type : Double</p>
          <p class="card-text">Facilities : AC / 3 Bathrooms / TV</p>
          <p class="card-text">Cost Per Day : $100.00</p>
          <p class="card-text">Room No : R001</p>
          <a href="admin-add-hotel-rooms.jsp" class="btn btn-primary">Book This</a>
          </div>
        </div>
        <div class="card d-none d-md-block" style="width:400px">
          <img src="images/s2.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <p class="card-text">Room Type : Double</p>
          <p class="card-text">Facilities : AC / 3 Bathrooms / TV</p>
          <p class="card-text">Cost Per Day : $100.00</p>
          <p class="card-text">Room No : R001</p>
          <a href="admin-add-hotel-rooms.jsp" class="btn btn-primary">Book This</a>
          </div>
        </div>
      </div>
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
		 
<footer class="page-footer font-small navbar-dark bg-dark" style="color:#ffffff; position: fixed; left: 0; bottom: 0; width: 100%;">
		<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
	</footer>
</body>
</html>

