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
	<div>
		<h4>Which City would You like to base your map in?</h4>
		<form method="post" action="/create">
			<select name="city">
				<option value="detroit">Detroit</option>
				<option value="chicago">Chicago</option>
				<option value="newYork">New York</option>
			</select>
			<button type="submit" class="btn btn-secondary">submit</button>
		</form>
	</div>

	<div>
		<form method="post" action="/create">
			<p>
				Locations:
				<c:forEach var="candidate" items="${candidates}">
					<label><input type="checkbox" name="locale"
						value="${candidate.place_id}">${candidate.name }</label>
				</c:forEach>
				<button type="submit" class="btn btn-secondary">submit</button>
			</p>
		</form>
	</div>


	<h3>My Map</h3>
	<!--The div element for the map -->
	<div id="map" style=" height: 400px;width: 100%;"></div>
	<!-- Replace the value of the key parameter with your own API key. -->

	<!-- <script>var locations = ${locations}</script> -->





	<script>

var locations = (${locations});

function initMap() {

	
  var rencen = locations[0];
 
  var map = new google.maps.Map(
	      document.getElementById('map'), {zoom: 15, center: rencen});
  
  for ( i = 0; i < (locations.length); i ++) { 

	  var location = locations[i];
	  var marker = new google.maps.Marker({position: location,
		  map: map});
  } 
}

</script>

	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDNgPo3oGDoG2aLV7bxJeNDZNbP5CXd_aI&callback=initMap">
</script>

</body>
</html>