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

	<h5>Cards you have collected</h5>
	<select>
		<c:forEach items="${items}" var="item">
			<option>${item.cardName}</option>
		</c:forEach>
	</select>



	<form action="/create">
		<input type="hidden" name="userId" value="${userId}" />
		<button type="submit">Create Map</button>
	</form>

	<form action="/play-map">
		<c:if test="${!maps.equals(null)}">
			<select name="mapId">
				<c:forEach items="${maps}" var="map">
					<option value="${map.id}">${map.name}</option>
				</c:forEach>
			</select>
			<input type="hidden" value="${userId}" name="userId" />
			<button type="submit">Play Map</button>
		</c:if>
	</form>

	<%@ include file="partials/script-tags.jsp"%>
</body>
</html>