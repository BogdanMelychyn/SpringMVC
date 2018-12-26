<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<body>
	<div class="text-table">
		<table class="table" style="max-width: 50%">
			<thead>
				<tr>
					<th>Car brand</th>
					<th>Car number</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${car.carBrand}</td>
					<td>${car.carNumber}</td>

				</tr>
			</tbody>
		</table>
	</div>
	<div style="padding: 30px;" class="text-table">
		<div class="col-lg-4">
			<h3>Edit Car</h3>
		</div>
		<form action="update_car" style="width: 300px" method="POST">

			<div class="form-group">
				<label for="exampleInputEmail1">Car brand</label> 
				<input type="text"	class="form-control" id="exampleInputEmail1" name="carBrend"
					placeholder="Enter Brend"> 
					<label for="exampleInputEmail1">Car	number</label> 
					<input type="text" class="form-control"	id="exampleInputEmail2" name="carN" placeholder="Enter number">
			</div>
			<input type="hidden" name="carId" value="${car.carId}" />
			<button type="submit" class="btn btn-default">Save</button>
		</form>
	</div>


</body>