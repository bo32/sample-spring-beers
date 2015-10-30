<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<nav class="top-bar" data-topbar role="navigation">
	<ul class="title-area">
		<li class="name">
			<h1>
				<a href="${pageContext.request.contextPath}"><span><img
						src="${pageContext.request.contextPath}/static/images/beer.png"</span><span>Spring
						Beers</span></a>
			</h1>
		</li>
		<!-- Remove the class "menu-icon" to get rid of menu icon. Take out "Menu" to just have icon alone -->
		<li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
	</ul>

	<section class="top-bar-section">
		<!-- Right Nav Section -->
		<ul class="right">
			<!-- <li class="active"><a href="#">Right Button Active</a></li> -->
			
			<sec:authorize access="!isAuthenticated()">
				<li><a href="${pageContext.request.contextPath}/login"><span><img
						src="${pageContext.request.contextPath}/static/images/user.png" /></span><span>Login</span></a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<li class="has-dropdown"><a href="#"><span><img
						src="${pageContext.request.contextPath}/static/images/cog.png" /></span><span>Settings</span></a>
				<ul class="dropdown">
					<li><a href="#">First link in dropdown</a></li>
					<li class="active"><a href="#">Active link in dropdown</a></li>
				</ul></li>
			</sec:authorize>				
			<sec:authorize access="hasAuthority('admin')">
				<li><a href="${pageContext.request.contextPath}/admin"><span><img
						src="${pageContext.request.contextPath}/static/images/darth-vader.png" /></span><span>Admin</span></a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
			<!-- <li><a href="<c:url value='/j_spring_security_logout'/>"><span><img
						src="${pageContext.request.contextPath}/static/images/logout.png" /></span><span>Logout</span></a></li> -->
				<li>
					<!--<c:url var="logoutUrl" value="/logout"/>
					<form action="${logoutUrl}" id="logout" method="post">
						 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>
					<a href="#" onclick="document.getElementById('logout').submit();">
						<span><img src="${pageContext.request.contextPath}/static/images/logout.png" /></span>
						<span>Logout</span>
					</a>-->
					<a href="<c:url value="/logout" />">
						<span><img src="${pageContext.request.contextPath}/static/images/logout.png" /></span>
						<span>Logout</span>
					</a>
				</li>
			</sec:authorize>
		</ul>

		<!-- Left Nav Section -->
		<!-- <ul class="left">
      <li><a href="#">Left Nav Button</a></li>
    </ul> -->
	</section>
</nav>