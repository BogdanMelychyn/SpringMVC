<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Garage</title>
<link
	href='<jstl:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" />'
	rel="stylesheet">
<link
	href='<jstl:url value="/resources/bootstrap-3.3.5-dist/css/carousel.css" />'
	rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src='<jstl:url value="/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js" />'></script>
<script
	src='<jstl:url value="/resources/bootstrap-3.3.5-dist/js/ie10.js" />'></script>
</head>
<body
	style="background-image: url(resources/img/black-hd-background.jpg)">
	<div class="navbar-wrapper">
		<div class="container">
			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> 
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span> 
						</button>
						<a class="navbar-brand" href="#">Garage</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">

							<sec:authorize access="isAuthenticated()">
								<li class="active"><a href="showAll">List Drivers</a></li>
							</sec:authorize>
							<li><a href="#contact">Contact</a></li>
						</ul>
						<!-- Login err -->
						<div style = "color: red" class="navbar-form navbar-right">
						<jstl:out value="${err}"/>
						</div>
						<!-- /. Login err -->
						
						<!-- Login form -->
						<sec:authorize access="isAuthenticated()">
							<div class="navbar-form navbar-right">
								<a class="btn btn-success" href="<jstl:url value='logout' />">Logout</a>
							</div>
						</sec:authorize>
						<sec:authorize access="!isAuthenticated()">
							<form class="navbar-form navbar-right"
								action="<jstl:url value='j_spring_security_check' />"
								method="POST">
																
								<div class="form-group">
									<input type="text" name="username" placeholder="Your Login"
										class="form-control">
								</div>
								<div class="form-group">
									<input type="password" name="password" placeholder="Password"
										class="form-control">
								</div>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
								<button type="submit" class="btn btn-success">Sign in</button>
							</form>
						</sec:authorize>
						<!-- /. Login form -->
					</div>
				</div>
			</nav>
		</div>
	</div>
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide" src="resources/img/slide/1.jpg"
					alt="First slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Chevrolet Camaro 5</h1>
											
					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide" src="resources/img/slide/2.jpg"
					alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Ford GT Concept</h1>
						
					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide" src="resources/img/slide/3.jpg"
					alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Ford Mustang GT red tuning</h1>
						
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- /.carousel -->

	<!-- FOOTER -->
	<footer
		style="position: absolute; bottom: 0; width: 100%; height: 60px">
		

		<p>	&copy; 2015 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a
				href="#">Terms</a>
		</p>
	</footer>

</body>
</html>