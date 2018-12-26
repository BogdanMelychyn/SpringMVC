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
					<th>Name</th>
					<th>Age</th>
					<th>e-mail</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${driver.getName()}</td>
					<td>${driver.getAge()}</td>
					<td>${driver.getEmail()}</td>
				</tr>
			</tbody>
		</table>
	<div style="padding: 30px;">
		<h2>Edit Driver</h2>
		<form role="form" style="width: 300px" action="driver_update" method="POST">
			<div class="form-group">
				<label for="email">Name:</label> <input type="text" name="name"
					class="form-control" id="name">
			</div>
			<div class="form-group">
				<label for="email">e-mail:</label> <input type="email" name="eMail"
					class="form-control" id="eMail">
			</div>
			<div class="form-group">
				<label for="pwd">Age:</label> <input type="number" name="age"
					class="form-control" id="age">
			</div>
			 <input type="hidden" name="id"	value="${driver.getId()}" />
			<button type="submit" class="btn btn-default">Save</button>
		</form>
	</div>
</div>
</body>