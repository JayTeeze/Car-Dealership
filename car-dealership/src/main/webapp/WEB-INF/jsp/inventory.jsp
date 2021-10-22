<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Inventory</title>
<style>
.carData{
 color: black;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		  <span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		  <div class="navbar-nav">
			<a class="nav-item nav-link" href="/">Home</a>
			<a class="nav-item nav-link active" href="/inventory">Inventory<span class="sr-only">(current)</span></a>
			<a class="nav-item nav-link" href="/modifyInventory">Modify Inventory</a>
			<a class="nav-item nav-link" href="/allTransactions">Transactions</a>
		  </div>
		</div>
	</nav>
	
	<div class="container">
    	<div class="row justify-content-center">
      		<h3>Inventory</h3>
    	</div>
 	</div>
 	
	<div class="container">
		<div class="row">
	   		<div class="col-4">
		   		<form action="/inventory/findByKeyword">
			   		<div class="input-group mb-1">
				   		<input type="text" class="form-control" id="keyword" name="keyword" maxlength="50" placeholder="Search for car i.e. 'Civic' 'Toyota'..">
					   	<div class="input-group-append">
						 	<button type="submit" class="btn btn-outline-dark">Search</button>
					   	</div>
				 	</div>
			 	</form>
	   		</div>
		</div>
	</div>
 	
 	<table class="table table-hover">
		<thead>
			<tr>
				<th class="text-center" scope="col" style="width: 10%">#</th>
				<th class="text-center" scope="col">Overview</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${inventory}" var="transaction" varStatus="loop">
				<tr>
					<th class="text-center" scope="row">${loop.count}</th>
					<td class="text-center">
						<a href="/inventory/details?transactionId=${transaction.id}"><img src="${transaction.imgPath}" alt="Car Image" style="width:500px"/></a><br>
						<a class="carData" href="/inventory/details?transactionId=${transaction.id}">${transaction.getOverview()}</a>
					</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>