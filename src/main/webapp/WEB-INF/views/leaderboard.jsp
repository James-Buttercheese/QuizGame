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


</body>
</html>