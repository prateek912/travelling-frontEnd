<div class="container">
	<div class="topDiv">
		<div class="row">
			<!-- First Column -->
			<!-- To display side bar -->
			<div class="col-lg-3">
				<%@include file="./shared/side-filter.jsp"%>
			</div>

			<!-- Second Column -->
			<!-- To display Product -->
			<div class="col-lg-9">
				<!-- Adding BreadCrumb -->
				<div class="row">
					<div class="col-lg-12">
						<!-- If Clicked on All Product then breadCrumb -->
						<c:if test="${userClickedCarsList == true}">
							<script type="text/javascript">
								// Storing categoryId in global variable
								/*
								 *   This variable will be only set when user click View Product
								 */
								// As no id will be selected here
								window.categoryId = '';
							</script>
							<ol id="breadcrumb" class="breadcrumb">
								<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
								<li class="breadcrumb-item active">All Products</li>
							</ol>
						</c:if>
						<c:if test="${userClickedCatProducts == true}">
							<script type="text/javascript">
								// Storing categoryId in global variable
								/*
								 *   This variable will be only set when user click View Product
								 */
								window.categoryId = '${cat.id}';
							</script>
							<ol id="breadcrumb" class="breadcrumb">
								<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
								<li class="breadcrumb-item active">Category</li>
								<li class="breadcrumb-item active">${cat.name}</li>
							</ol>
						</c:if>
					</div>
				</div>
				<!-- Actual Dynamic Product -->
				<div class="row">
					<div class="col-lg-12">
						<div class="container-fluid">
							<div class="table-responsive table">
								<table id="vehicleListTable"
									class="table table-striped table-border">
									<thead>
										<tr>
											<th></th>
											<th>Name</th>
											<th>Brand</th>
											<th>Price/Km</th>
											<th>Fuel Type</th>
											<th>Mileage</th>
											<th></th>
										</tr>
									</thead>
									<!-- Body will be filled by JQuery Data Table -->
									<tfoot>
										<tr>
											<th></th>
											<th>Name</th>
											<th>Brand</th>
											<th>Price/Km</th>
											<th>Fuel Type</th>
											<th>Mileage</th>
											<th></th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
