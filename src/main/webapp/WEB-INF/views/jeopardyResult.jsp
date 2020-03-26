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

	<h2 class="text-center">
		<em><strong>${category}</strong> with the ${temperament}
			${catName}</em>
	</h2>
	<div class="card mb-3" style="background-color: black;">
		<img src="${catUrl}" class="card-img-top" alt="${catName}"
			style="max-width: 25rem; margin-left: auto; margin-right: auto; max-height: 40%">
	</div>


	<ul class="list-group">
		<c:forEach var="answer" items="${answers}">
			<li class="list-group-item"><c:choose>

					<c:when test="${answer == correctAnswer}">
						<button type="button"
							class="list-group-item list-group-item-action"
							style="background-color: green; color: white">
							<p style="text-align: center">${answer}</p>
						</button>
					</c:when>
					<c:otherwise>
						<button type="button"
							class="list-group-item list-group-item-action"
							style="background-color: #da0000; color: white">
							<p style="text-align: center">${answer}</p>
						</button>
					</c:otherwise>
				</c:choose></li>
		</c:forEach>
	</ul>

	<form action="/summary">
		<input type="hidden" value="${mapId}" name="mapId" /> <input
			type="hidden" value="${correct}" name="correct" /> <input
			type="hidden" value="${userId}" name="userId" />
		<c:if test="${not empty card}">
			<input type="hidden" value="${card.id}" name="cardId" />
		</c:if>
		<button type="submit" class="btn btn-secondary">Next</button>
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

</body>
</html>
