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
        <title>Gestion Annuaire</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <header class="text-center">
		<div class="head"><p>Creation Annuaire</p></div>
	</header>
    <body>    
		<div class="container-fluid">
			<div class="table-responsive">
    				<c:if test="${!empty titres}">
		    			<c:forEach items="${titres}" var="titre" varStatus="status">
		    				<div class="row bord">
								<div class="col-sm-8 row">
									<div class="col-sm-5">
										<label class="lab1">Titre</label><br>
									</div>
									<div class="col-sm-7">
										<label class="lab2"><c:out value="${titre}" /></label><br>
									</div>
								</div>
								<div class="col-sm-4">
									<button id="button" class="button_nav" class="btn"><a href="<c:url value="modifierCategorie" ><c:param name="id" value="${ids[status.count-1]}"/></c:url>">Modifier</a></button>
									<button id="button" class="button_nav" class="btn"><a href="<c:url value="supprimerCategorie" ><c:param name="id" value="${ids[status.count-1]}"/></c:url>">Supprimer</a></button>
									<button id="button" class="button_nav" class="btn"><a href="<c:url value="afficherCategorie" ><c:param name="id" value="${ids[status.count-1]}"/></c:url>">Afficher</a></button>
								</div>
							</div><br>
		    			</c:forEach>
					</c:if>
			</div>
			<div class="col-sm-offset-5 col-sm-6">
				<button id="button" class="button_nav" class="btn"><a href="<c:url value="creerCategorie.jsp" />">Creer categorie</a></button>
			</div>
		</div>
    </body><br><hr/>
</html>