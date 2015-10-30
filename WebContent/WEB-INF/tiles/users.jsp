<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:set var="resourcesCtx" value="${pageContext.request.contextPath}" />

	<table>
		<tr>
			<th>Name</th>
			<th>Role</th>
			<th>Enabled</th>
			<th>Option</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.username}</td>
				<td>${user.authority}</td>
				<td>${user.enabled}</td>
				<td><span>Reset password</span></td>
			</tr>
		</c:forEach>
	</table>

