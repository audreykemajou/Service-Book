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
        <title>Modification annonce</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <header class="text-center">
		<div class="head"><p>Creation Annuaire</p></div>
	</header>
    <body>
        <div class="container-fluid text-center tab-content"><br/><br/>
			<div class ="consigne">Modifier les informations concernant l'annonce</div><br/>
			<div class ="form">
				<fieldset>	
					<div id="form">
           			<form class="form"class="content" method="post" action="<c:url value="/modifierAnnonce" />">
           				<div class ="champ">	
							<label class="lab">Categorie:</label>
							<input type="text" class="input" id="nom" name="categorie" disabled="disabled" value="${categorie['titre']}" disabled="disabled" size="20" maxlength="60" />
						</div>
						<div class ="champ hidden">	
							<label class="lab">Categorie:</label>
							<input type="text" class="input" id="nom" name="idCategorie" value="${categorie['id']}" size="20" maxlength="60" />
						</div>
						<div class ="champ hidden">	
							<label class="lab">idAnnonce:</label>
							<input type="text" class="input" id="nom" name="idAnnonce" value="${annonce['id']}" size="20" maxlength="60" />
						</div>
           				<div class ="champ">	
							<label class="lab">Nom:</label>
							<input type="text" class="input" id="nom" name="nom" value="${annonce['nom']}" size="20" maxlength="60" />
						</div>
						<div class ="champ">	
							<label class="lab">Telephone:</label>
							<input type="text" class="input" id="nom" name="telephone" value="${annonce['telephone']}" size="20" maxlength="60" />
						</div>
						<div class ="champ">	
							<label class="lab">Rue:</label>
							<input type="text" class="input" id="nom" name="rue" value="${adresse['rue']}" size="20" maxlength="60" />
						</div>
						<div class ="champ">	
							<label class="lab">Ville:</label>
							<input type="text" class="input" id="nom" name="ville" value="${adresse['ville']}" size="20" maxlength="60" />
						</div>
						<div class ="champ">	
							<label class="lab">Code_postal:</label>
							<input type="text" class="input" id="nom" name="code_postal" value="${adresse['code_postal']}" size="20" maxlength="60" />
						</div>					
						<div class ="button">	
							<button id="button" class="btn" type ="submit">Modifier annonce</button>	
						</div>
		    		</form>
		    		</div>
               	</fieldset>
        	</div>
       	</div>
    </body>
</html>
