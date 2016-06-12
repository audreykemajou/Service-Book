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
        <title>Afficher Question</title>
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
				<form class="navbar-form form_col" method = "post" action = "<c:url value="/afficherQuestion" />">
					<div class="col-sm-6">
						<input class="nom_nav" type ="text" placeholder="Sujet" name= "sujet">
					</div>
					<div class="col-sm-2">
						<button id="button" class="button_nav" class="btn" type ="submit">Rechercher</button>
					</div>
					<div class="col-sm-2">
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="afficherQuestionnaire"><c:param name="id" value="${question.getIdQuestionnaire()}"/></c:url>">Retour</a></button>
					</div>
					<div class="col-sm-2">
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="deconnexion" />">Deconnexion</a></button>
					</div>	
				</form>
				
			</div>
		</nav><br>
		<div class="container-fluid">
			<div class="table-responsive">
				<c:choose>
    				<c:when test="${!empty reponses}">
		    			<c:forEach items="${reponses}" var="reponse">
		    				<div class="row bord">
								<div class="col-sm-9 row">
									<div class="col-sm-5">
										<label class="lab1">Question</label><br>
										<label class="lab1">Reponse</label><br>
										<label class="lab1">Bonne</label><br>
										<label class="lab1">Statut</label><br>
										<label class="lab1">Ordre</label><br>
									</div>
									<div class="col-sm-7">
										<label class="lab2"><c:out value="${question.getLibelle()}" /></label><br>
										<label class="lab2"><c:out value="${reponse.getLibelle()}" /></label><br>
										<label class="lab2">
											<c:choose>
											    <c:when test="${reponse.getBonne()==1}">
											    	<c:out value="Bonne reponse" />
											    </c:when>
											    <c:otherwise>
											    	<c:out value="Mauvaise réponse" />
											    </c:otherwise>
											</c:choose>
										</label><br>									
										<label class="lab2">									
											<c:choose>
											    <c:when test="${reponse.getStatut()==1}">
											    	<c:out value="Actif" />
											    </c:when>
											    <c:otherwise>
											    	<c:out value="Inactif" />
											    </c:otherwise>
											</c:choose>
										</label><br>
										<label class="lab2"><c:out value="${reponse.ordre}" /></label><br>
									</div>
								</div>
								<div class="col-sm-3">
									<button id="button" class="button_nav" class="btn"><a href="<c:url value="modifierReponse" ><c:param name="id" value="${reponse.getId()}"/></c:url>">Modifier</a></button><hr/>
									<button id="button" class="button_nav" class="btn"><a href="<c:url value="supprimerReponse" ><c:param name="id" value="${reponse.getId()}"/></c:url>">Supprimer</a></button>
								</div>
							</div><br>
		    			</c:forEach>
					</c:when>
					<c:when test="${!empty reponse}">
		    			<div class="row bord">
							<div class="col-sm-9 row">
								<div class="col-sm-5">
									<label class="lab1">Question</label><br>
									<label class="lab1">Reponse</label><br>
									<label class="lab1">Bonne</label><br>
									<label class="lab1">Statut</label><br>
									<label class="lab1">Ordre</label><br>
								</div>
								<div class="col-sm-7">
									<label class="lab2"><c:out value="${question.getLibelle()}" /></label><br>
									<label class="lab2"><c:out value="${reponse.getLibelle()}" /></label><br>
									<label class="lab2">
										<c:choose>
										    <c:when test="${reponse.getBonne()==1}">
										    	<c:out value="Bonne réponse" />
										    </c:when>
										    <c:otherwise>
										    	<c:out value="Mauvaise réponse" />
										    </c:otherwise>
										</c:choose>
									</label><br>									
									<label class="lab2">									
										<c:choose>
										    <c:when test="${reponse.getStatut()==1}">
										    	<c:out value="Actif" />
										    </c:when>
										    <c:otherwise>
										    	<c:out value="Inactif" />
										    </c:otherwise>
										</c:choose>
									</label><br>
									<label class="lab2"><c:out value="${reponse.ordre}" /></label><br>									
								</div>
							</div>
							<div class="col-sm-3">
								<button id="button" class="button_nav" class="btn"><a href="<c:url value="modifierReponse" ><c:param name="id" value="${reponse.getId()}"/></c:url>">Modifier</a></button><hr/>
								<button id="button" class="button_nav" class="btn"><a href="<c:url value="supprimerReponse" ><c:param name="id" value="${reponse.getId()}"/></c:url>">Supprimer</a></button>
							</div>
						</div><br>
					</c:when>
				</c:choose>
			</div>
			<div class="col-sm-offset-5 col-sm-6">
				<button id="button" class="button_nav" class="btn"><a href="<c:url value="creerReponse" ><c:param name="id" value="${question.getId()}"/></c:url>">Creer réponse</a></button>
			</div>
		</div>
    </body><br><hr/>
</html>