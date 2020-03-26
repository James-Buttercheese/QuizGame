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
	
	
	 <ul class="nav nav-pills nav-fill navbar navbar-light bg-light"> 
	
		<li class="nav-item"><a class="nav-link" href="/bts" target="_blank">Behind The Scenes</a></li>
		<li class="nav-item"><a class="nav-link" href="/leaderboard" target="/blank">Leaderboard</a></li>
		<li class="nav-item"><a class="nav-link" href="/">Logout</a></li>

	</ul>


	<c:if test="${not empty mapMessage}">
		<div class="alert alert-danger" role="alert">
			<p class="message">${mapMessage}</p>
		</div>
	</c:if>


	<c:if test="${empty candidates}">
		<c:if test="${empty locations }">
			<div class="container">
				<!-- <div class="card" style="width: 40rem;"> -->
				<div class="card">
					<div class="card-header">Create</div>
					<!-- h4>Which City would You like to base your map in?</h4> -->
					<form method="post" action="/create">
						<div style="margin: auto; width: 40%;">
							<br />
							<h6
								style="font-family: Courier New, Courier, monospace; text-align: center; font-weight: bold">City
							</h6>
							<div class="form-check form-check-inline"
								style="margin-top: 10px;">
								<input class="form-check-input" type="radio" name="city"
									id="inlineRadio1" value="detroit"> <label
									class="form-check-label" for="inlineRadio1"
									style="font-family: Courier New, Courier, monospace;">Detroit</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input" type="radio" name="city"
									id="inlineRadio2" value="chicago"> <label
									class="form-check-label" for="inlineRadio2"
									style="font-family: Courier New, Courier, monospace;">Chicago</label>
							</div>
							<div class="form-check form-check-inline">
								<input class="form-check-input list-group-item" type="radio"
									name="city" id="inlineRadio3" value="newYork"> <label
									class="form-check-label" for="inlineRadio3"
									style="font-family: Courier New, Courier, monospace;">New
									York</label>
							</div>
						</div>
						<input type="hidden" value="${userId}" name="userId" /> <br />
						<div style="text-align: center;">
							<button type="submit" class="user-submit">Submit</button>
						</div>
						<br />
					</form>



					<div class="card-header">Edit</div>

					<form method="post" action="/create">

						<div class="form-group">
							<br />
							<h6 class="card-subtitle mb-2 text-muted"
								style="text-align: center; font-family: Courier, monospace;">Your
								Maps:</h6>
							<select multiple class="form-control"
								id="exampleFormControlSelect2" name="mapId" required>
								<c:forEach items="${maps}" var="map">
									<option value="${map.id}">${map.name}</option>
								</c:forEach>
							</select> <input type="hidden" value="${userId}" name="userId" /> <br />
							<div style="text-align: center;">
								<button type="submit" class="user-submit">Edit Map</button>

							</div>

						</div>

					</form>
				</div>
			</div>
		</c:if>
	</c:if>


	<c:if test="${not empty candidates}">
		<div class="container">
			<!-- 		<div class="card" style="width: 40rem;"> -->
			<div class="card">

				<div class="card-header">Restaurants</div>


				<form id="createform" method="post" action="/create">


					<ul class="list-group list-group-flush">
						<!-- 					<li>Locations:</li> -->
						<c:forEach var="candidate" items="${candidates}">
							<!-- <li class="list-group-item"> -->
							<br />
							<label><input type="checkbox" name="locale"
								value="${candidate.place_id}"> ${candidate.name } <b>Rating</b>
								${candidate.rating}</label>
							<!-- </li> -->
						</c:forEach>

					</ul>
					<div style="text-align: center">
						<label
							style="text-align: center; font-family: Courier New, Courier, monospace;">Map
							Name<br /> <input type="text" name="name" />
						</label> <input type="hidden" value="${id}" name="mapId" /> <input
							type="hidden" value="${userId}" name="userId" />
					</div>

				</form>

				<br />
				<div style="text-align: center;">
					<button onclick="runTest()" class="user-submit">Submit</button>
				</div>
			</div>
		</div>


	</c:if>
	<c:if test="${not empty locations}">


		<div class="container">
			<form action="/play-map">


				<c:if test="${!maps.equals(null)}">
					<c:if test="${empty candidates}">

						<div class="form-group">
							<br />
							<h6 class="card-subtitle mb-2 text-muted"
								style="text-align: center; font-family: Courier, monospace;">Your
								Maps:</h6>
							<select multiple class="form-control"
								id="exampleFormControlSelect2" name="mapId" required>
								<c:forEach items="${maps}" var="map">
									<option value="${map.id}">${map.name}</option>
								</c:forEach>
							</select> <input type="hidden" value="${userId}" name="userId" /> <br />
							<div style="text-align: center;">
								<button type="submit" class="user-submit">Play Map</button>

							</div>

						</div>
					</c:if>
			</form>
		</div>

	</c:if>

	<!-- <div id="map" style="height: 400px; width: 100%;"></div> -->
	<div id="map" class="container"></div>

	</c:if>

	<footer class="navbar-light bg-light"
		style="position: absolute; bottom: 0; width: 100%;">
		<p>© 2020 Copyright</p>
		<p style="line-height: 0.2;">Application by:</p>
		<p style="margin-bottom: 0;">
			<a href="https://github.com/amandabcampos" target="_blank">Amanda
				Campos</a> | <a href="https://github.com/James-Buttercheese"
				target="_blank">James McDowell</a> | <a
				href="https://github.com/jlcenters" target="_blank">Jillian
				Centers</a>
		</p>
	</footer>


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
		src="https://maps.googleapis.com/maps/api/js?key=${apikey}&callback=initMap">

</script>
	<%@ include file="partials/script-tags.jsp"%>

</body>
</html>