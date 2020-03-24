<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Menu</title>
	<%@ include file="partials/style-tags.jsp"%>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<!--  --><h1 class="navbar-brand">Conquests and Cats</h1>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor03" aria-controls="navbarColor03"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarColor03">
		<ul class="navbar-nav mr-auto">
			<!-- <li class="nav-item"><a class="nav-link" href="/play">New Game</a></li> -->
			<!--  <li class="nav-item"><a class="nav-link" href="/">Load Game</a></li>-->
			<!-- <li class="nav-item"><a class="nav-link" href="/">User Home</a>
			</li> -->
			<li class="nav-item"><a class="nav-link" href="/how">How to play</a></li>
			<li class="nav-item"><a class="nav-link" href="/bts">Behind the scenes</a></li>
			<li class="nav-item"><a class="nav-link" href="/leaderboard">Leaderboard</a></li>
		</ul>
	</div>
</nav>




	<h1>Conquests and Cats</h1>
	
	<c:if test = "${not empty message}">
         <p>${message}</p>
	</c:if>
	
	<!-- LOGIN AND SIGN UP HAVEN'T BEEN FULLY IMPLEMENTED YET -->
	<a href="/login"><button>User Log In</button></a>
	<a href="/user-create"><button>Create a User</button></a>
	
	
	<%-- <a href="/create"><button>Create Map</button></a>
	<form action="/play-map">
		<select name="mapId">
			<c:forEach items="${maps}" var="map">
				<option value="${map.id}">${map.name}</option>
			</c:forEach>
		</select>
		<button type="submit">Play Map</button>
	</form> --%>
</body>
</html>