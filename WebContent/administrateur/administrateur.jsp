<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
        <meta charset="utf-8" />
        <!--bootsrap-->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <title>Accueil Admin</title>
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
					<div class="col-sm-2">
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="/index.jsp" />">Retour</a></button>
					</div>	
				</form>
				
			</div>
		</nav><br>
    <div class="text-center">
    	<div class ="button">	
			<a id="button" class="btn" href="<c:url value="/gestionUtilisateur" />">Gestions des utilisateurs</a>	
		</div>
		<div class ="button">	
			<a id="button" class="btn" href="<c:url value="/gestionQuestionnaire" />">Gestions des questionnaires</a>	
		</div>
    </div>
    </body>
</html>