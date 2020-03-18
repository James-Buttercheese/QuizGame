<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Favicon It's a coffee cup right now. Change it to whatever you want-->
<link rel="icon" type="image/png"
	href="https://i2.wp.com/awakedetroit.com/wp-content/uploads/2019/04/cropped-Favicon.png?ssl=1">
<!-- Bootstrap core CSS -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<!-- Bootswatch Theme Flatly. Grab a different one from https://www.bootstrapcdn.com/bootswatch/ if you want-->
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/flatly/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-yrfSO0DBjS56u5M+SjWTyAHujrkiYVtRYh2dtB3yLQtUz3bodOeialO59u5lUCFF"
	crossorigin="anonymous">
<link rel="stylesheet" href="/style.css">
<link rel="stylesheet" href="../style.css">
</head>
<body>


<!-- 	<div> -->
<!-- 		<form method="post" action="/places"> -->
<!-- 			<select name="location"> -->
<%-- 				<c:forEach var="candidate" items="${candidates}"> --%>
<%-- 					<option value="${candidate.geometry.location}">${candidate.name }</option> --%>
<%-- 				</c:forEach> --%>
<!-- 				</select> -->
<!-- 				<button type="submit" class="btn btn-secondary">submit</button> -->
<!-- 		</form> -->

<!-- 	</div> -->

	<!--  <table> -->
	<!--   <tr> -->
	<!--     <th>Name</th> -->
	<!--     <th>Address</th> -->
	<!--     <th>Rating</th> -->
	<!--   </tr> -->
	<%--    <c:forEach var="candidate" items="${candidates}"> --%>
	<!--   <tr> -->
	<%--     <td>${candidate.name }</td> --%>
	<%--     <td>${candidate.vicinity }</td> --%>
	<%--      <td>${candidate.rating }</td> --%>


	<!--   </tr> -->
	<%--    </c:forEach> --%>
	


	<h3>My Google Maps Demo</h3>
	<!--The div element for the map -->
	<div id="map" style=" height: 400px;width: 100%;"></div>
	<!-- Replace the value of the key parameter with your own API key. -->



	<!-- <script src="script.js"></script> -->
	<script>

function initMap() {
  // The location of Uluru
  var rencen = {lat: ${lat} , lng: ${lng} };

  var rencen2 = {lat: 42.5 , lng: -82.9 };
  // The map, centered at Uluru
  var map = new google.maps.Map(
      document.getElementById('map'), {zoom: 15, center: rencen});
  // The marker, positioned at Uluru
  var marker = new google.maps.Marker({position: rencen, map: map});
  var marker = new google.maps.Marker({position: rencen2, map: map});
}


</script>

	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAQBAPP61snKjU7C8Gma0DXzZ_YkJ9wsLk&callback=initMap">
</script>
	<!-- AIzaSyAQBAPP61snKjU7C8Gma0DXzZ_YkJ9wsLk -->

</body>
</html>