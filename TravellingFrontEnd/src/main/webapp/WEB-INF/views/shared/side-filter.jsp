<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body>

	<!-- For Proper Filtering and making sure different API Url in different cases -->
	<c:if test="${userClickedCarsList == true}">
		<script type="text/javascript">
			// Storing categoryId in global variable
			/*
			 *   This variable will be only set when user click View Product
			 */
			// As no id will be selected here
			window.categoryId = '';
		</script>
	</c:if>
	<c:if test="${userClickedCatProducts == true}">
		<script type="text/javascript">
			// Storing categoryId in global variable
			/*
			 *   This variable will be only set when user click View Product
			 */
			window.categoryId = '${cat.id}';
		</script>
	</c:if>

	<div class="nav-side-menu">
		<div class="container">
			<div class="row">
				<div class="col-md-1">
					<span style="margin-left: 0px;"><h4>Filter</h4></span>
				</div>
				<div class="col-md-1">
					<label style="align-content: right;"><a class="btn btn-primary btn-outline btn-lg"
						href="${contextRoot}/show/vehicles">Clear All</a></label>
				</div>

			</div>
		</div>
		<div class="brand"></div>
		<i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse"
			data-target="#menu-content"></i>

		<div class="menu-list">

			<ul id="menu-content" class="menu-content collapse out">
				<li data-toggle="collapse" data-target="#products"
					class="collapsed active"><a href="#"><i
						class="fa fa-gift fa-lg"></i> By Type <span class="arrow"></span></a>
				</li>
				<ul class="sub-menu collapse" id="products">
					<c:forEach items="${catList}" var="list">
						<li><label> <input id="a_${list.name}"
								type="checkbox" class="search_filters" value="${list.id}"
								name="catId" /> <span>${list.name}</span>
						</label></li>
					</c:forEach>
				</ul>


				<li data-toggle="collapse" data-target="#service" class="collapsed">
					<a href="#"><i class="fa fa-globe fa-lg"></i> By Fuel Type <span
						class="arrow"></span></a>
				</li>
				<ul class="sub-menu collapse" id="service">
					<li><label><input type="radio" name="fuelType"
							value="Petrol" class="search_filters"><span>Petrol</span></label></li>
					<li><label><input type="radio" name="fuelType"
							value="Diesel" class="search_filters"><span>Diesel</span></label></li>
					<li><label><input type="radio" name="fuelType"
							value="CNG" class="search_filters"><span>CNG</span></label></li>
				</ul>


				<li data-toggle="collapse" data-target="#new" class="collapsed">
					<a href="#"><i class="fa fa-car fa-lg"></i> By Mileage <span
						class="arrow"></span></a>
				</li>
				<ul class="sub-menu collapse" id="new">
					<li><label><input type="radio" name="mileage"
							value="<10KM" class="search_filters"><span>Less
								Than 10KM</span></label></li>
					<li><label><input type="radio" name="mileage"
							value="10-15KM" class="search_filters"><span>Between
								10-15KM</span></label></li>
					<li><label><input type="radio" name="mileage"
							value="<15KM" class="search_filters"><span>Greater
								than 15KM</span></label></li>
				</ul>
				<li data-toggle="collapse" data-target="#seaters"
					class="collapsed active"><a href="#"><i
						class="fa fa-gift fa-lg"></i> By Seater <span class="arrow"></span></a>
				</li>
				<ul class="sub-menu collapse" id="seaters">
					<c:forEach items="${numberOfSeaterList}" var="list">
						<li><label> <input id="a_${list}"
								type="radio" class="search_filters" value="${list}"
								name="numberOfSeater" /> <span>${list} People</span>
						</label></li>
					</c:forEach>
				</ul>
				
			</ul>
		</div>
	</div>
</body>
</html>