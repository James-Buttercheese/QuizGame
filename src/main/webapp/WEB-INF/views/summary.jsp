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
			<input type="hidden" value="${mapId}" name="mapId" />
			<button type="submit">Back to Map</button>
		</form>
	</c:if>

</body>
</html>