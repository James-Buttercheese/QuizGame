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


	<ul
		class="nav nav-pills justify-content-end navbar navbar-light bg-light">
		<li class="nav-item"><a class="nav-link" href="/">Logout</a></li>
	</ul>



	<c:if test="${not empty mapMessage}">
		<div class="alert alert-danger" role="alert">
			<p class="message">${mapMessage}</p>
		</div>
	</c:if>


	<%-- <c:if test="${not empty mapMessage}">
<p>${mapMessage}</p>
</c:if> --%>




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
			<div class="card" style="width: 40rem;">
				<div class="card-header">City</div>
				<!-- h4>Which City would You like to base your map in?</h4> -->
				<form method="post" action="/create">
					<div style="margin:auto;width: 50%;">
					<div class="form-check form-check-inline" style="margin-top:10px;">
					
						<input class="form-check-input" type="radio"
							name="city" id="inlineRadio1" value="detroit">
						<label class="form-check-label" for="inlineRadio1"
						style="font-family:Courier New, Courier, monospace;">Detroit</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio"
							name="city" id="inlineRadio2" value="chicago">
						<label class="form-check-label" for="inlineRadio2"
						style="font-family:Courier New, Courier, monospace;">Chicago</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input list-group-item" type="radio"
							name="city" id="inlineRadio3" value="newYork">
							<label class="form-check-label" for="inlineRadio3"
							style="font-family:Courier New, Courier, monospace;">New York</label>
					</div>
					</div>

					<!-- <select name="city">
						<option value="detroit">Detroit</option>
						<option value="chicago">Chicago</option>
						<option value="newYork">New York</option>
					</select> --> 
					<input type="hidden" value="${userId}" name="userId" />
					<br/>
					<div style="text-align:center;"><button type="submit" class="user-submit" >Submit</button></div>
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
		
		 <footer class="navbar-light bg-light" style="position: absolute;
  bottom: 0;
  width: 100%;">
  <p>© 2020 Copyright</p>
  <p style="line-height: 0.2;">Application by:</p>
  <p style="margin-bottom:0;"><a href="https://github.com/amandabcampos" target="_blank">Amanda Campos</a> | 
  <a href="https://github.com/James-Buttercheese" target="_blank">James McDowell</a> | 
  <a href="https://github.com/jlcenters" target="_blank">Jillian Centers</a></p>
</footer>
		
		
	</c:if>
	
	
	
	
	<c:if test="${not empty candidates}">
		<div class="card" style="width: 40rem;">
		
				<div class="card-header">Restaurants</div>
		
		
			<form id="createform" method="post" action="/create">


				<ul class="list-group list-group-flush">
<!-- 					<li>Locations:</li> -->
					<c:forEach var="candidate" items="${candidates}">
						<li class="list-group-item"><label><input type="checkbox" name="locale"
								value="${candidate.place_id}"> ${candidate.name } <b>Rating</b>
								${candidate.rating}</label></li>
					</c:forEach>

				</ul>
				<div style="text-align:center">
				<label style="text-align:center; font-family:Courier New, Courier, monospace;">Map Name<br/><input type="text" name="name" /> </label>
				<input type="hidden" value="${id}" name="mapId"/> 
				<input type="hidden" value="${userId}" name="userId" />
				</div>

			</form>
			
			<br/>
					<div style="text-align:center;"><button onclick="runTest()" class="user-submit" >Submit</button></div>
			
			
			<!-- <button onclick="runTest()" class="btn btn-secondary">submit</button> -->
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
	
 <footer class="navbar-light bg-light">
  <p>© 2020 Copyright</p>
  <p style="line-height: 0.2;">Application by:</p>
  <p style="margin-bottom:0;"><a href="https://github.com/amandabcampos" target="_blank">Amanda Campos</a> | 
  <a href="https://github.com/James-Buttercheese" target="_blank">James McDowell</a> | 
  <a href="https://github.com/jlcenters" target="_blank">Jillian Centers</a></p>
</footer>





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
<!-- 	
 <footer class="navbar-light bg-light">
  <p>© 2020 Copyright</p>
  <p style="line-height: 0.2;">Application by:</p>
  <p style="margin-bottom:0;"><a href="https://github.com/amandabcampos">Amanda Campos</a> | 
  <a href="https://github.com/James-Buttercheese">James McDowell</a> | 
  <a href="https://github.com/jlcenters">Jillian Centers</a></p>
</footer> -->
	

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

</body>
</html>