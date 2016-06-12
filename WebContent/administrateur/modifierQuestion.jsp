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
        <title>Modification question</title>
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
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="afficherQuestionnaire"><c:param name="id" value="${question.getIdQuestionnaire()}"/></c:url>">Retour</a></button>
					</div>
					<div class="col-sm-2">
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="/deconnexion" />">Deconnexion</a></button>
					</div>	
				
			</div>
		</nav><br>
        <div class="container-fluid text-center tab-content"><br/><br/>
			<div class ="consigne">Modifier les informations concernant la question</div><br/>
			<div class ="iform">
				<fieldset>	
					<div id="iform">
           			<form class="iform"class="content" method="post" action="<c:url value="/modifierQuestion" />">
           				<div class ="champ">	
							<label class="lab">Sujet:</label>
							<input type="text" class="input" id="nom" name="sujet" disabled="disabled" value="${questionnaire.sujet}" disabled="disabled" size="20" maxlength="60" />
						</div>
						<div class ="champ hidden">	
							<label class="lab">Sujet:</label>
							<input type="text" class="input" id="nom" name="sujet" value="${questionnaire.sujet}" size="20" maxlength="60" />
						</div>
						<div class ="champ hidden">	
							<label class="lab">idQuestion:</label>
							<input type="text" class="input" id="nom" name="id" value="${question.id}" size="20" maxlength="60" />
						</div>
						<div class ="champ hidden">	
							<label class="lab">idQuestionnaire:</label>
							<input type="text" class="input" id="nom" name="idQuestionnaire" value="${questionnaire.id}" size="20" maxlength="60" />
						</div>
           				<div class ="champ">	
							<label class="lab">Libelle:</label>
							<input type="text" class="input" id="nom" name="libelle" value="${question.getLibelle()}" size="20" maxlength="60" />
						</div>
						<div class ="champ">	
							<label class="lab">Ordre:</label>
							<input type="text" class="input" id="nom" name="ordre" value="${question.getOrdre()}" size="20" maxlength="60" />
						</div>					
						<div class ="button">	
							<button id="button" class="btn" type ="submit">Modifier questions</button>	
						</div>
		    		</form>
		    		</div>
               	</fieldset>
        	</div>
       	</div>
    </body>
</html>
