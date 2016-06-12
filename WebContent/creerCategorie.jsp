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
        <title>Creation categorie</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <header class="text-center">
		<div class="head"><p>Creation Annuaire</p></div>
	</header>
    <body>
        <div class="container-fluid text-center tab-content"><br/><br/>
			<div class ="consigne">Remplir les informations concernant la catégorie</div><br/>
			<div class ="iform">
				<fieldset>	
					<div id="iform">
           			<form class="iform"class="content" method="post" action="<c:url value="/creerCategorie" />">
           				<div class ="champ">	
							<label class="lab">Titre:</label>
							<input type="text" class="input" id="titre" name="titre" value="" size="20" maxlength="60" />
						</div>					
						<div class ="button">	
							<button id="button" class="btn" type ="submit">Creer categorie</button>	
						</div>
		    		</form>
		    		</div>
               	</fieldset>
        	</div>
       	</div>
    </body>
</html>
