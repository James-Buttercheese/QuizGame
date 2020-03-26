<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Final Test</title>
<%@ include file="partials/style-tags.jsp"%>
</head>
<body>
	<%-- <%@ include file="partials/header.jsp"%> --%>

	<c:if test="${not empty tied}">
		<h2>${tied}</h2>
	</c:if>



	<p>You will be playing against the:</p>

	<div class="card" style="width: ${bossWidth}pt;">
		<!--  not yet -->
		<img src="${bossCard.url}" width="${bossWidth}pt"
			height="${bossHeight}pt" class="card-img-top" alt="...">
		<div class="card-body">
			<h5 class="card-title" style="text-align: center; font-weight: bold;">${bossCard.name}</h5>
			<p class="card-text">${bossCard.temperament}</p>
		</div>
		<ul class="list-group list-group-flush">
			<li class="list-group-item">Description: ${bossCard.description}</li>
			<li class="list-group-item">Origin: ${bossCard.origin }</li>
		</ul>
	</div>

	<%-- 
	<p>Temperament: ${bossCard.temperament}</p>
	<p>Origin: ${bossCard.origin}</p>
	<p>Description: ${bossCard.description}</p>
	<img src="${bossCard.url}" /> --%>

	<p>Who do you choose to battle and what feature?</p>
	<form method="post">
		<select name="battleCardId">
			<c:forEach var="catCard" items="${myCatCards}">
				<option value="${catCard.id}">${catCard.name}</option>
			</c:forEach>
		</select> <select name="feature">
			<option value="adaptability">Adaptability</option>
			<option value="affection_level">Affection</option>
			<option value="child_friendly">Child friendly</option>
			<option value="dog_friendly">Dog friendly</option>
			<option value="energy_level">Energy</option>
			<option value="grooming">Grooming</option>
			<option value="intelligence">Intelligence</option>
			<option value="shedding_level">Shedding</option>
			<option value="social_needs">Social Needs</option>
			<option value="stranger_friendly">Stranger Friendly</option>
			<option value="vocalisation">Vocalisation</option>
		</select>
		<%-- 		<input type="hidden" value="${bossCardId}" name="bossCardId"/> --%>

		<!--  		<button type="submit">Let's battle!</button> -->




		<input type="hidden" value="${bossCard.id}" name="bossCardId" />
		<input type="hidden" value="${userId}" name="userId"/>
		<button type="submit">I choose you!</button>
	</form>
	
	 <footer class="navbar-light bg-light" style="position: absolute;
  bottom: 0;
  width: 100%;">
  <p>© 2020 Copyright</p>
  <p style="line-height: 0.2;">Application by:</p>
  <p style="margin-bottom:0;"><a href="https://github.com/amandabcampos" target="_blank">Amanda Campos</a> | 
  <a href="https://github.com/James-Buttercheese" target="_blank">James McDowell</a> | 
  <a href="https://github.com/jlcenters" target="_blank">Jillian Centers</a></p>
</footer>


<%-- 	<%@ include file="partials/script-tags.jsp"%> --%>
</body>
</html>

