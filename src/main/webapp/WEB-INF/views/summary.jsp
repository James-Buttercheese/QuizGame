<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Battle: End!</title>
<%@ include file="partials/style-tags.jsp"%>
</head>
<body>

	<c:choose>
		<c:when test="${correct=='You won!'}">
			<div class="alert alert-success" role="alert">
				<h4 class="alert-heading text-center">Well done!</h4>

				<hr>
				<c:choose>
					<c:when test="${wins==1}">
						<p>That was purrfect! You've conquered your first bit of land.</p>
					</c:when>
					<c:otherwise>
						<p>That was purrfect! You've conquered yet another location
							flawlessly.</p>
					</c:otherwise>
				</c:choose>

				<hr>
				<ul>
					<li><p>
							<strong>A ${cardName} has joined your party!</strong>
						</p></li>
					<li><p>
							<strong>You currently have ${energy} points of energy.</strong>
							Don't let it get to zero!
						</p></li>
					<li><p>
							<strong>You've conquered ${wins} area<c:if
									test="${wins>1 || wins<1}">s </c:if> total.</strong> Keep up the good work!
						</p></li>
				</ul>
			</div>
			<div class="card shadow-sm bg-primary border-danger text-white"
				style="max-width: 18rem; margin-left: auto; margin-right: auto;">
				<div class="card-header">
					<h4 class="card-title">${cardName}</h4>
					<p class="card-title text-right">${cardTemperament}</p>
				</div>
				<img src="${cardUrl}" class="card-img-top"
					style="max-width: 16rem; margin-left: auto; margin-right: auto;">
				<div class="card-body">
					<p class="card-text">${cardDescription}</p>
				</div>
				<div class="card-footer">
					<small class="text-muted text-center">${cardOrigin}</small>
				</div>
			</div>
			<br />
			<form action="/play-map">
				<input type="hidden" value="${mapId}" name="mapId" /> <input
					type="hidden" value="${userId}" name="userId" />
				<h2>
					<button type="submit" class="btn btn-success btn-outline-light">Map</button>
				</h2>
			</form>
		</c:when>

		<c:otherwise>
			<c:choose>
				<c:when test="${not empty gameOver}">
					<div class="alert alert-danger" role="alert">
						<h4 class="alert-heading text-center">Are you spacing out?
							That's incorrect!</h4>
						<hr>
						<h5>
							<strong>Game Over</strong>
						</h5>
						<small class="text-center">You ran out of energy, and decided to go back home. At least it was fun while it lasted.
							Please play again.</small>
					</div>

					<img src="${lostUrl}" width="${lostWidth}pt"
						height="${lostHeight}pt" />
					<br />
					<h2>
						<a href="/" class="btn btn-danger btn-outline-light">Main Menu</a>
					</h2>
				</c:when>
				<c:otherwise>
					<div class="alert alert-danger" role="alert">
						<h4 class="alert-heading text-center">Are you spacing out?
							That's incorrect!</h4>
						<hr>
						<ul>
							<li><p>
									<strong>You currently have ${energy} points of energy.</strong>
									Be careful, and try not to let it get to zero!
								</p></li>
							<li><p>
									<strong>You've conquered ${wins} area<c:if
											test="${wins>1 || wins<1}">s </c:if> total.
									</strong> Don't lose focus!
								</p></li>
						</ul>
					</div>
					<img src="${lostUrl}" width="${lostWidth}pt"
						height="${lostHeight}pt" style="margin-left: auto; margin-right: auto;" />
					<br />
					<form action="/play-map">
						<input type="hidden" value="${mapId}" name="mapId" /> <input
							type="hidden" value="${userId}" name="userId" />
						<h2>
							<button type="submit" class="btn btn-danger btn-outline-light">Map</button>
						</h2>
					</form>
				</c:otherwise>
			</c:choose>

		</c:otherwise>
	</c:choose>
	<%@ include file="partials/script-tags.jsp"%>
</body>
</html>