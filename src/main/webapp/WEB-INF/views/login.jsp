<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<%@ include file="partials/style-tags.jsp"%>
</head>
<body>


	<ul class="nav nav-pills nav-fill navbar navbar-light bg-light">
		<!-- 		<li class="nav-item"><a class="nav-link active" href="/" style="font-size:20px">Conquests and Cats</a>
		</li> -->
		<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
		<li class="nav-item"><a class="nav-link" href="/user-create">Register</a></li>
		<li class="nav-item"><a class="nav-link" href="/bts">Behind
				The Scenes</a></li>
		<li class="nav-item"><a class="nav-link" href="/leaderboard">Leaderboard</a></li>
		<!-- 		<li class="nav-item"><a class="nav-link disabled" href="#"
			tabindex="-1" aria-disabled="true">Disabled</a></li> -->
	</ul>

	<%-- 	<c:if test="${not empty message}">
<div class="alert alert-info" role="alert">
  <p class="message">${message}</p>
</div>
</c:if> --%>


	<c:if test="${message == 'Successfull registration. Login.'}">
		<div class="alert alert-success" role="alert">
			<p class="message">${message}</p>
		</div>
	</c:if>
	<c:if test="${message == 'Unregistred User | Incorrect information.'}">
		<div class="alert alert-danger" role="alert">
			<p class="message">${message}</p>
		</div>
	</c:if>






	<div class="container">
		<form method="post">
			<!-- <div class="card" style="width: 40rem;"> -->
			<div class="card">
				<div class="card-header">Login</div>

				<!-- <ul class="list-group list-group-flush"> -->

					<!-- <li class="list-group-item">   -->
					<br/> 
					<label for="username" >Kitty
							Name <input type="text" class="form-control" id="username"
							name="username" required>
					</label>
					<!-- </li> -->

					<!-- <li class="list-group-item"> -->
					<label for="password">Purr-sword
							<input type="password" class="form-control" id="password"
							name="pin" required>
					</label>
					<!-- </li> -->

					<br/> 
					<!-- <li class="list-group-item"> -->
					<button type="submit"
							class="user-submit">Enter CatLand</button>
							<!-- </li> -->

				<!-- </ul> -->
			</div>
		</form>
	</div>




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


	<!-- <form method="post">
  <div class="form-group">
    <label for="username">Username</label>
    <input type="text" class="form-control" id="username" name="username" required>
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name="pin" required>
  </div>
  <button type="submit" class="btn btn-primary">Login</button>
</form> -->



	<%@ include file="partials/script-tags.jsp"%>
</body>
</html>