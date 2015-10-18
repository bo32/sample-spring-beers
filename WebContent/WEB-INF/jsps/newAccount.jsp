<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/static/css/main.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<h3>Create a new account</h3>
	<sf:form method="POST"
		action="${pageContext.request.contextPath}/createAccount"
		commandName="user" class="formtable">
		<tr>
			<td>Username:</td>
			<td><sf:input class="control" path="username" name="username"
					type="text" /><br />
				<div class="error">
					<sf:errors path="username"></sf:errors>
				</div></td>
		</tr>

		<tr>
			<td>Email:</td>
			<td><sf:input class="control" path="email" name="email"
					type="text" /><br />
				<div class="error">
					<sf:errors path="email"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><sf:input class="control" path="password" name="password"
					type="password" /><br />
				<div class="error">
					<sf:errors path="password"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Confirm password:</td>
			<td><input class="control" name="confirmpassword" type="password" /></td>
		</tr>
		<tr>
			<td><input name="submit" type="submit" /></td>
		</tr>
	</sf:form>
</body>
</html>