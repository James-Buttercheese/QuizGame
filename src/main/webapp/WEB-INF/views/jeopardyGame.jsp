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
		<em><strong>${mainClue.category.title}</strong> with the
			${temperament} ${catName}</em>
	</h2>
	<div class="card mb-3" style="background-color: black;">
		<img src="${catUrl}" class="card-img-top" alt="${catName}"
			style="max-width: 25rem; margin-left: auto; margin-right: auto; max-height: 40%">
		<p class="alert alert-dark text-white">
			<strong>Riddle me this:</strong> ${mainClue.question}
		</p>
	</div>


	<ul class="list-group">
		<c:forEach var="answer" items="${answers}">
			<li class="list-group-item">
				<form method="post">
					<%-- <input type="hidden" value="${mainClue.category.title}" name="category" /> --%>
					<input type="hidden" value="${catName}" name="catName" /> <input
						type="hidden" value="${catUrl}" name="catUrl" /> <input
						type="hidden" value="${temperament}" name="temperament" /> <input
						type="hidden" value="${cardId}" name="cardId" /> <input
						type="hidden" value="${mainClue.value}" name="difficulty" /> <input
						type="hidden" value="${mapId}" name="mapId" />
						<input type="hidden" value="${mainClue.category.title}" name="category" />
					<%-- <input type="hidden" value="${mainClue.question}" name="question" /> --%>
					<%-- <input type="hidden" value="${mainClue.answer}" name="correctAnswer" /> --%>
					<%-- <input type="hidden" value="${answers}" name="answers" /> --%>
					<input type="hidden" value="${userId}" name="userId" /> <input
						type="hidden" value="${answer}" name="answer" />
					<button type="submit"
						class="list-group-item list-group-item-action">
						<p style="text-align: center">${answer}</p>
					</button>
				</form>
			</li>
		</c:forEach>
	</ul>
	
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
