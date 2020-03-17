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
<link rel="stylesheet" href="../style.css">
</head>
<body>

<div class="card" style="width: 18rem;">
  <ul class="list-group list-group-flush">
    <li class="list-group-item">Category: ${mainClue.category.title}</li>
    <li class="list-group-item">Difficulty: ${mainClue.value}</li>
  </ul>
</div>

<br/>

<div class="alert alert-primary" role="alert">
   <p>${mainClue.question}</p>
</div>




	<ul class="list-group">
		<c:forEach var="answer" items="${answers}">
			<li class="list-group-item">
				<form method="post">
					<input type="hidden" value="${mainClue.category.title}" name="category" />
					<input type="hidden" value="${mainClue.value}" name="difficulty" />
					<input type="hidden" value="${mainClue.question}" name="question" />
					<input type="hidden" value="${mainClue.answer}" name="correctAnswer" />
					<input type="hidden" value="${answers}" name="answers" />
					<input type="hidden" value="${answer}" name="answer" />	
					<button type="submit" class="list-group-item list-group-item-action"><p>${answer}</p></button>
				</form>
			</li>
		</c:forEach>
	</ul>




</body>
</html>