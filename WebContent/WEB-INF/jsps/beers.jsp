<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="resourcesCtx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="${pageContext.request.contextPath}/static/css/main.css"	rel="stylesheet" type="text/css" />
	<link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--<c:if test="${not empty message}">
		<div class="validAlert">${message}</div>
	</c:if>-->
	<c:if test="${not empty message}">
		<div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			${message}
		</div>
	</c:if>
	<p>Here are the different beers we have:</p>

	<table class="beerTable">

		<tr>
			<th>Name</th>
			<th>Origin</th>
			<th></th>
		</tr>
		<c:forEach var="beer" items="${beers}">
			<tr>
				<td>${beer.name}</td>
				<td>${beer.origin}</td>
				<td align="center">
					<a href="${pageContext.request.contextPath}/showBeer/${beer.id}"><img
						src="${pageContext.request.contextPath}/static/images/magnificent.png" /></a>
					<a href="${pageContext.request.contextPath}/editBeer/${beer.id}"><img
						src="${pageContext.request.contextPath}/static/images/edit.png" /></a>
					<a href="${pageContext.request.contextPath}/doDeleteBeer/${beer.id}"><img
						src="${pageContext.request.contextPath}/static/images/delete.png" /></a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<p>
		<a href="${pageContext.request.contextPath}/createBeer">Create a
			beer.</a>
	</p>


	<script type="text/javascript"
		src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
</body>
</html>