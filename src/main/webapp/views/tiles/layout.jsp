<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title" /></title>
<link
	href='<jstl:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css" />'
	rel="stylesheet">
<link
	href='<jstl:url value="/resources/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css" />'
	rel="stylesheet">
	<link
	href='<jstl:url value="/resources/bootstrap-3.3.5-dist/css/footer.css" />'
	rel="stylesheet">
	<link
	href='<jstl:url value="/resources/bootstrap-3.3.5-dist/css/head.css" />'
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src='<jstl:url value="/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js" />'></script>
</head>

<body style = "background-image: url(resources/img/black-hd-background.jpg)">
	<div class="conteiner">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<div>
		<tiles:insertAttribute name="body"></tiles:insertAttribute>
	</div>
	<div>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>

</body>
</html>