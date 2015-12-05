<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/main.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/collapse.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/buttons.css" />

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/foundation/css/foundation.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/foundation/css/foundation.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/foundation/css/normalize.css" />

	<script src="${pageContext.request.contextPath}/static/foundation/js/vendor/jquery.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/foundation/js/foundation.min.js"></script>
</head>
<body>
	<div>
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<div>
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
	</div>
	<div>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
</body>


<script type="text/javascript">
	jQuery(function($) {
		$(document).foundation();
	});
</script>
</html>