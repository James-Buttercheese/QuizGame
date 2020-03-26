<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Game: End!</title>
<%@ include file="partials/style-tags.jsp"%>
</head>
<body>

	<div class="jumbotron">
		<h1 class="display-4 text-center">${Result}</h1>
		<p class="lead">${info}</p>
		<hr>
		<hr class="my-4">
		<p>Thank you for playing!</p>
		<a class="btn btn-primary btn-lg btn-block text-white" href="/"
			role="button">Main Menu</a>
	</div>



	<h4 class="text text-center">If you liked what you saw, don't
		forget to check out the creators!</h4>
	<div style="text-align: center;">
		<div class="btn-group text-center" style="text-align: center">
			<button type="button" class="btn btn-warning dropdown-toggle-split"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
				style="display: inline-block">Amanda Campos</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="mailto:amandabcampos8@gmail.com"
					target="_blank">amandabcampos8@gmail.com</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="http://github.com/amandabcampos"
					target="_blank">Github</a> <a class="dropdown-item"
					href="http://linkedin.com/in/amandabcampos" target="_blank">LinkedIn</a>
			</div>
		</div>
		<div class="btn-group text-center" style="text-align: center">
			<button type="button" class="btn btn-warning dropdown-toggle-split"
				style="text-align: center" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">James McDowell</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="mailto:JamesMcDowell1897@gmail.com"
					target="_blank">JamesMcDowell1897@gmail.com</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item"
					href="https://github.com/James-Buttercheese" target="_blank">Github</a>
				<a class="dropdown-item"
					href="http://www.linkedin.com/in/jamesmcdowell1897" target="_blank">LinkedIn</a>
			</div>
		</div>
		<div class="btn-group text-center" style="text-align: center">
			<button type="button" class="btn btn-warning dropdown-toggle-split"
				style="text-align: center" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">Jillian Centers</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="mailto:jillcenters@protonmail.com"
					target="_blank">jillcenters@protonmail.com</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="http://github.com/jlcenters"
					target="_blank">Github</a> <a class="dropdown-item"
					href="https://www.linkedin.com/in/jillcenters/" target="_blank">LinkedIn</a>
			</div>
		</div>
	</div>

	<%@ include file="partials/footer.jsp"%>
	<%@ include file="partials/script-tags.jsp"%>
</body>
</html>