<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Final Test</title>
<%@ include file="partials/style-tags.jsp"%>
</head>
<body>
	<%@ include file="partials/header.jsp"%>

	<c:if test="${not empty tied}">
		<h2>${tied}</h2>
	</c:if>



	<p>You will be playing against the:</p>
	<div class="card shadow-sm bg-danger border-warning text-white"
		style="max-width: 22rem; margin-left: auto; margin-right: auto;">
		<div class="card-header">
			<h4 class="card-title">${bossCard.name}</h4>
			<p class="card-title text-right">${bossCard.temperament}</p>
		</div>
		<img src="${bossCard.url}" class="card-img-top"
			style="max-width: 20rem; margin-left: auto; margin-right: auto;">
		<div class="card-body">
			<p class="card-text">${bossCard.description}</p>
		</div>
		<div class="card-footer">
			<small class="text-muted text-center">${bossCard.origin}</small>
		</div>
	</div>


	<p>Who do you choose to battle and what feature?</p>
	
	<div class="card-deck">
	<c:forEach var="cat" items="${myCatCards}">
	<form method="post">
		<div class="card shadow-sm bg-primary border-danger text-white"
		style="max-width: 22rem; margin-left: auto; margin-right: auto;">
		<div class="card-header">
			<h4 class="card-title">${cat.name}</h4>
			<p class="card-title text-right">${cat.temperament}</p>
		</div>
		<img src="${cat.url}" class="card-img-top"
			style="max-width: 20rem; margin-left: auto; margin-right: auto;">
		<div class="card-body">
			<p class="card-text">${cat.description}</p>
		</div>
		<div class="card-footer">
			<small class="text-muted text-center">${cat.origin}</small>
		</div>
	</div>
	
	<select name="feature"> 
			<option value="energy_level">Energy</option>
			<option value="grooming">Grooming</option>
			<option value="intelligence">Intelligence</option>
			<option value="shedding_level">Shedding</option>
			<option value="social_needs">Social Needs</option>
			<option value="stranger_friendly">Stranger-Friendliness</option>
			<option value="vocalisation">Vocalisation</option>
	</select>
	<input type="hidden" name="battleCardId" value="${cat.id}" />
	<input type="hidden" value="${bossCard.id}" name="bossCardId" /> <input
			type="hidden" value="${userId}" name="userId" />
		<button type="submit">I choose you!</button>
	</form>
	</c:forEach>
	</div>
	
	<%@ include file="partials/footer.jsp"%>
	<%@ include file="partials/script-tags.jsp"%>
</body>
</html>

