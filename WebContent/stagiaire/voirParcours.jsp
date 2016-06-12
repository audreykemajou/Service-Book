<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
        <meta charset="utf-8" />
        <!--bootsrap-->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <title>Gestion Utilisateur</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <header class="text-center">
		<div class="head"><p>Evaluation stagiaire</p></div>
	</header>
    <body>    
    	<nav class="navbar">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
				      	</button>
				</div>
					<div class="col-sm-2">
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="voirListeQuestionnaires" />">Retour</a></button>
					</div>
					<div class="col-sm-2">
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="deconnexion" />">Deconnexion</a></button>
					</div>	
				
			</div>
		</nav><br>
		<div class="container-fluid">
			<div class="table-responsive">
   				<div class="row bord">
						<div class="col-sm-5">
							<label class="lab1">Score</label><br>
							<label class="lab1">Durée</label><br>
							<label class="lab1">Bonnes réponses</label><br>
						</div>
						<div class="col-sm-7">
							<label class="lab2"><c:out value="${parcours.getScore()}/${questions.size()}" /></label><br>
							<label class="lab2"><c:out value="${parcours.getDuree()} secondes" /></label><br>
							<c:forEach items="${questions}" var="question_r" varStatus="status">
								<label class="lab2"><c:out value="${question_r.getLibelle()}" /></label>
								<c:forEach items="${question_r.getReponse()}" var="reponse_r">
									<label class="lab2"><c:out value="${reponse_r.getLibelle()}" /></label><br>
    							</c:forEach>
    						</c:forEach>
						</div>
				</div><br>
    </body><br><hr/>
</html>