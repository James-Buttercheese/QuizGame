<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Watch Out!</title>
<link rel="icon" type="image/png"
	href="https://i2.wp.com/awakedetroit.com/wp-content/uploads/2019/04/cropped-Favicon.png?ssl=1">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/flatly/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-yrfSO0DBjS56u5M+SjWTyAHujrkiYVtRYh2dtB3yLQtUz3bodOeialO59u5lUCFF"
	crossorigin="anonymous">
<link rel="stylesheet" href="/style.css">
<link rel="stylesheet" href="../style.css">
</head>
<body>
	<%@ include file="partials/header.jsp"%>
	
	
		<h3>My Google Maps Demo</h3>
	<!--The div element for the map -->
	<div id="map" style=" height: 400px;width: 100%;"></div>
	<!-- Replace the value of the key parameter with your own API key. -->

	<!-- <script>var locations = ${locations}</script> -->





	<script>

// var locations = (${locations});
var results = (${results});
var mid = (${mid});

function initMap() {

	console.log(results[0].lat);
	
  var rencen = results[0];
 
  var map = new google.maps.Map(
	      document.getElementById('map'), {zoom: 15, center: rencen});
  
  var result;
  
  for (result of results) { 
	  
	  	
	  var location = {lat: result.lat, lng: result.lng};
	  var marker = new google.maps.Marker({position: location,
		  map: map,
		  title: result.place_id});
	  marker.addListener('click', function() {
		  window.location.assign('/jeopardy?placeId='+this.getTitle()+"&mapid="+mid);
		  
// 		  /jeopardy?placeId=A&mapId=B
		  
        });

	  
  } 
}

</script>

	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBoKh-kJKt_kzcKnELtFqh2n0G-E2dvwfk&callback=initMap">
</script>

</body>
</html>