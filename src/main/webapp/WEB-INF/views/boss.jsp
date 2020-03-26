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
		<div class="alert alert-danger" role="alert">
			<p class="message">Tie!</p>
		</div>
	</c:if>



	<p style="font-family: Courier New, Courier, monospace; font-weight:bold; font-size:25px;">You will be playing against the:</p>
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

<br/>
	<p style="font-family: Courier New, Courier, monospace; font-weight:bold; font-size:25px;">Choose your card!</p>
	
<div class="container">
 <div class="card-deck" >
	<c:forEach var="cat" items="${myCatCards}">
	<form method="post">
		<div class="card shadow-sm bg-primary border-danger text-white"
		style="max-width: 22rem; margin-left: auto; margin-right: 10px;">
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
	
	
	
	<div class="form-group">
	<select name="feature" multiple class="form-control" id="exampleFormControlSelect2"> 
<!-- 			<option value="adaptability">Adaptability</option> -->
<!-- 			<option value="affection_level">Affection</option> -->
<!-- 			<option value="child_friendly">Child-Friendliness</option>
			<option value="dog_friendly">Dog-Friendliness</option> -->
			<option value="energy_level">Energy</option>
			<option value="grooming">Grooming</option>
			<option value="intelligence">Intelligence</option>
			<option value="shedding_level">Shedding</option>
			<option value="social_needs">Social Needs</option>
			<option value="stranger_friendly">Stranger-Friendliness</option>
			<option value="vocalisation">Vocalisation</option>
	</select>
	</div>
	<input type="hidden" name="battleCardId" value="${cat.id}" />
	<input type="hidden" value="${bossCard.id}" name="bossCardId" /> <input
			type="hidden" value="${userId}" name="userId" />
		<button type="submit" class="user-submit">I choose you!</button>
	</form>
	</c:forEach>
	</div> 
	</div>
	
	<%@ include file="partials/footer.jsp"%>
	<%@ include file="partials/script-tags.jsp"%>
</body>
</html>

