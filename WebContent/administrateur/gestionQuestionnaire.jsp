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
		<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
		<link href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" rel="stylesheet">
        <title>Gestion Questionnaire</title>
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
				<form class="navbar-form form_col" method = "post" action = "<c:url value="/gestionQuestionnaire" />">
					<div class="col-sm-6">
						<input class="nom_nav" type ="text" placeholder="Sujet" name= "sujet">
					</div>
					<div class="col-sm-2">
						<button id="button" class="button_nav" class="btn" type ="submit">Rechercher</button>
					</div>
					<div class="col-sm-2">
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="/administrateur/administrateur.jsp" />">Retour</a></button>
					</div>
					<div class="col-sm-2">
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="/deconnexion" />">Deconnexion</a></button>
					</div>	
				</form>
				
			</div>
		</nav><br>
		<div class="container-fluid">
			<div class="table-responsive">
				<c:choose>
					
    				<c:when test="${!empty questionnaires}">
		    			<c:forEach items="${questionnaires}" var="questionnaire" varStatus="status">
		    				<div class="row bord">
								<div class="col-sm-4 row">
									<div class="col-sm-5">
										<label class="lab1">Sujet</label><br>
									</div>
									<div class="col-sm-7">
										<label class="lab2"><c:out value="${questionnaire.getSujet()}" /></label><br>
									</div>
								</div>
								<div class="col-sm-3 row">
									<div class="col-sm-5">
										<label class="lab1">Statut</label><br>
									</div>
									<div class="col-sm-7">
										<label class="lab2">									
											<c:choose>
											    <c:when test="${questionnaire.getStatut() == 1}">
											    	<c:out value="Actif" />
											    </c:when>
											    <c:otherwise>
											    	<c:out value="Inactif" />
											    </c:otherwise>
											</c:choose>
										</label><br>
									</div>
								</div>
								<div class="col-sm-3 row">
									<div class="col-sm-5">
										<label class="lab1">Createur</label><br>
									</div>
									<div class="col-sm-7">
										<label class="lab2"><c:out value="${users[status.count - 1].getNom()}" /></label><br>
									</div>
								</div>
								<div class="col-sm-2">
									<button id="button" class="button_nav" class="btn"><a href="<c:url value="modifierQuestionnaire" ><c:param name="id" value="${questionnaire.getId()}"/></c:url>">Modifier</a></button>
									<button id="button" class="button_nav" class="btn"><a href="<c:url value="supprimerQuestionnaire" ><c:param name="id" value="${questionnaire.getId()}"/></c:url>">Supprimer</a></button>
									<button id="button" class="button_nav" class="btn"><a href="<c:url value="afficherQuestionnaire" ><c:param name="id" value="${questionnaire.getId()}"/></c:url>">Afficher</a></button>
								</div>
							</div><br>
		    			</c:forEach>
					</c:when>
					<c:when test="${!empty questionnaire}">
		    			<div class="row bord">
							<div class="col-sm-4 row">
								<div class="col-sm-5">
									<label class="lab1">Sujet</label><br>
								</div>
								<div class="col-sm-7">
									<label class="lab2"><c:out value="${questionnaire.getSujet()}" /></label><br>
								</div>
							</div>
							<div class="col-sm-3 row">
								<div class="col-sm-5">
									<label class="lab1">Statut</label><br>
								</div>
								<div class="col-sm-7">
									<label class="lab2">									
										<c:choose>
										    <c:when test="${questionnaire.getStatut()==1}">
										    	<c:out value="Actif" />
										    </c:when>
										    <c:otherwise>
										    	<c:out value="Inactif" />
										    </c:otherwise>
										</c:choose>
									</label><br>
								</div>
							</div>
							<div class="col-sm-3 row">
								<div class="col-sm-5">
									<label class="lab1">Createur</label><br>
								</div>
								<div class="col-sm-7">
									<label class="lab2"><c:out value="${user.getNom()}" /></label><br>
								</div>
							</div>
							<div class="col-sm-2">
								<button id="button" class="button_nav" class="btn"><a href="<c:url value="modifierQuestionnaire" ><c:param name="id" value="${questionnaire.getId()}"/></c:url>">Modifier</a></button>
								<button id="button" class="button_nav" class="btn"><a href="<c:url value="supprimerQuestionnaire" ><c:param name="id" value="${questionnaire.getId()}"/></c:url>">Supprimer</a></button>
								<button id="button" class="button_nav" class="btn"><a href="<c:url value="afficherQuestionnaire" ><c:param name="id" value="${questionnaire.getId()}"/></c:url>">Afficher</a></button>
							</div>
						</div><br>
					</c:when>
				</c:choose>
			</div>
			<div class="col-sm-offset-5 col-sm-6">
				<button id="button" class="button_nav" class="btn"><a href="<c:url value="administrateur/creerQuestionnaire.jsp" />">New questionnaire</a></button>
			</div>
		</div>
    </body><br><hr/>
</html>