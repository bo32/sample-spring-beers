<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="top-bar" data-topbar role="navigation">
  <ul class="title-area">
    <li class="name">
      <h1><a href="${pageContext.request.contextPath}"><span><img src="${pageContext.request.contextPath}/static/images/beer_32.png"</span><span>Spring Beers</span></a></h1>
    </li>
     <!-- Remove the class "menu-icon" to get rid of menu icon. Take out "Menu" to just have icon alone -->
    <li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
  </ul>

  <section class="top-bar-section">
    <!-- Right Nav Section -->
    <ul class="right">
      <!-- <li class="active"><a href="#">Right Button Active</a></li> -->
      <li ><a href="${pageContext.request.contextPath}/login"><span><img src="${pageContext.request.contextPath}/static/images/user.png"/></span><span>Login</span></a></li>
      
      <li class="has-dropdown">
        <a href="#" ><span><img src="${pageContext.request.contextPath}/static/images/cog.png"/></span><span>Settings</span></a>
        <ul class="dropdown">
          <li><a href="#">First link in dropdown</a></li>
          <li class="active"><a href="#">Active link in dropdown</a></li>
        </ul>
      </li>
    </ul>

    <!-- Left Nav Section -->
    <!-- <ul class="left">
      <li><a href="#">Left Nav Button</a></li>
    </ul> -->
  </section>
</nav>