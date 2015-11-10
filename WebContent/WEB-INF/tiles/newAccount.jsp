<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery-2.1.4.min.js"></script>

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
		if (password.length > 3 && confirmPassword.length > 3) {
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

<div class="withMargins">

	<sf:form method="POST"
		action="${pageContext.request.contextPath}/createAccount"
		commandName="user" class="formtable">

		<fieldset>
			<legend>Create account</legend>
			<label>Username: <sf:input class="control" path="username"
					name="username" type="text" /> <sf:errors class="error"
					path="username"></sf:errors>
			</label> <label>Email:<sf:input class="control" path="email"
					name="email" type="text" /> <sf:errors path="email" class="error"></sf:errors>
			</label> <label>Password: <sf:input class="control" path="password"
					name="password" id="password" type="password" /> <sf:errors
					path="password" class="error"></sf:errors>
			</label> <label>Confirm password:<input class="control"
				name="confirmPassword" type="password" id="confirmPassword" /></label> <label
				id="status"> <span id="successIcon"><img
					src="${pageContext.request.contextPath}/static/images/accept.png"></span>
				<span id="errorIcon"><img
					src="${pageContext.request.contextPath}/static/images/exclamation.png"></span>
				<span id="matchPass"></span>
			</label><input name="submit" class="button small radius" type="submit" />
		</fieldset>
	</sf:form>
</div>