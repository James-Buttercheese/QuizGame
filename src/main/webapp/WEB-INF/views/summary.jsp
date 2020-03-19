<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" href="/style.css" />
</head>
<body>

	<h2>${correct}</h2>
	<h4>Energy Remaining: ${energy}</h4>
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