<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<div class="card">
		<article class="card-group-item">

			<header class="card-header">
				<h3 class="title">By Type</h3>
			</header>
			<label style="align-content: right;"><a href="${contextRoot}/show/vehicles">Clear All</a></label>
			<div class="filter-content">
				<div class="list-group list-group-flush">
					<c:forEach items="${catList}" var="list">
						<a id="a_${list.name}"
							href="${contextRoot}/show/category/${list.id}/vehicle"
							class="list-group-item">${list.name}<span
							class="float-right badge badge-light round">142</span>
						</a>
					</c:forEach>
				</div>
			</div>
		</article>
		<!-- card-group-item.// -->
		<article class="card-group-item">
			<header class="card-header">
				<h3 class="title">By Fuel Type</h3>
			</header>
			<div class="filter-content">
				<div class="card-body">
					<label class="btn btn-default" id="petrol"> <input class=""
						type="radio" name="myradio" value="Petrol"> <span
						class="form-check-label">Petrol</span>
					</label> <label class="btn btn-default"> <input class=""
						type="radio" name="myradio" value="Diesel"> <span
						class="form-check-label">Diesel</span>
					</label> <label class="btn btn-default"> <input class=""
						type="radio" name="myradio" value="CNG"> <span
						class="form-check-label">CNG</span>
					</label>
				</div>
				<!-- card-body.// -->
			</div>
		</article>
		<!-- card-group-item.// -->
		<!-- By Mileage -->
		<article class="card-group-item">
			<header class="card-header">
				<h3 class="title">By Mileage</h3>
			</header>
			<div class="filter-content">
				<div class="card-body">
					<label class="form-check"> <input class="form-check-input"
						type="radio" name="mileageRadio" value=">10KM"> <span
						class="form-check-label"> Less than 10KM </span>
					</label> <label class="form-check"> <input class="form-check-input"
						type="radio" name="mileageRadio" value="10-15KM"> <span
						class="form-check-label"> Between 10-15KM </span>
					</label> <label class="form-check"> <input class="form-check-input"
						type="radio" name="mileageRadio" value="<15KM"> <span
						class="form-check-label"> Greater than 15KM </span>
					</label>
				</div>
				<!-- card-body.// -->
			</div>
		</article>
	</div>
	<!-- card.// -->
</body>
</html>