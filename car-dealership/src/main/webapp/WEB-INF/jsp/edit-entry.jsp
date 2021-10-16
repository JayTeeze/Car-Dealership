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
      		<h5>Transaction ID # ${entry.id}</h5>
    	</div>
 	</div>
 	
 	<div class="container-fluid text-center">
 		<form:form method="POST" action="/modifyInventory/edit" modelAttribute="entry">

        <div class="form-row">
            <div class="form-group col-2">
              <label for="inputOwnership">Ownership</label>
              <form:select id="inputOwnership" class="form-control" path="car.ownership">
                <option selected>Select..</option>
                <option value="New">New</option>
                <option value="Used">Used</option>
              </form:select>
            </div>

          <div class="form-group col-2">
            <label for="inputYear">Year</label>
            <form:input type="text" class="form-control" id="inputYear" path="car.year"/>
          </div>

          <div class="form-group col">
            <label for="inputPrice">Price</label>
            <form:input type="text" class="form-control" id="inputPrice" path="car.price"/>
          </div>

          <div class="form-group col">
            <label for="inputMileage">Mileage</label>
            <form:input type="text" class="form-control" id="inputMileage" path="car.mileage"/>
          </div>
        </div>

        <div class="form-row">
          <div class="form-group col-3">
            <label for="inputColor">Color</label>
            <form:input type="text" class="form-control" id="inputColor" path="car.color"/>
          </div>

          <div class="form-group col">
            <label for="inputMake">Make</label>
            <form:input type="text" class="form-control" id="inputMake" path="car.make"/>
          </div>

          <div class="form-group col">
            <label for="inpuModel">Model</label>
            <form:input type="text" class="form-control" id="inputModel" path="car.model"/>
          </div>
        </div>

        <div class="form-row">
          <div class="form-group col">
            <label for="inputDescription">Description</label>
            <form:textarea class="form-control" id="inputDescription" rows="3" path="car.description"></form:textarea>
          </div>
        </div>
		
		<div class="form-row">
	        <div class="col text-center">
	        	<button type="submit" class="btn btn-primary">Update</button>
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