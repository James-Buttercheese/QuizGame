<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Behind The Scenes</title>
<%@ include file="partials/style-tags.jsp"%>
</head>
<body>

	<ul class="nav nav-pills nav-fill navbar navbar-light bg-light">
		<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
		<li class="nav-item"><a class="nav-link" href="/user-create">Register</a></li>
		<li class="nav-item"><a class="nav-link" href="/login">Login</a></li>
		<li class="nav-item"><a class="nav-link" href="/leaderboard">Leaderboard</a></li>
	</ul>

<div class="container">
<div id="bts-table">
<table class="table">
  <thead>
    <tr>
      <th scope="col" colspan="2" id="header-bts">Behind The Scenes</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">User</th>
      <td width>Users’ login information is stored on a database. Usernames must
		be unique. At login, if the username matches the password, the user
		will be taken to their dashboard.</td>
    </tr>
    <tr>
      <th scope="row">Maps</th>
      <td>A map creation feature is available. A list of cities and their
		respective locations are displayed - retrieved from the 
		<a href="https://developers.google.com/places/web-service/intro" target="_blank">Google Places
		API</a>. These locations are restaurants within a radius of 1500 (?) from
		a pre-selected downtown landmark (e.g, the Renaissance Center in
		Detroit). These personalized maps and selected restaurants are stored
		on separate databases. The maps previously created by the user,
		including the latest, are displayed on the dashboard to be played.</td>
    </tr>
    <tr>
      <th scope="row">Sessions</th>
      <td>Players start with an Energy Level of 15 and 0 cards. A session
		stores both these parameters, while also keeping track of the amount
		of quiz-battles won in the current game and the restaurants that
		cannot be re-visited.</td>
    </tr>
        <tr>
      <th scope="row">Quiz</th>
      <td>Trivia questions, categories and difficulties are retrieved from
		the <a href="http://jservice.io/" target="_blank">jService API</a>. Cat-related categories were selected and, in order
		to achieve a multiple choice game version, answers from different
		questions, within the same category, were assorted with the correct
		answer.</td>
    </tr>
    <tr>
      <th scope="row">Rating</th>
      <td>A mathematical analysis was conducted considering the ratings of
		the restaurants in downtown areas. Such ratings influentiate the level
		of difficulty, the amount of energy won/lost and the types of cat
		cards received at the end of the quizzes. 
		
		<div style="text-align:center">
		Easy: rating < 4.2<br/>
		Medium: 4.2 <= rating < 4.4 <br/>
		Hard: 4.4 <= rating <= 5.0
		</div>
		
	  </td>
    </tr>
    <tr>
      <th scope="row">Cat Cards</th>
      <td>Cats information is retrieved from <a href="https://docs.thecatapi.com/"
      target="_blank">The Cat Api</a>. This Api
		generates images and features on cat breeds, such as levels of
		adaptability and energy. Cat breeds were turned into game cards. The
		most powerful cards are of breeds with high scoring in most features.
		Cat cards collected by users are stored in a database in case they
		desire to collect all of them.</td>
    </tr>
        <tr>
      <th scope="row">Energy</th>
      <td>Energy levels will be affected depending on the difficulty level
		of the quizzes and when moving between locations on the map. The
		further away two selected locations are, the more energy will be lost.
		
		<div style="text-align:center">
		Easy: Increase of 5 or decrease of 15 <br/>
		Medium: Increase or decrease of 10<br/>
		Hard: Increase of 15 or decrease 5
		</div>
		</td>
    </tr>
    <tr>
      <th scope="row">Boss Battle</th>
      <td>This is a battle of cards. The boss card is randomly generated
		amongst the most powerful cards. Boss cards will continue to get
		generated in the case of ties.</td>
    </tr>
  </tbody>
</table>
</div>
</div>


<!-- 	<h3>Behind the scenes:</h3>

	<h5>User</h5>
	<p>Users’ login information is stored on a database. Usernames must
		be unique. At login, if the username matches the password, the user
		will be taken to their dashboard.</p>

	<h5>Maps</h5>
	<p>A map creation feature is available. A list of cities and their
		respective locations are displayed - retrieved from the Google Places
		API . These locations are restaurants within a radius of 1500 (?) from
		a pre-selected downtown landmark (e.g, the Renaissance Center in
		Detroit). These personalized maps and selected restaurants are stored
		on separate databases. The maps previously created by the user,
		including the latest, are displayed on the dashboard to be played.</p>
>>>>>>> e0007d366316f8b8f78bf37d5d294e85bc04defc

	<h5>Sessions</h5>
	<p>Players start with an Energy Level of 15 and 0 cards. A session
		stores both these parameters, while also keeping track of the amount
		of quiz-battles won in the current game and the restaurants that
		cannot be re-visited.</p>

	<h5>Quiz</h5>
	<p>Trivia questions, categories and difficulties are retrieved from
		the jService API. Cat-related categories were selected and, in order
		to achieve a multiple choice game version, answers from different
		questions, within the same category, were assorted with the correct
		answer.</p>

	<h5>Rating</h5>
	<p>A mathematical analysis was conducted considering the ratings of
		the restaurants in downtown areas. Such ratings influentiate the level
		of difficulty, the amount of energy won/lost and the types of cat
		cards received at the end of the quizzes. Rating < 4.2 -> Easy 4.2 <=
		Rating < 4.4 -> Medium 4.4 <= Rating <= 5.0 -> Hard</p>
	<h5>Cat Cards</h5>
	<p>Cats information is retrieved from The Cat Api. This Api
		generates images and features on cat breeds, such as levels of
		adaptability and energy. Cat breeds were turned into game cards. The
		most powerful cards are of breeds with high scoring in most features.
		Cat cards collected by users are stored in a database in case they
		desire to collect all of them.</p>

	<h5>Energy</h5>
	<p>Energy levels will be affected depending on the difficulty level
		of the quizzes and when moving between locations on the map. The
		further away two selected locations are, the more energy will be lost.
		Easy: Increase of 5 or decrease of 15 Medium: Increase or decrease of
		10 Hard: Increase of 15 or decrease 5</p>
	<h5>Boss battle</h5>
	<p>This is a battle of cards. The boss card is randomly generated
		amongst the most powerful cards. Boss cards will continue to get
		generated in the case of ties.</p>
 -->
 <footer class="navbar-light bg-light" style="position: absolute;
  bottom: 0;
  width: 100%;">
  <p>© 2020 Copyright</p>
  <p style="line-height: 0.2;">Application by:</p>
  <p style="margin-bottom:0;"><a href="https://github.com/amandabcampos" target="_blank">Amanda Campos</a> | 
  <a href="https://github.com/James-Buttercheese" target="_blank">James McDowell</a> | 
  <a href="https://github.com/jlcenters" target="_blank">Jillian Centers</a></p>
</footer>

	<a href="/">Home</a>
	<%@ include file="partials/script-tags.jsp"%>
</body>
</html>