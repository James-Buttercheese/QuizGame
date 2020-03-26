<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="partials/style-tags.jsp"%>
<title>Leaderboard</title>
</head>
<body>
<!-- 	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		
		<h1 class="navbar-brand">Conquests and Cats</h1>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor03" aria-controls="navbarColor03"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor03">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="/">User Home</a></li>

				<li class="nav-item"><a class="nav-link" href="/how">How to
						play</a></li>
				<li class="nav-item"><a class="nav-link" href="/bts">Behind
						the scenes</a></li>
				<li class="nav-item"><a class="nav-link" href="/leaderboard">Leaderboard</a></li>
			</ul>
		</div>
	</nav> -->
	
			<ul class="nav nav-pills nav-fill navbar navbar-light bg-light">
<!-- 		<li class="nav-item"><a class="nav-link active" href="/" style="font-size:20px">Conquests and Cats</a>
		</li> -->
		<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
		<li class="nav-item"><a class="nav-link" href="/user-create">Register</a></li>
		<li class="nav-item"><a class="nav-link" href="/login">Login</a></li>	
		<li class="nav-item"><a class="nav-link" href="/bts">Behind The Scenes</a></li>
		
		</ul>
	
	

	<div class="container">
	<br/>
	<table class="table striped-table">
	<thead>
		<tr>
			<!-- <th class="nav-link">Player</th> -->
			<th scope="col"><a class="nav-link">Player Username</a></th>
			<th scope="col"><a class="nav-link" href="/leaderboard">Total Score</a></th>
			<th scope="col"><a class="nav-link" href="/wins">Games Won</a></th>
			<th scope="col"><a class="nav-link" href="/played">Questions Answered</a></th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="player" items="${players}">
			<tr>
				<th scope="row" align="center">${player.username}</th>
				<td align="center">${player.score}</td>
				<td align="center">${player.wins}</td>
				<td align="center">${player.played}</td>
			</tr>
		</c:forEach>
		</tbody>

	</table>
	</div>
	
	<%@ include file="partials/footer.jsp"%>
	<%@ include file="partials/script-tags.jsp"%>
</body>
</html>