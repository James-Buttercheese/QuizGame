<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="partials/style-tags.jsp"%>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<!--  -->
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
	</nav>


	<table class="table striped-table">
		<tr>
			<th>Player</th>
			<th><a class="nav-link" href="/leaderboard">Total Score</a></th>
			<th><a class="nav-link" href="/wins">Games Won</a></th>
			<th><a class="nav-link" href="/played">Questions Answered</a></th>
		</tr>
		<c:forEach var="player" items="${players}">
			<tr>
				<td>${player.username}</td>
				<td>${player.score}</td>
				<td>${player.wins}</td>
				<td>${player.played}</td>
			</tr>
		</c:forEach>

	</table>

	<%@ include file="partials/script-tags.jsp"%>
</body>
</html>