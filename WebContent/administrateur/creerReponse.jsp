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
        <title>Creation reponse</title>
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
					<div class="col-md-offset-8 col-sm-2">
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="afficherQuestion"><c:param name="id" value="${question.getId()}"/></c:url>">Retour</a></button>
					</div>
					<div class="col-sm-2">
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="/deconnexion" />">Deconnexion</a></button>
					</div>
			</div>
		</nav><br>
        <div class="container-fluid text-center tab-content"><br/><br/>
			<div class ="consigne">Remplir les informations concernant la question</div><br/>
			<div class ="form">
				<fieldset>	
					<div id="form">
           			<form class="form"class="content" method="post" action="<c:url value="/creerReponse" />">
           				<div class ="champ">	
							<label class="lab">Question:</label>
							<input type="text" class="input" id="nom" name="question" disabled="disabled" value="${question.libelle}"  size="20" maxlength="60" />
						</div>
						<div class ="champ hidden">	
							<label class="lab">Question:</label>
							<input type="text" class="input" id="nom" name="id" value="${question.getId()}"  size="20" maxlength="60" />
						</div>
           				<div class ="champ">	
							<label class="lab">Libelle:</label>
							<input type="text" class="input" id="nom" name="libelle" value="" size="20" maxlength="60" />
						</div>
						<div class ="champ">	
							<label class="lab">Bonne:</label>
							<input type="text" class="input" id="nom" name="bonne" value="" size="20" maxlength="60" />
						</div>
						<div class ="champ">	
							<label class="lab">statut:</label>
							<input type="text" class="input" id="prenom" name="statut" value="" size="20" maxlength="60" />
						</div>
						<div class ="champ">	
							<label class="lab">Ordre:</label>
							<input type="text" class="input" id="prenom" name="ordre" value="" size="20" maxlength="60" />
						</div>					
						<div class ="button">	
							<button id="button" class="btn" type ="submit">Creer réponse</button>	
						</div>
		    		</form>
		    		</div>
               	</fieldset>
        	</div>
       	</div>
    </body>
</html>
