<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link href="${pageContext.request.contextPath}/static/css/main.css"	rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/script/jquery-2.1.4.min.js"></script>
	
	<script>
		console.trace("script");
		function onLoad() {
			$("#successIcon").hide();
			$("#errorIcon").hide();
			$("#password").keyup(checkPasswordsMatch);
			$("#confirmPassword").keyup(checkPasswordsMatch);
			$("details").submit(canSubmit);
		}
		
		function canSubmit() {
			var password = $("#password").val();
			var confirmPassword = $("#confirmPassword").val();
			if (password == confirmPassword) {
				return true;
			} else {
				alert("Passwords don't match.")
				return false;
			}
		}
		
		function checkPasswordsMatch() {
			var password = $("#password").val();
			var confirmPassword = $("#confirmPassword").val();
			if(password.length > 3 && confirmPassword.length > 3) {
				if (password == confirmPassword) {
					$("#matchPass").text("Passwords match.");
					$("#status").addClass("validAlert");
					$("#status").removeClass("errorAlert");
					$("#errorIcon").hide();
					$("#successIcon").show();
				} else {		
					$("#matchPass").text("Passwords don't match.");
					$("#status").addClass("errorAlert");
					$("#status").removeClass("validAlert");
					$("#successIcon").hide();
					$("#errorIcon").show();
				}
			}
		}
		$(document).ready(onLoad);
	</script>
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
			<td><sf:input class="control" path="password" name="password" id="password"
					type="password" /><br />
				<div class="error">
					<sf:errors path="password"></sf:errors>
				</div></td>
		</tr>
		<tr>
			<td class="label">Confirm password:</td>
			<td><input class="control" name="confirmPassword" type="password" id="confirmPassword" />
			<div id="status">
				<span id="successIcon" ><img src="${pageContext.request.contextPath}/static/images/accept.png"></span>
				<span id="errorIcon" ><img src="${pageContext.request.contextPath}/static/images/exclamation.png"></span>
				<span id="matchPass"></span>
			</div></td>
		</tr>
		<tr>
			<td><input name="submit" type="submit" /></td>
		</tr>
	</sf:form>
</body>
</html>