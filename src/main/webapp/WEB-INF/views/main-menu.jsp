<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Menu</title>
	<%@ include file="partials/style-tags.jsp"%>
</head>
<body>
	<h1>Countries and Cats</h1>
	<a href="/create">Create Map</a>
	<form action="/play-map">
		<select name="mapId">
			<c:forEach items="${maps}" var="map">
				<option value="${map.id}">${map.id}</option>
			</c:forEach>
		</select>
		<button type="submit">Play Map</button>
	</form>
</body>
</html>