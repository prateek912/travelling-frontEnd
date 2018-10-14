<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="item active">
        <img src="http://placehold.it/600x300?text=Offers">
        <div class="carousel-caption">
          <h3>Flat 10% Discount</h3>
          <p>Code: EXUP10</p>
        </div>
      </div>

      <div class="item">
        <img src="http://placehold.it/600x300?text=Offers">
        <div class="carousel-caption">
          <h3>Flat 10% Discount</h3>
          <p>Code: EXUP10</p>
        </div>
      </div>
    
      <div class="item">
        <img src="http://placehold.it/600x300?text=Offers">
        <div class="carousel-caption">
          <h3>Flat 10% Discount</h3>
          <p>Code: EXUP10 </p>
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</body>
</html>