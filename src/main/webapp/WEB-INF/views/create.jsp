<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
<%@ include file="partials/style-tags.jsp"%>
</head>
<body>
	<%@ include file="partials/header.jsp"%>


	<c:if test="${not empty mapMessage}">
		<p>${mapMessage}</p>
	</c:if>




	<%-- <c:if test="${empty candidates}">
<c:if test="${empty locations }">
	<div>
		<h4>Which City would You like to base your map in?</h4>
		<form method="post" action="/create">
			<select name="city">
				<option value="detroit">Detroit</option>
				<option value="chicago">Chicago</option>
				<option value="newYork">New York</option>
			</select>
			<input type="hidden" value="${userId}" name="userId"/>
			<button type="submit" class="btn btn-secondary">submit</button>
		</form>
		<h4>Or would you like to edit a map?</h4>
		<form method="post" action="/create">

	<%@ include file="partials/header.jsp"%> --%>



	<c:if test="${empty candidates}">
		<c:if test="${empty locations }">
			<div>
				<h4>Which City would You like to base your map in?</h4>
				<form method="post" action="/create">
					<select name="city">
						<option value="detroit">Detroit</option>
						<option value="chicago">Chicago</option>
						<option value="newYork">New York</option>
					</select> <input type="hidden" value="${userId}" name="userId" />
					<button type="submit" class="btn btn-secondary">submit</button>
				</form>
				<h4>Or would you like to edit a map?</h4>
				<form method="post" action="/create">
					<select name="mapId">
						<c:forEach var="map" items="${maps}">
							<option value="${map.id}">${map.name}</option>
						</c:forEach>
					</select> <input type="hidden" value="${userId}" name="userId" />

					<button type="submit" class="btn btn-secondary">submit</button>
				</form>
			</div>
		</c:if>
	</c:if>
	<c:if test="${not empty candidates}">
		<div>
			<form id="createform" method="post" action="/create">


				<ul>
					<li>Locations:</li>
					<c:forEach var="candidate" items="${candidates}">
						<li><label><input type="checkbox" name="locale"
								value="${candidate.place_id}">${candidate.name }
								${candidate.rating}</label></li>
					</c:forEach>

				</ul>
				<input type="text" value="name" name="name" /> <input type="hidden"
					value="${id}" name="mapId" /> <input type="hidden"
					value="${userId}" name="userId" />

			</form>
			<button onclick="runTest()" class="btn btn-secondary">submit</button>
		</div>



		<%-- 	</c:if>
	<c:if test="${not empty locations}">

		<form action="/play-map">
			<select name="mapId">
				<c:forEach items="${maps}" var="map">
					<option value="${map.id}">${map.name}</option>
				</c:forEach>
				
			</p>
			<!-- <input type="text" value="name" name="name"/> -->
			<input type="text" name="name"/>
			<input type="hidden" value="${mapId}" name="mapId"/>
			<input type="hidden" value="${userId}" name="userId"/>
			<button type="submit" class="btn btn-secondary">submit</button>
		</form>
	</div> --%>








	</c:if>
	<c:if test="${not empty locations}">

		<form action="/play-map">
			<select name="mapId">
				<c:forEach items="${maps}" var="map">
					<option value="${map.id}">${map.name}</option>
				</c:forEach>
			</select> <input type="hidden" value="${userId}" name="userId" />
			<button type="submit">Play Map</button>
		</form>


		<h3>My Map</h3>
		<!--The div element for the map -->
		<div id="map" style="height: 400px; width: 100%;"></div>
		<!-- Replace the value of the key parameter with your own API key. -->
	</c:if>
	<!-- <script>var locations = ${locations}</script> -->
	<%-- =======
			</select> <input type="hidden" value="${userId}" name="userId" />
			<button type="submit">Play Map</button>
		</form>


		<h3>My Map</h3>
		<!--The div element for the map -->
		<div id="map" style="height: 400px; width: 100%;"></div>
		<!-- Replace the value of the key parameter with your own API key. -->
	</c:if> --%>

	<script>
// checked.onclick = runTest();

function runTest() {
	if (document.querySelectorAll("input[type='checkbox']:checked").length >= 5){
		console.log(document.querySelectorAll("input[type='checkbox']:checked").length);
		document.getElementById("createform").submit(); 
	} else {
		window.alert("You will need at least 5 locations for the map to be beatable.");
	}
}


	
</script>





	<script>
	
	
var locations = (${locations});

	function initMap() {
	
  var rencen = locations[0];
 
  var map = new google.maps.Map(
	      document.getElementById('map'), {zoom: 15, center: rencen});
  
  for ( i = 0; i < (locations.length); i ++) { 

	  var location = {lat:locations[i].lat, lng: locations[i].lng};
	  var marker = new google.maps.Marker({position: location,
		  map: map,
		  title:locations[i].name});
  } 
}

</script>


	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDNgPo3oGDoG2aLV7bxJeNDZNbP5CXd_aI&callback=initMap">
</script>
	<%@ include file="partials/script-tags.jsp"%>
</body>
</html>