<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="resourcesCtx" value="${pageContext.request.contextPath}" />

<div class="withMargins">
	<c:if test="${not empty message}">
		<div class="alert-box ${css} radius" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			${message}
		</div>
	</c:if>
	<p>Here are the different beers we have:</p>

	<table>
		<!-- class="beerTable" -->

		<tr>
			<th>Name</th>
			<th>Origin</th>
			<th width="100px"></th>
		</tr>
		<c:forEach var="beer" items="${beers}">
			<tr>
				<td>${beer.name}</td>
				<td>${beer.origin}</td>
				<td><a
					href="${pageContext.request.contextPath}/showBeer/${beer.id}"><img
						src="${pageContext.request.contextPath}/static/images/magnificent.png" /></a>
					<a href="${pageContext.request.contextPath}/editBeer/${beer.id}"><img
						src="${pageContext.request.contextPath}/static/images/edit.png" /></a>
					<a
					href="${pageContext.request.contextPath}/doDeleteBeer/${beer.id}"><img
						src="${pageContext.request.contextPath}/static/images/delete.png" /></a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<p>
		<a href="${pageContext.request.contextPath}/createBeer"><button class="button button-primary button-circle button-tiny"><i class="fa fa-plus"></i></button><span>Create a
			beer.</span></a>
		<a href="#" class="button button-primary button-rounded button-small">Create beer</a>
		<a href="#" class="button button-primary button-rounded button-small">Back</a>
	</p>
</div>
