<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Map</title>
	<%@ include file="partials/style-tags.jsp"%>
</head>
<body>
	<%@ include file="partials/header.jsp"%>


	<h3>Select a destination to travel to:</h3>
	<c:if test="${boss.equals('Boss')}">
	
		<a href="/jeopardy"><button>Boss</button></a>
	</c:if>
	<!--The div element for the map -->
	<div id="map" style="height: 400px; width: 100%;"></div>
	<!-- Replace the value of the key parameter with your own API key. -->

	<!-- <script>var locations = ${locations}</script> -->





	<script>

// var locations = (${locations});
var results = (${results});
var mid = (${mid});

function initMap() {

	
  var rencen = results[0];
 
  var map = new google.maps.Map(
	      document.getElementById('map'), {zoom: 14, center: rencen});
  
  var result;
  
  for (result of results) { 
	  
	  	
	  var location = {lat: result.lat, lng: result.lng};
	  var marker = new google.maps.Marker({position: location,
		  map: map,
		  label: {
			    text: result.name + " Rating: " + result.rating,
			    color: "#black",
			    fontSize: "12px",
			    fontWeight: "bold"
			  }, 
		  icon: {
			    path: google.maps.SymbolPath.CIRCLE,
			    fillColor: "red",
			    strokeColor: "skyblue",
			    fillOpacity: .5,
			    scale: 10
			  },
		  title: result.place_id});
	  marker.addListener('click', function() {
		  window.location.assign('/jeopardy?placeId='+this.getTitle()+"&mapId="+mid);
		  
        });

	  
  } 
}

</script>

	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDNgPo3oGDoG2aLV7bxJeNDZNbP5CXd_aI&callback=initMap">
</script>

</body>
</html>