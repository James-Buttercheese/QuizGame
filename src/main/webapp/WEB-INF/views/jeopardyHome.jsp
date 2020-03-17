<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="/style.css"/>
</head>
<body>


<form action="/jeopardy/game">

<label for="diff">Difficulty:</label>

<select id="diff" name="diff">
  <option value="100">100</option>
  <option value="200">200</option>
  <option value="300">300</option>
  <option value="400">400</option>
  <option value="500">500</option>
  <option value="600">600</option>
  <option value="800">800</option>
  <option value="1000">1000</option>
</select>

<br/>
<button type="submit" class="btn btn-secondary">Submit</button>


</form>


</body>
</html>