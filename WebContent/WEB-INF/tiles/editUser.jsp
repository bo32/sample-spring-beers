<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="withMargins">
	<sf:form method="post"
		action="${pageContext.request.contextPath}/doEditUser/${user.username}"
		commandName="user">

		<fieldset>
			<legend>Edit user</legend>

			<label>Name: <sf:input type="text" name="username" path="username" />
			</label> 
			<label>Password: <sf:input type="text" name="password" path="password" />
			</label> 
			<label>Role: <sf:input type="text" name="authority" path="authority" />
			</label>
			<input class="button small radius" value="Update" type="submit" />
		</fieldset>
	</sf:form>
</div>
