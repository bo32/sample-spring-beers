<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="withMargins"> 
	<ul class="tabs" data-tab>
 		<li class="tab-title light-border-without-right active"><a href="#usersPanel"><img	src="${pageContext.request.contextPath}/static/images/users.png" /></a></li>
 		<li class="tab-title light-border"><a href="#databasePanel"><img	src="${pageContext.request.contextPath}/static/images/database.png" /></a></li>
 	</ul>
	
	<div class="tabs-content">
		<div class="content active" id="usersPanel">
			<tiles:insertAttribute name="users"></tiles:insertAttribute>
		</div>
		<div class="content" id="databasePanel">
			<tiles:insertAttribute name="database"></tiles:insertAttribute>
		</div>
	</div>
</div>

<script>
	function switchContent(whichContent){
    	$('#usersPanel').children().remove();
     	$('#usersPanel').load("/pathToYourApp/bodySwitcher.do?method=");
	}
</script>