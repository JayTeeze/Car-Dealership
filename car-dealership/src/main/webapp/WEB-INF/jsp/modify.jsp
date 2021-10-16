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

<title>Modify Inventory</title>
</head>
<body>

	<ul class="nav justify-content-center">
  		<li class="nav-item">
    		<a class="nav-link active" href="/">Home</a>
  		</li>
  		<li class="nav-item">
    		<a class="nav-link" href="/inventory">Inventory</a>
  		</li>
  		<li class="nav-item">
    		<a class="nav-link" href="/modifyInventory">Modify Inventory</a>
  		</li>
  		<li class="nav-item">
    		<a class="nav-link" href="#">Transactions</a>
  		</li>
	</ul>
	
	<div class="container">
    	<div class="row justify-content-center">
      		<h3>Admin Options</h3>
    	</div>
 	</div>
 	
 	<table class="table table-hover">
		<thead>
			<tr>
				<th class="text-center" scope="col" style="width: 10%">#</th>
				<th class="text-center" scope="col">Overview</th>
				<th class="text-center" scope="col" style="white-space: nowrap; width: 1%"></th>
			</tr>
		</thead>
		<tbody>
		
			
			<c:forEach items="${inventory}" var="transaction" varStatus="loop">
				<tr>
					<th class="text-center" scope="row">${loop.count}</th>
					<td class="text-center">${transaction.car.getOverview()}</td>
					<td>
					<div class="btn-group" role="group">
						<a class="btn btn-outline-primary btn-sm" href="/modifyInventory/edit?transactionId=${transaction.id}">Edit</a>
						<a class="btn btn-outline-danger btn-sm" href="/modifyInventory/delete?transactionId=${transaction.id}">Delete</a>
		              	
		            </div>
		            </td>
		        </tr>
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