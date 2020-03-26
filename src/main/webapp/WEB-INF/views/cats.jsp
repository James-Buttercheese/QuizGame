<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="partials/style-tags.jsp"%>
</head>
<body>
	<%@ include file="partials/header.jsp"%>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Picture</th>
				<th scope="col">Powers</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="breed" items="${breeds}" varStatus="status">
				<tr>
					<th scope="row">${breed.name}</th>
					<td><img src="${images[status.index].url}"
						width="${images[status.index].width}"
						height="${images[status.index].height}" /></td>
					<td>${powers[status.index]}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<%@ include file="partials/footer.jsp"%>
	<%@ include file="partials/script-tags.jsp"%>
</body>
</html>