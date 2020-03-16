<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Onward</title>
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
	<table>
		<tr>
			<th>Name</th>
			<th>Address</th>
			<th>Rating</th>
		</tr>
		<c:forEach var="candidate" items="${candidates}">
			<tr>
				<td>${candidate.name }</td>
				<td>${candidate.formatted_address }</td>
				<td>${candidate.rating }</td>


			</tr>
		</c:forEach>

	</table>
	<!--MAP DIV-->
	<div id="map"></div>
	<!-- <script src="script.js"></script> -->
	<!--GAME STATUS-->
	<h4>
		<strong>Status</strong>
	</h4>
	<ul>
		<li><h5>Energy:</h5>
			<p>${user.energy}</p></li>
		<li><h5>Distance:</h5>
			<p>${user.distance}</p></li>
		<li><h5>Items Used:</h5>
			<p>${user.items}</p></li>
	</ul>

	<script>
		function initMap() {
			// The location of Uluru
			var rencen = {
				lat : 42.3293,
				lng : -83.0398
			};
			var rencen2 = {
				lat : 42.5,
				lng : -82.9
			};
			// The map, centered at Uluru
			var map = new google.maps.Map(document.getElementById('map'), {
				zoom : 8,
				center : rencen
			});
			// The marker, positioned at Uluru
			var marker = new google.maps.Marker({
				position : rencen,
				map : map
			});
			var marker = new google.maps.Marker({
				position : rencen2,
				map : map
			});
		}
	</script>

	<script async defer
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBoKh-kJKt_kzcKnELtFqh2n0G-E2dvwfk&callback=initMap">
		
	</script>
</body>
</html>