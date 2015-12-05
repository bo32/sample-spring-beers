<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<style>
  	#map {
    	width: 500px;
    	height: 400px;
    	border: 1px #ebebeb solid;
	}
</style>
    
<script src="https://maps.googleapis.com/maps/api/js"></script>
<script>
	var geocoder;
	var map;
	var myLocation;
	
	function initialize(loc) {
		location = loc;
		geocoder = new google.maps.Geocoder();
	  	var mapCanvas = document.getElementById('map');
	  	var position = new google.maps.LatLng(45, -78.5463)
	  	var mapOptions = {
	    	center: position,
	    	zoom: 8,
	    	mapTypeId: google.maps.MapTypeId.ROADMAP
		}
		map = new google.maps.Map(mapCanvas, mapOptions);
	}

  	function codeAddress() {
  	    geocoder.geocode( { 'address': myLocation}, function(results, status) {
  	      if (status == google.maps.GeocoderStatus.OK) {
  	        map.setCenter(results[0].geometry.location);
  	        var marker = new google.maps.Marker({
  	            map: map,
  	            position: results[0].geometry.location
  	        });
  	      } else {
  	        alert("Geocode was not successful for the following reason: " + status);
  	      }
  	    });
  	  }
	//google.maps.event.addDomListener(window, 'load', initialize);
</script>


<div class="withMargins">
	<h2 class="subheader">${beer.name}
		<span> <c:forEach var="i" begin="1" end="${beer.rating}">
				<img src="${pageContext.request.contextPath}/static/images/star.png" />
			</c:forEach> <c:forEach var="i" begin="1" end="${5 - beer.rating}">
				<img
					src="${pageContext.request.contextPath}/static/images/star_gray.png" />
			</c:forEach>
		</span>
	</h2>
	<label class="collapse" for="_1" onclick="initialize('${beer.origin}')"> <img
		src="${pageContext.request.contextPath}/static/images/map_magnify.png" />
		<span>from ${beer.origin}.</span>
	</label>
	<input id="_1" type="checkbox">
	<div id="map"></div>
	<!-- TODO https://developers.google.com/places/javascript/ -->
	<p>Description:</p>
	<p>${beer.description}</p>
	<p>${image}</p>
	<!-- <p><img src="image.jsp?imgID=${beer.id}"/></p> -->
	<p>
		<img src="showBeerPicture/${beer.id}" />
	</p>
	<!-- <p>${pageContext.request.contextPath}/showBeerPicture/${beer.id}</p>-->
	<p>Each image needs to be a separate request to a separate URL. So
		you will need a controller/servlet that accepts the user id as
		parameter and writes the blob to the response stream (and sets the
		Content-Type header appropriately - image/jpeg, image/png, etc)</p>
</div>
