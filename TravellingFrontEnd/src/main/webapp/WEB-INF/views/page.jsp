<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Setting context Root variable  -->
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!-- Path for static resources -->
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="image" value="/resources/images" />


<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Shubham Travels</title>
<!-- For Showing Active Menu on Page -->
<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Shubham Travels Chhindwara" />
<meta name="keywords"
	content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
<meta name="author" content="Pratik Sharma" />

<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon" href="favicon.ico">
<!-- For icons -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300'
	rel='stylesheet' type='text/css'>

<!--  For Time Picker CSS -->
<link href="http://cdn.jsdelivr.net/timepicker.js/latest/timepicker.min.css" rel="stylesheet"/>

<!-- Animate.css -->
<link rel="stylesheet" href="${css}/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="${css}/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="${css}/bootstrap.css">
<!-- Superfish -->
<link rel="stylesheet" href="${css}/superfish.css">
<!-- Magnific Popup -->
<link rel="stylesheet" href="${css}/magnific-popup.css">
<!-- Date Picker -->
<link rel="stylesheet" href="${css}/bootstrap-datepicker.min.css">
<!-- CS Select -->
<link rel="stylesheet" href="${css}/cs-select.css">
<link rel="stylesheet" href="${css}/cs-skin-border.css">
<!-- For adding CSS JQuery Data Table -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

<!-- For custom CSS styling -->
<link rel="stylesheet" href="${css}/myapp.css">

<link rel="stylesheet" href="${css}/style.css">


<!-- Modernizr JS -->
<script src="${js}/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

</head>
<body>
	<div id="fh5co-wrapper">
		<div id="fh5co-page">

			<!-- Including Navigation , it should always be there -->
			<%@include file="./shared/nav-bar.jsp"%>

			<!-- Load only when user clicked home -->
			<c:if test="${userClickedHome == true}">
				<!-- Including Travel info section -->
				<%@include file="tabular.jsp"%>
			</c:if>

			<!-- Load only when user clicked home -->
			<c:if test="${userClickedHome == true}">
				<!-- Including Car Collection Section -->
				<%@include file="car-collection.jsp"%>
			</c:if>

			<!-- Load only when user clicked home -->
			<c:if test="${userClickedHome == true}">
				<!-- Including Popular Destination Section -->
				<%@include file="popular-destination.jsp"%>
			</c:if>

			<!-- Load only when user clicked home -->
			<c:if test="${userClickedHome == true}">
				<!-- Including Testimonial Section  -->
				<%@include file="testimonial.jsp"%>
			</c:if>

			<!-- Load when user clicked View all cars -->
			<!-- Load only when user clicked home -->
			<c:if test="${userClickedCarsList == true || userClickedCatProducts == true}">
				<!-- Including Vehicle list Section  -->
				<%@include file="vehicles-list.jsp"%>
			</c:if>


			<!-- Including Footer Section, it should always be there -->
			<%@include file="./shared/footer.jsp"%>

		</div>
	</div>

	<!-- jQuery -->

	<script src="${js}/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="${js}/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="${js}/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="${js}/jquery.waypoints.min.js"></script>
	<script src="${js}/sticky.js"></script>

	<!-- Stellar -->
	<script src="${js}/jquery.stellar.min.js"></script>
	<!-- Superfish -->
	<script src="${js}/hoverIntent.js"></script>
	<script src="${js}/superfish.js"></script>
	<!-- Magnific Popup -->
	<script src="${js}/jquery.magnific-popup.min.js"></script>
	<script src="${js}/magnific-popup-options.js"></script>
	<!-- Date Picker -->
	<script src="${js}/bootstrap-datepicker.min.js"></script>
	<!-- CS Select -->
	<script src="${js}/classie.js"></script>
	<script src="${js}/selectFx.js"></script>
	<!-- JQuery DataTable Plugin -->
	<script src="${js}/jquery.dataTables.js"></script>
	<!-- JQuery DataTable Design -->
	<script src="${js}/dataTables.bootstrap4.js"></script>
	<!-- Jquery for Time Picker Library -->
	<script src="http://cdn.jsdelivr.net/timepicker.js/latest/timepicker.min.js"></script>

	<!-- Main JS -->
	<script src="${js}/myapp.js"></script>

</body>
</html>

