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
        <title>Modifier questionnaire</title>
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
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="/gestionQuestionnaire" />">Retour</a></button>
					</div>
					<div class="col-sm-2">
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="/deconnexion" />">Deconnexion</a></button>
					</div>
				
			</div>
		</nav><br>
        <div class="container-fluid text-center tab-content"><br/><br/>
			<div class ="consigne">Modifier les informations concernant le questionnaire</div><br/>
			<div class ="iform">
				<fieldset>	
					<div id="iform">
           			<form class="iform"class="content" method="post" action="<c:url value="modifierQuestionnaire" ><c:param name="id" value="${questionnaire.getId()}"/></c:url>">
           				<div class ="champ">	
							<label class="lab">Sujet:</label>
							<input type="text" class="input" id="sujet" name="sujet" value="<c:out value="${questionnaire.getSujet()}"/>" size="20" maxlength="60" />
						</div>
						<div class ="button">	
							<button id="button" class="btn" type ="submit">Modifier questionnaire</button>	
						</div>
		    		</form>
		    		</div>
               	</fieldset>
        	</div>
       	</div>
    </body>
</html>
