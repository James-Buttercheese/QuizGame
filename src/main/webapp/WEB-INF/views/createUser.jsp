<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<%@ include file="partials/style-tags.jsp"%>
</head>
<body>

	<ul class="nav nav-pills nav-fill navbar navbar-light bg-light">

		<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
		<li class="nav-item"><a class="nav-link" href="/login">Login</a></li>	
		<li class="nav-item"><a class="nav-link" href="/bts">Behind The Scenes</a></li>
		<li class="nav-item"><a class="nav-link" href="/leaderboard">Leaderboard</a></li>
	</ul>
	<c:if test="${not empty message}">
<div class="alert alert-danger" role="alert">
  <p class="message">${message}</p>
</div>
</c:if>
	
	

<div class="container">
	<form method="post">
<!-- 		<div class="card" style="width: 40rem;"> -->
		<div class="card">
			<div class="card-header">Registration</div>

			<!-- <ul class="list-group list-group-flush"> -->

				<!-- <li class="list-group-item"> -->
				<br/>
				<label for="username">Kitty Name
						<input type="text" class="form-control" id="username"
						name="username" required>
				</label>
				<!-- </li> -->

				<!-- <li class="list-group-item"> -->
				<label for="password">Purr-sword
					<input type="password" class="form-control" id="password"
					name="pin" required></label>
					<!-- </li> -->
			
			<br/>
			<!-- <li class="list-group-item"> -->
			<button type="submit" class="user-submit">Register</button>
			<!-- </li> -->
			
		</div>
	</form>
	</div>

	<%@ include file="partials/footer.jsp"%>
	<%@ include file="partials/script-tags.jsp"%>
</body>
</html>