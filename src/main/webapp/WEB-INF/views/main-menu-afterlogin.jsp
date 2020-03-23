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
	<h1>Conquests and Cats</h1>
	
	
	<!-- LOGIN AND SIGN UP HAVEN'T BEEN FULLY IMPLEMENTED YET -->
	
	<form action="/create">
	<input type="hidden" name="userId" value="${userId}"/>
	<button type="submit">Create Map</button>
	</form>
	
	<form action="/play-map">
		<select name="mapId">
			<c:forEach items="${maps}" var="map">
				<option value="${map.id}">${map.name}</option>
			</c:forEach>
		</select>
		<input type="hidden" value="${userId}" name="userId"/>
		<button type="submit">Play Map</button>
	</form>
</body>
</html>