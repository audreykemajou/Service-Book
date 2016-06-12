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
        <title>Modifier categorie</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <header class="text-center">
		<div class="head"><p>Creation Annuaire</p></div>
	</header>
    <body>    
        <div class="container-fluid text-center tab-content"><br/><br/>
			<div class ="consigne">Modifier les informations concernant la catégorie</div><br/>
			<div class ="iform">
				<fieldset>	
					<div id="iform">
           			<form class="iform"class="content" method="post" action="<c:url value="modifierCategorie" ><c:param name="id" value="${categorie['id']}"/></c:url>">
           				<div class ="champ">	
							<label class="lab">Titre:</label>
							<input type="text" class="input" id="titre" name="titre" value="<c:out value="${categorie['titre']}"/>" size="20" maxlength="60" />
						</div>
						<div class ="button">	
							<button id="button" class="btn" type ="submit">Modifier categorie</button>	
						</div>
		    		</form>
		    		</div>
               	</fieldset>
        	</div>
       	</div>
    </body>
</html>
