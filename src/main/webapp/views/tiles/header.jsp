<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
			<a class="navbar-brand" href="#">Garage</a>

		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<sec:authorize access="isAuthenticated()">
				<div class="navbar-form navbar-right">
					<a class="btn btn-success" href="<jstl:url value='logout' />">Logout</a>
				</div>
			</sec:authorize>
			<ul class="nav navbar-nav">
				<li class="active"><a href="main">Main Page</a></li>
				<li><a href="showAll">Drivers</a></li>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="createDriver">Add Driver</a></li>
					<li><a href="newCarForm">Add Car</a></li>
					
				</sec:authorize>






				<li><a href="#contact">Contact</a></li>
			</ul>

		</div>
		<!--/.nav-collapse -->
	</div>
</nav>