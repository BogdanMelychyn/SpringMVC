<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

	<div style="padding:30px;" class ="text-table">
		<div class="col-lg-4">
          <h3>New Car for Driver</h3>
         </div>
		<form action="newCar" style="width: 300px" method="POST">
		
			<div class="form-group">
				<label for="exampleInputEmail1">Car brand</label> 
				<input type="text" class="form-control" id="exampleInputEmail1" name="carBrend" placeholder="Enter Brend">
				<label for="exampleInputEmail1">Car number</label> 
				<input type="text" class="form-control" id="exampleInputEmail2" name="carN" placeholder="Enter number">
				</div>
		<br>
			
		<div class="form-group" >
		<label>Select Driver</label>
			<select class="form-control" name="driverId">
				<jstl:forEach items="${drivers}" var="driver">
					<option value="${driver.getId()}">${driver.getName()}</option>
				</jstl:forEach>
			</select>
			</div>
			<button type="submit" class="btn btn-default">Save</button>
		</form>
		
		<br>
	
	</div>

