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
	<h4 class="text-center">
		<strong>Status:</strong>
	</h4>
	<ul>
		<li><h6>
				<svg class="bi bi-flag-fill" width="1em" height="1em"
					viewBox="0 0 16 16" fill="currentColor"
					xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
						d="M3.5 1a.5.5 0 01.5.5v13a.5.5 0 01-1 0v-13a.5.5 0 01.5-.5z"
						clip-rule="evenodd" />
  <path fill-rule="evenodd"
						d="M3.762 2.558C4.735 1.909 5.348 1.5 6.5 1.5c.653 0 1.139.325 1.495.562l.032.022c.391.26.646.416.973.416.168 0 .356-.042.587-.126a8.89 8.89 0 00.593-.25c.058-.027.117-.053.18-.08.57-.255 1.278-.544 2.14-.544a.5.5 0 01.5.5v6a.5.5 0 01-.5.5c-.638 0-1.18.21-1.734.457l-.159.07c-.22.1-.453.205-.678.287A2.719 2.719 0 019 9.5c-.653 0-1.139-.325-1.495-.562l-.032-.022c-.391-.26-.646-.416-.973-.416-.833 0-1.218.246-2.223.916A.5.5 0 013.5 9V3a.5.5 0 01.223-.416l.04-.026z"
						clip-rule="evenodd" />
</svg>
				${player.winCount}/3
			</h6></li>
		<li><h6>
				<svg class="bi bi-lightning" width="1em" height="1em"
					viewBox="0 0 16 16" fill="currentColor"
					xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
						d="M11.251.068a.5.5 0 01.227.58L9.677 6.5H13a.5.5 0 01.364.843l-8 8.5a.5.5 0 01-.842-.49L6.323 9.5H3a.5.5 0 01-.364-.843l8-8.5a.5.5 0 01.615-.09zM4.157 8.5H7a.5.5 0 01.478.647L6.11 13.59l5.732-6.09H9a.5.5 0 01-.478-.647L9.89 2.41 4.157 8.5z"
						clip-rule="evenodd" />
</svg>
				(${player.energy})
			</h6></li>
		<li><h6>Party:</h6>
			<ul>
				<c:forEach items="${cats.catCardsNames}" var="cat">
					<li>${cat}</li>
				</c:forEach>
			</ul></li>
	</ul>

	<h4 class="text-center">Your Quest</h4>
	<p class="text-center">
		Purr as loud as possible, be the most annoying cat that you can, and,
		knock everything off the table. My slave human didn't give me any food
		so i pooped on the floor attempt to leap between furniture but
		woefully miscalibrate and bellyflop onto the floor; what's your
		problem? i meant to do that now i shall wash myself intently so stick
		butt in face, and hack up furballs you have cat to be kitten me right
		meow. Kitty pounce, trip, faceplant you didn't see that no you didn't
		definitely didn't lick, lick, lick, and preen away the embarrassment
		do i like standing on litter cuz i sits when i have spaces, my cat
		buddies have no litter i live in luxury cat life there's a forty year
		old lady there <strong>let us feast.</strong>
	</p>
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
	<%@ include file="partials/script-tags.jsp"%>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDhSCRIHC_0IdQCQIRlbSf1zc5xACcIIqE&callback=initMap">
</script>

</body>
</html>