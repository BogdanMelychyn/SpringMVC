<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

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
	href='<jstl:url value="/resources/bootstrap-3.3.5-dist/css/cover.css" />'
	rel="stylesheet">
       
    <link
	href='<jstl:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css" />'
	rel="stylesheet">
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src='<jstl:url value="/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js" />'></script>
    <script
	src='<jstl:url value="/resources/bootstrap-3.3.5-dist/js/ie10.js" />'></script>
	
     </head>
  <body>
    <div class="site-wrapper">
      <div class="site-wrapper-inner">
        <div class="cover-container">
          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">Garage</h3>
              <nav>
                <ul class="nav masthead-nav">
                  <li class="active"><a href="showAll">Show Drivers</a></li>
                  <li><a href="createDriver">Add Driver</a></li>
                  <li><a href="#">Contact</a></li>
                </ul>
              </nav>
            </div>
          </div>
          <div class="inner cover">
            <h1 class="cover-heading">Cover your page.</h1>
            <p class="lead">Cover is a one-page template for building simple and beautiful home pages. Download, edit the text, and add your own fullscreen background photo to make it your own.</p>
            <p class="lead">
              <a href="#" class="btn btn-lg btn-default">Learn more</a>
            </p>
          </div>
          <div class="mastfoot">
            <div class="inner">
              <p>Author</p>
            </div>
          </div>
        </div>
      </div>
    </div>
</body>
</html>