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
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- For Showing Active Menu on Page -->
<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}'
</script>


<title>Shubham Travels - ${title}</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">
<!-- For Font in bootstrap -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
	<!-- Variable CSS that is created at the TOP -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">
</head>


<body id="page">
	<div class="wrapper-image">
		
		<!-- Inlcuding JSP for Background image Silder -->	
		<%@include file="home-slider.jsp"%>
		
		<div id="nav-bar">
			<!-- Include Navigation JSP -->
			<%@include file="./shared/nav.jsp"%>
		</div>
		
		<!-- Inlcuding travel information picker JSP -->
		
	</div>

	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.js"></script>
	<script src="${js}/bootstrap.bundle.min.js"></script>
	<script src="${js}/myapp.js"></script>
</head>


</body>
</html>
