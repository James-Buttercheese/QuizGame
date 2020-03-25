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
<%-- 	<%@ include file="partials/script-tags.jsp"%> --%>


	<h3>Select a destination to conquer:</h3>

	<c:if test="${boss.equals('Boss')}">
		<div class="alert alert-warning alert-dismissible fade show"
			role="alert">
			<strong>How catastrophic!</strong> The ruler of this land is
			challenging you. Are you ready to accept?
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>

	<!--The div element for the map -->
	<div id="map" style="height: 400px; width: 100%;"></div>
	<!-- Replace the value of the key parameter with your own API key. -->

	<!-- <script>var locations = ${locations}</script> -->


	<!-- USER INFORMATION -->
	<table style="width: 100%">
		<tr>
			<th><h4>Name: Level:</h4></th>
			<th><h4></h4></th>
			<th><h4>Your Quest</h4></th>
		</tr>

		<tr>
			<td>
				<ul>
					<li><h6>Areas Conquered: ${player.winCount}/3</h6></li>
					<li><h6>Energy:</h6></li>
					<li><h6>
							Items in Bag:
							<!-- Do we need items/merchants? -->
						</h6></li>
				</ul>
			</td>
			<td></td>
			<td><p>
					Purr as loud as possible, be the most annoying cat that you can,
					and, knock everything off the table. My slave human didn't give me
					any food so i pooped on the floor attempt to leap between furniture
					but woefully miscalibrate and bellyflop onto the floor; what's your
					problem? i meant to do that now i shall wash myself intently so
					stick butt in face, and hack up furballs you have cat to be kitten
					me right meow. Kitty pounce, trip, faceplant you didn't see that no
					you didn't definitely didn't lick, lick, lick, and preen away the
					embarrassment do i like standing on litter cuz i sits when i have
					spaces, my cat buddies have no litter i live in luxury cat life
					there's a forty year old lady there <strong>let us feast.</strong>
				</p></td>
		</tr>
	</table>
	<c:set var="winCount" scope="session" value="${player.winCount}" />
	<c:set var="visited" scope="session" value="${player.visited}" />

	<script>
	
var winCount = (${winCount});
var results = (${results});
var mid = (${mid});
var userId = (${userId}); 
var visited = (${visited});

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
	  window.location.assign('/boss-battle?userId='+userId);
	  
    });
  }
  
  for (result of results) { 
	  var counter2 = false;
	 if (counter > 2) {
		 for (visit of visited) {
			 console.log(result.place_id + " " + visit.id)
			 if (result.place_id === visit.id){
				 counter2=true
			 }
		 }
	if (counter2 === true) {
		
		var location = {lat: result.lat, lng: result.lng};
		  var seen = new google.maps.Marker({position: location,
			  map: map, 
			  icon: {
				    path: google.maps.SymbolPath.CIRCLE,
				    fillColor: "red",
				    strokeColor: "purple",
				    fillOpacity: .5,
				    Opacity: .5,
				    scale: 10
				  },
			  title: "Visited"});
		
	} else {		 
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
		  window.location.assign('/jeopardy?placeId='+this.getTitle()+"&mapId="+mid+"&userId="+userId);
/* 		  window.location.assign('/jeopardy?placeId='+this.getTitle()+"&mapId="+mid); */
		  
        });
  		}
	 }
	counter ++;  
  } 
}

</script>

	<script 
	async defer
			src="https://maps.googleapis.com/maps/api/js?key=${apikey}&callback=initMap">
</script>

</body>
</html>