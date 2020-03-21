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


	<h3>Select a destination to conquer:</h3>
	<c:if test="${boss.equals('Boss')}">

		<a href="/jeopardy"><button>Boss Battle</button></a>

	</c:if>
	<!--The div element for the map -->
	<div id="map" style="height: 400px; width: 100%;"></div>
	<!-- Replace the value of the key parameter with your own API key. -->

	<!-- <script>var locations = ${locations}</script> -->
	<table>
		<th>
			<tr><h4>Name: || Level:</h4></tr>
		</th>
		<ul>
			<li><h6>Areas Conquered: ${ winCount }/3</h6></li>
			<li><h6>Energy:</h6></li>
			<li><h6>Items in Bag:</h6></li>
		</ul>

		<h4>Your Quest:</h4>
	</table>
	<c:set var="winCount" scope="session" value="${player.winCount}" />
	<script>
	
var winCount = (${winCount});
var results = (${results});
var mid = (${mid});

console.log(winCount);

function initMap() {

	
  var start = ${start};
  var end = ${end};
 
  var map = new google.maps.Map(
	      document.getElementById('map'), {zoom: 14, center: start});
  
  var result;
  var counter = 0;
  
  var location = {lat: start.lat, lng: start.lng};
  var start = new google.maps.Marker({position: location,
	  map: map,
	  label: {
		    text: "Start",
		    color: "#black",
		    fontSize: "18px",
		    fontWeight: "bold"
		  }, 
	  icon: {
		    path: google.maps.SymbolPath.CIRCLE,
		    fillColor: "green",
		    strokeColor: "green",
		    fillOpacity: 1.0,
		    scale: 15
		  }});
  
  if (winCount >= 3) {
  var location = {lat: end.lat, lng: end.lng};
  var end = new google.maps.Marker({position: location,
	  map: map,
	  label: {
		    text: "Boss",
		    color: "#black",
		    fontSize: "18px",
		    fontWeight: "bold"
		  }, 
	  icon: {
		    path: google.maps.SymbolPath.CIRCLE,
		    fillColor: "Red",
		    strokeColor: "Red",
		    fillOpacity: 1.0,
		    scale: 15
		  }});
  end.addListener('click', function() {
	  window.location.assign('/boss');
	  
    });
  }
  
  for (result of results) { 
	  
	 if (counter > 2) {
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

	counter ++;  
  } 
}

</script>

	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDNgPo3oGDoG2aLV7bxJeNDZNbP5CXd_aI&callback=initMap">
</script>

</body>
</html>