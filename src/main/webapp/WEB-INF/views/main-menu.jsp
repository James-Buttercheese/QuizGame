<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="ISO-8859-1"> -->
<meta charset="UTF-8">
<title>Main Menu</title>
<%@ include file="partials/style-tags.jsp"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>


	<ul class="nav nav-pills nav-fill navbar navbar-light bg-light">
<!-- 		<li class="nav-item"><a class="nav-link active" href="/" style="font-size:20px">Conquests and Cats</a>
		</li> -->
		<li class="nav-item"><a class="nav-link" href="/user-create">Register</a></li>
		<li class="nav-item"><a class="nav-link" href="/login">Login</a></li>	
		<li class="nav-item"><a class="nav-link" href="/bts">Behind The Scenes</a></li>
		<li class="nav-item"><a class="nav-link" href="/leaderboard">Leaderboard</a></li>
<!-- 		<li class="nav-item"><a class="nav-link disabled" href="#"
			tabindex="-1" aria-disabled="true">Disabled</a></li> -->
	</ul>


	<h1 id="title">Conquests and Cats: The Game</h1>




<div class="container">
<!-- <div class="card" style="width: 50rem;" id="instructions"> -->
<div class="card" id="instructions">

<div class="card-header">
    Instructions
  </div>

<ul class="list-group list-group-flush">

<li class="list-group-item">Start by creating your cat-master persona! Select your kitty-name and a password. Next, you are ready to log-in to CatLand (it looks a lot like America).</li>

<li class="list-group-item">Choose which city you would like to live your feline adventures. </li>

<li class="list-group-item">In that city, you will have to select restaurants where you would like to battle. Each battle is a quiz, and the higher-rated the restaurant, the harder the question. </li>

<li class="list-group-item">If you win the battle, you gain a new kitty-friend in the form of a card. As winning battles is more difficult in a higher-rated restaurant, the prize-kittens you win from them are more powerful.</li>

<li class="list-group-item">Be aware, do not lose all your milk-energy! You lose energy by moving around the map based on distance so plan ahead.  </li>

<li class="list-group-item">After winning three battles, you are going to upset The Evil Alley Cat. This cat is one mean (but cute) boss hiding at one of the restaurants. You do not need to fight the boss immediately, and can continue visiting restaurants that you have not yet been to in order to gather the perfect cat posse to fight to the boss.</li>

<li class="list-group-item">Once you decide you are ready for the final battle, go to its restaurant. The boss will play its card. You will need pick your own card, and most importantly, the quality of the cat that you think will beat the boss. Do you think your kitty is more energetic than the boss? Select <i>energy</i>! Do you think your cat is more intelligent than the boss? Select <i>intelligence</i>. </li> 

<li class="list-group-item">If your chosen kitty beats the boss, you win. If you tie, you will do it all again. And if you lose, well… worry not, cats have extra lives, play another game!</li>

</ul>
</div>
</div>

<br/>
	
 <footer class="navbar-light bg-light" style="position: absolute;
  bottom: 0;
  width: 100%;">
  <p>© 2020 Copyright</p>
  <p style="line-height: 0.2;">Application by:</p>
  <p style="margin-bottom:0;"><a href="https://github.com/amandabcampos" target="_blank">Amanda Campos</a> | 
  <a href="https://github.com/James-Buttercheese" target="_blank">James McDowell</a> | 
  <a href="https://github.com/jlcenters" target="_blank">Jillian Centers</a></p>
</footer>


	<%@ include file="partials/script-tags.jsp"%>
</body>
</html>