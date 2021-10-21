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

<title>Home</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
		  <span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		  <div class="navbar-nav">
			<a class="nav-item nav-link" href="/">Home</a>
			<a class="nav-item nav-link" href="/inventory">Inventory</a>
			<a class="nav-item nav-link active" href="/modifyInventory">Modify Inventory<span class="sr-only">(current)</span></a>
			<a class="nav-item nav-link" href="/allTransactions">Transactions</a>
		  </div>
		</div>
	</nav>
	
	<div class="container">
    	<div class="row justify-content-center">
      		<h5>Administrative Information</h5>
    	</div>
 	</div>
 	
 	<c:choose>
 		<c:when test="${entry.id > 0}">
 			<c:set var="url" value="edit"/>
 		</c:when>
 		<c:when test="${entry.id == 0}">
 			<c:set var="url" value="add"/>
 		</c:when>
 	</c:choose>
 	
 	<div class="container-fluid text-center">
 		<form:form method="POST" action="/modifyInventory/${url}" modelAttribute="entry">
		
		<div class="form-row">
          <div class="form-group col">
            <label for="transactionId">Transaction ID</label>
            <form:input type="text" class="form-control" id="transactionId" path="id" readOnly="true"/>
          </div>

          <div class="form-group col">
            <label for="inputAcquireDate">Acquire Date</label>
            <form:input type="date" class="form-control" id="inputAcquireDate" path="acquireDate"/>
          </div>
          
          <div class="form-group col-1">
			<label for="inputOwnership">Has car been sold?</label>
              <form:select id="inputOwnership" class="form-control" path="isSold">
                <option value="${entry.isSold}" selected>Select..</option>
                <option value="no">No</option>
                <option value="yes">Yes</option>
              </form:select>
			</div>

          <div class="form-group col">
            <label for="inputSoldDate">Sell Date</label>
            <form:input type="date" class="form-control" id="inputSoldDate" path="soldDate"/>
          </div>
        </div>
        
        <div class="row justify-content-center">
      		<h5>Vehicle Information</h5>
    	</div>
		
        <div class="form-row">
            <div class="form-group col-2">
              <label for="inputOwnership">Ownership</label>
              <form:select id="inputOwnership" class="form-control" path="ownership">
                <option value="${entry.ownership}" selected>Select..</option>
                <option value="New">New</option>
                <option value="Used">Used</option>
              </form:select>
            </div>

          <div class="form-group col-2">
            <label for="inputYear">Year</label>
            <form:input type="text" class="form-control" id="inputYear" path="year"/>
          </div>

          <div class="form-group col">
            <label for="inputPrice">Price</label>
            <form:input type="text" class="form-control" id="inputPrice" path="originalPrice"/>
          </div>

          <div class="form-group col">
            <label for="inputMileage">Mileage</label>
            <form:input type="text" class="form-control" id="inputMileage" path="mileage"/>
          </div>
        </div>

        <div class="form-row">
          <div class="form-group col-3">
            <label for="inputColor">Color</label>
            <form:input type="text" class="form-control" id="inputColor" path="color"/>
          </div>

          <div class="form-group col">
            <label for="inputMake">Make</label>
            <form:input type="text" class="form-control" id="inputMake" path="make"/>
          </div>

          <div class="form-group col">
            <label for="inpuModel">Model</label>
            <form:input type="text" class="form-control" id="inputModel" path="model"/>
          </div>
        </div>

        <div class="form-row">
          <div class="form-group col">
            <label for="inputDescription">Description</label>
            <form:textarea class="form-control" id="inputDescription" rows="3" path="description"></form:textarea>
          </div>
        </div>
        
        <div class="row justify-content-center">
			<h5>Buyer Information</h5>
	  	</div>
        
        <div class="form-row">
			<div class="form-group col">
				<label for="inputFirstName">First Name</label>
				<form:input type="text" class="form-control" id="inputFirstName" path="buyer.firstName"/>
			</div>

			<div class="form-group col">
				<label for="inputLastName">Last Name</label>
				<form:input type="text" class="form-control" id="inputLastName" path="buyer.lastName"/>
			</div>
		</div>
		
		<div class="form-row">
	        <div class="col text-center">
	        	<button type="submit" class="btn btn-primary">Submit</button>
	        </div>
	    </div>
        
      </form:form>
 	</div>

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