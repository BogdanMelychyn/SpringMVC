<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<body>
	<div style="padding: 30px;" class ="text-table">
		<h2>Create New Driver</h2>
		<form role="form" style="width: 300px" action="newD" method="POST">
			<div class="form-group">
				<label for="email">Name:</label> <input type="text" name="name"
					class="form-control" id="name" placeholder="Enter Name">
			</div>
			<div class="form-group">
				<label for="email">e-mail:</label> <input type="email" name="eMail"
					class="form-control" id="eMail" placeholder="Enter e-mail">
			</div>
			<div class="form-group">
				<label for="pwd">Age:</label> <input type="number" name="age"
					class="form-control" id="age" placeholder="Enter age">
			</div>
			<button type="submit" class="btn btn-default">Save</button>
		</form>
	</div>

</body>