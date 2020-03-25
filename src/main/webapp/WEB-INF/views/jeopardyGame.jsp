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
			<li class="list-group-item">Category: ${mainClue.category.title}</li>
			<li class="list-group-item">Difficulty: ${diffName}</li>
		</ul>
	</div>

	<br />

	<div class="alert alert-primary" role="alert">
		<p style="text-align: center">${mainClue.question}</p>
	</div>




	<ul class="list-group">
		<c:forEach var="answer" items="${answers}">
			<li class="list-group-item">
				<form method="post">
					<%-- <input type="hidden" value="${mainClue.category.title}" name="category" /> --%>
					<input type="hidden" value="${mainClue.value}" name="difficulty" />
					<input type="hidden" value="${mapId}" name="mapId" />
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



<%-- 	<%@ include file="partials/script-tags.jsp"%> --%>
</body>
</html>
