<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html lang="en">

<body>

	<div class="text-table">
		<table class="table" style="max-width: 50%">
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>e-mail</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${ainf.getName()}</td>
					<td>${ainf.getAge()}</td>
					<td>${ainf.getEmail()}</td>
					<td><sec:authorize access="hasRole('ROLE_ADMIN')">
						<a class="btn btn-primary" href="edit_driver?id=${ainf.getId()}"
							role="button">Edit &raquo;</a>
					</sec:authorize></td>
				</tr>
			</tbody>
		</table>
		<h3>List of Cars</h3>
		<table class="table" style="max-width: 50%">
			<thead>
				<tr>
					<th>Car brand</th>
					<th>Car number</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${cars}" var="car">
					<tr>
						<td>${car.carBrand}</td>
						<td>${car.carNumber}</td>
						<td>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
						<a class="btn btn-primary" href="edit_car?carId=${car.getCarId()}"
							role="button">Edit &raquo;</a>
							
					</sec:authorize>
					</td>
					</tr>
				</jstl:forEach>
			</tbody>
		</table>
	</div>

</body>