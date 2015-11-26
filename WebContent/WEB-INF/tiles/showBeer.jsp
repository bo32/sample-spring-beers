<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="withMargins">
	<h2 class="subheader">${beer.name}
	<span>
		<c:forEach var="i" begin="1" end="${beer.rating}">
	   		<img src="${pageContext.request.contextPath}/static/images/star.png"/>
		</c:forEach>
		<c:forEach var="i" begin="1" end="${5 - beer.rating}">
	   		<img src="${pageContext.request.contextPath}/static/images/star_gray.png"/>
		</c:forEach>
	</span></h2>
	<div><span><a href=""><img src="${pageContext.request.contextPath}/static/images/map_magnify.png"/></a></span><span>from ${beer.origin}.</span></div>
	<!-- TODO https://developers.google.com/places/javascript/ -->
	<p>Description: </p>
	<p>${beer.description}</p>
	<p>${image}</p>
	<!-- <p><img src="image.jsp?imgID=${beer.id}"/></p> -->
	<p><img src="showBeerPicture/${beer.id}" /></p>
	<!-- <p>${pageContext.request.contextPath}/showBeerPicture/${beer.id}</p>-->
	<p>Each image needs to be a separate request to a separate URL. So you will need a controller/servlet that accepts the user id as parameter
	 and writes the blob to the response stream (and sets the Content-Type header appropriately - image/jpeg, image/png, etc)</p>
</div>