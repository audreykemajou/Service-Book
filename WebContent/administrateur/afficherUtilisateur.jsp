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
				<form class="navbar-form form_col" method = "post" action = "<c:url value="/gestionUtilisateur" />">
					<div class="col-sm-6">
						<input class="nom_nav" type ="email" placeholder="Email" name= "email">
					</div>
					<div class="col-sm-2">
						<button id="button" class="button_nav" class="btn" type ="submit">Rechercher</button>
					</div>
					<div class="col-sm-2">
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="gestionUtilisateur" />">Retour</a></button>
					</div>
					<div class="col-sm-2">
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="/deconnexion" />">Deconnexion</a></button>
					</div>	
				</form>
				
			</div>
		</nav><br>
		<div class="container-fluid">
			<div class="table-responsive">
   				<c:if test="${!empty parcours_utilisateur}">
	    			<c:forEach items="${parcours_utilisateur}" var="parcours" varStatus="status">
	    				<div class="row bord">
							<div class="col-sm-6 row">
								<div class="col-sm-5">
									<label class="lab1">Email utilisateur</label><br>
									<label class="lab1">Sujet questionnaire</label><br>
								</div>
								<div class="col-sm-7">
									<label class="lab2"><c:out value="${email}" /></label><br>
									<label class="lab2"><c:out value="${sujets.get(status.count - 1) }" /></label><br>
								</div>
							</div>
							<div class="col-sm-6 row">
								<div class="col-sm-5">
									<label class="lab1">Score</label><br>
									<label class="lab1">Durée</label><br>
								</div>
								<div class="col-sm-7">
									<label class="lab2"><c:out value="${parcours.getScore()} }" /></label><br>
									<label class="lab2"><c:out value="${parcours.getDuree()} secondes" /></label><br>
								</div>
							</div>
						</div><br>
	    			</c:forEach>
				</c:if>
			</div>
		</div>
    </body><br><hr/>
</html>