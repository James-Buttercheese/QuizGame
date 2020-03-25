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


	<form method="post">
		<div class="form-group">
			<label for="username">Username</label> <input type="text"
				class="form-control" id="username" name="username" required>
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				class="form-control" id="password" name="pin" required>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>


	<%@ include file="partials/script-tags.jsp"%>
</body>
</html>