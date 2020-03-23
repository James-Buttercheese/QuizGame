<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="partials/style-tags.jsp"%>
</head>
<body>

	<h2>${correct}</h2>
	
	<c:choose>
    <c:when test="${correct=='You won!'}">
        <p>Your new card:</p>
		<div class="card" style="width: ${cardWidth}pt;">
			<img src="${cardUrl}" width="${cardWidth}pt" height="${cardHeight}pt" class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title" style="text-align:center; font-weight:bold;">${cardName}</h5>
				<p class="card-text">${cardTemperament}</p>
			</div>
			<ul class="list-group list-group-flush">
				<li class="list-group-item">Description: ${cardDescription}</li>
				<li class="list-group-item">Origin: ${cardOrigin }</li>
			</ul>
		</div>
    </c:when>    
    <c:otherwise>
        <p>Are you spacing out? That's incorrect!</p>
        <img src="${lostUrl}" width="${lostWidth}pt" height="${lostHeight}pt"/>
        <br />
    </c:otherwise>
	</c:choose>
	
<%-- 	<c:if test="${correct=='You won!'}">
		<p>Your new card:</p>
		<div class="card" style="width: ${cardWidth}pt;">
			<img src="${cardUrl}" width="${cardWidth}pt" height="${cardHeight}pt" class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title" style="text-align:center; font-weight:bold;">${cardName}</h5>
				<p class="card-text">${cardTemperament}</p>
			</div>
			<ul class="list-group list-group-flush">
				<li class="list-group-item">Description: ${cardDescription}</li>
				<li class="list-group-item">Origin: ${cardOrigin }</li>
			</ul>
		</div>

	</c:if> --%>

	<h4>Current Energy: ${energy}</h4>
	<h4>Total Wins: ${wins}</h4>
	<c:if test="${not empty gameOver}">
		<h2>${gameOver}</h2>
		<c:if test="${isBoss}">
			<h2>You Fought The Boss!</h2>
		</c:if>
		<a href="/"><button>Main Menu</button></a>
	</c:if>
	<c:if test="${empty gameOver}">
		<form action="/play-map">
			<input type="hidden" value="${mapId}" name="mapId" /> <input
				type="hidden" value="${userId}" name="userId" />
			<button type="submit">Back to Map</button>
		</form>
	</c:if>

</body>
</html>