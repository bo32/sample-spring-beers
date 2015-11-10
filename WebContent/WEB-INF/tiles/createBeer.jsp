<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="withMargins">
	<sf:form method="post" 
		action="${pageContext.request.contextPath}/doCreateBeer?${_csrf.parameterName}=${_csrf.token}" 
		commandName="beer"
		enctype="multipart/form-data">
		
		<fieldset>
			<legend>Create beer</legend>

			<label>Name: 
				<sf:input type="text" name="name" path="name" />
				<sf:errors path="name" class="error"></sf:errors>
			</label>
			<label>Origin: 
				<sf:input type="text" name="origin"	path="origin" /> 
				<sf:errors path="origin" class="error"></sf:errors>
			</label>
			<label>Description: 
				<sf:textarea type="text" name="description"	path="description" /> 
				<sf:errors path="description" class="error"></sf:errors>
			</label>
			<label>Picture:
		        <sf:input type="file" path="picture" name="picture" />
		        <!-- <input type="submit" value="upload" /> -->
		        <sf:errors path="picture" cssStyle="color: #ff0000;" />
	        </label>
			<br /> 
			<input class="button small radius" value="Create" type="submit" />
		</fieldset>
	</sf:form>
</div>