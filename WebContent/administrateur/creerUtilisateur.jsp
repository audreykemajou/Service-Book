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
        <title>Creation utilisateur</title>
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
					<div class="col-md-offset-8 col-sm-2">
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="/gestionUtilisateur" />">Retour</a></button>
					</div>
					<div class="col-sm-2">
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="deconnexion" />">Deconnexion</a></button>
					</div>	
				</form>
				
			</div>
		</nav><br>
        <div class="container-fluid text-center tab-content"><br/><br/>
			<div class ="consigne">Remplir les informations concernant l'utilisateur</div><br/>
			<div class ="form">
				<fieldset>	
					<div id="form">
           			<form class="form"class="content" method="post" action="<c:url value="/creerUtilisateur" />">
           				<div class ="champ">	
							<label class="lab">Nom:</label>
							<input type="text" class="input" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="60" />
						</div>
						<div class ="champ">	
							<label class="lab">Prenom:</label>
							<input type="text" class="input" id="prenom" name="prenom" value="<c:out value="${utilisateur.prenom}"/>" size="20" maxlength="60" />
						</div>
						<div class ="champ">	
							<label class="lab">Mail:</label>
							<input type="email" class="input" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
						</div>
						<div class ="champ">	
							<label class="lab">Mot de passe:</label>
							<input type="text" class="input" id="motdepasse" name="motdepasse" value="<c:out value="${utilisateur.motDePasse}"/>" size="20" maxlength="60" />
						</div>
						<div class ="champ">	
							<label class="lab">Admin:</label>
							<input type="text" class="input" id="admin" name="admin" value="<c:out value="${utilisateur.admin}"/>" size="20" maxlength="60" />
						</div>
						<div class ="champ">	
							<label class="lab">Societe:</label>
							<input type="text" class="input" id="societe" name="societe" value="<c:out value="${utilisateur.societe}"/>" size="20" maxlength="60" />
						</div>
						<div class ="champ">	
							<label class="lab">Statut:</label>
							<input type="text" class="input" id="statut" name="statut" value="<c:out value="${utilisateur.statut}"/>" size="20" maxlength="60" />
						</div>
						<div class ="champ">	
							<label class="lab">Telephone:</label>
							<input type="text" class="input" id="telephone" name="telephone" value="<c:out value="${utilisateur.telephone}"/>" size="20" maxlength="60" />
						</div>
						<div class ="button">	
							<button id="button" class="btn" type ="submit">Creer</button>	
						</div>
		    		</form>
		    		</div>
               	</fieldset>
        	</div>
       	</div>
    </body>
</html>
