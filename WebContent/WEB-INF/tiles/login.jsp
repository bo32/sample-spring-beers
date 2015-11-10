<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<body onload='document.f.j_username.focus();'>

	<c:if test="${param.login_error != null}">
		<p class="error">Login failed. Check that your username and
			password are correct.</p>

	</c:if>

	<div class="withMargins">
		<form name="f"
			action="${pageContext.request.contextPath}/j_spring_security_check"
			method="POST">
			<fieldset class="withSideMargins">
				<legend>Login with Username and Password</legend>
				<label>User: <input type="text" name="j_username" value="">
				</label> <label> Password: <input type="password" name="j_password" />
				</label> <input class="button small radius" name="submit" type="submit"
					value="Login" />
			</fieldset>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

		<p>
			<a href="<c:url value="/newAccount"/>">Create new account</a>
		</p>
	</div>
</body>