<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Watch Out!</title>
	<%@ include file="partials/style-tags.jsp"%>
</head>
<body>


	<div class="card" style="width: 18rem;">
		<ul class="list-group list-group-flush">
			<li class="list-group-item">Category: ${category}</li>
			<li class="list-group-item">Difficulty: ${diffName}</li>
		</ul>
	</div>

	<br />

	<div class="alert alert-primary" role="alert">
		<p style="text-align: center">${question}</p>
	</div>


	<ul class="list-group">
		<c:forEach var="answer" items="${answers}">
			<li class="list-group-item"><c:choose>
			
					<c:when test="${answer == correctAnswer}">
						<button type="button"
							class="list-group-item list-group-item-action" style="background-color:green; color:white">
							<p style="text-align: center">${answer}</p>
						</button>
					</c:when>
					<c:otherwise>
						<button type="button"
							class="list-group-item list-group-item-action" style="background-color:#da0000; color:white">
							<p style="text-align: center">${answer}</p>
						</button>
					</c:otherwise>
				</c:choose></li>
		</c:forEach>
	</ul>
	
<form action="/summary">
<input type="hidden" value="${mapId}" name="mapId"/>
<input type="hidden" value="${correct}" name="correct"/>
<button type="submit" class="btn btn-secondary">Next</button>
</form>
	
</body>
</html>
