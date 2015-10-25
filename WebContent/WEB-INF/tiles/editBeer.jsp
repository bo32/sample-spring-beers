<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="withMargins">
	<sf:form method="post"
		action="${pageContext.request.contextPath}/doEditBeer/${beer.id}"
		commandName="beer">

		<fieldset>
			<legend>Edit beer</legend>

			<label>Name: <sf:input type="text" name="name" path="name" />
			</label> 
			<label>Origin: <sf:input type="text" name="origin" path="origin" />
			</label> 
			<input class="button small radius" value="Update" type="submit" />
		</fieldset>
	</sf:form>
</div>
