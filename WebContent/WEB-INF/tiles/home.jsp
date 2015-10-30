<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


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
	
	<p>
		<a href="${pageContext.request.contextPath}/beers">See all beers.</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/createBeer">Add a new beer.</a>
	</p>
</div>

