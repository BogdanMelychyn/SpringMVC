<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html lang="en">

<body>
	<div class="text-table">
		<h2>List of Drivers</h2>
		<p>* for more information click by name
		<p>
		<table class="table" style="max-width: 40%">
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<jstl:forEach items="${drivers}" var="driver">
					<tr>
						<td><a href="dInfo?id=${driver.id}">${driver.name}</a></td>
						<td>${driver.age}</td>
					</tr>
				</jstl:forEach>
			</tbody>
		</table>
	</div>
	<%-- <sec:authorize access="hasRole('ROLE_ADMIN')">
	<div class="col-lg-4">
		<h3 class="text-table">New Car for Driver</h3>
		<p>
			<a class="btn btn-primary" href="newCarForm" role="button">Add
				car &raquo;</a>
		</p>
	</div>
</sec:authorize> --%>

</body>