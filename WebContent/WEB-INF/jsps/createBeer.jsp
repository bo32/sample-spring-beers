<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css"	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Create a new beer:
	<sf:form method="post"
		action="${pageContext.request.contextPath}/doCreateBeer"
		commandName="beer">
		<table>
			<tr>
				<td class="label">Name:</td>
				<td class="control"><sf:input name="name" type="text"
						path="name" /><br />
				<sf:errors path="name" cssClass="error"></sf:errors>
				</td>
			</tr>
			<tr>
				<td class="label">Origin:</td>
				<td class="control"><sf:input name="origin" type="text"
						path="origin" /><br />
				<sf:errors path="origin" cssClass="error"></sf:errors>
				</td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Create Beer" type="submit" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>