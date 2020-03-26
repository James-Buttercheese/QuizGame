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
<%@ include file="partials/style-tags.jsp"%>
</head>
<body>

	<%-- ${cardsInDb} --%>





	<div class="container">
		<div class="row">

			<c:forEach items="${displayCards}" var="card">
				<div class="col-sm">
					<!-- <div class="card bg-primary border-danger text-white"
			style="max-width: 18rem; margin-left: auto; margin-right: auto;"> -->
					<div class="card bg-primary border-danger text-white"
						style="max-width: 18rem;" id="card-display">


						<div class="card-header">
							<h4 class="card-title">${card.name}</h4>
							<p class="card-title text-right">${card.temperament}</p>
						</div>
						<img src="${card.url}" class="card-img-top"
							style="max-width: 16rem; margin-left: auto; margin-right: auto;">
						<div class="card-body">
							<p class="card-text">${card.description}</p>
						</div>
						<div class="card-footer">
							<small class="text-muted text-center">${card.origin}</small>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
	

	<div style="text-align: center;">
		<form action="/login" method="post">
			<%-- <input type="hidden" value="${username}" name="username" /> <input
				type="hidden" value="${pin}" name="pin" /> --%>
				<input type="hidden" value="${userId}" name="userId" />
			<button class="user-submit">User Menu</button>
		</form>
	</div>






</body>
</html>