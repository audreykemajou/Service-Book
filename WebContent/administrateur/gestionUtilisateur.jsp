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
        <title>Gestion Utilisateur</title>
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
					<div class="col-sm-6">
						<input class="nom_nav" type ="email" placeholder="Email" name= "email">
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
					<c:when test="${!empty user}">
		    			<div class="row bord">
							<div class="col-sm-3 row">
								<div class="col-sm-5">
									<label class="lab1">Nom</label><br>
									<label class="lab1">Email</label><br>
									<label class="lab1">Mot de passe</label><br>
								</div>
								<div class="col-sm-7">
									<label class="lab2"><c:out value="${user.getNom()}" /></label><br>
									<label class="lab2"><a class =mail href = "mailto :<?=$v['mail']; ?>"><c:out value="${user.getEmail()}" /></a></label><br>
									<label class="lab2"><c:out value="${user.getMotDePasse()}" /></label><br>
								</div>
							</div>
							<div class="col-sm-3 row">
								<div class="col-sm-5">
									<label class="lab1">Prenom</label><br>
									<label class="lab1">Societe</label><br>
									<label class="lab1">Type</label><br>
								</div>
								<div class="col-sm-7">
									<label class="lab2"><c:out value="${user.getPrenom()}" /></label><br>
									<label class="lab2"><c:out value="${user.getSociete()}" /></label><br>
									<label class="lab2">									
										<c:choose>
										    <c:when test="${user.getAdmin()==1}">
										    	<c:out value="Administrateur" />
										    </c:when>
										    <c:otherwise>
										    	<c:out value="Stagiaire" />
										    </c:otherwise>
										</c:choose>
									</label><br>
								</div>
							</div>
							<div class="col-sm-3 row">
								<div class="col-sm-5">
									<label class="lab1">Téléphone</label><br>
									<label class="lab1">Statut</label><br>
								</div>
								<div class="col-sm-7">
									<label class="lab2"><c:out value="${user.getTelephone()}" /></label><br>
									<label class="lab2">									
											<c:choose>
											    <c:when test="${user.getStatut()==1}">
											    	<c:out value="Actif" />
											    </c:when>
											    <c:otherwise>
											    	<c:out value="Inactif" />
											    </c:otherwise>
											</c:choose>
										</label><br>
								</div>
							</div>
							<div class="col-sm-3">
								<button id="button" class="button_nav" class="btn"><a href="<c:url value="modifierUtilisateur" ><c:param name="id" value="${user.getId()}"/></c:url>">Modifier</a></button>
								<button id="button" class="button_nav" class="btn"><a href="<c:url value="supprimerUtilisateur" ><c:param name="id" value="${user.getId()}"/></c:url>">Supprimer</a></button>
								<button id="button" class="button_nav" class="btn"><a href="<c:url value="afficherUtilisateur" ><c:param name="id" value="${user.getId()}"/></c:url>">Afficher</a></button>								
							</div>
						</div><br>
					</c:when>
    				<c:when test="${!empty users}">
		    			<c:forEach items="${users}" var="user">
		    				<div class="row bord">
								<div class="col-sm-4 row">
									<div class="col-sm-5">
										<label class="lab1">Nom</label><br>
										<label class="lab1">Email</label><br>
										<label class="lab1">Mot de passe</label><br>
									</div>
									<div class="col-sm-7">
										<label class="lab2"><c:out value="${user.getNom()}" /></label><br>
										<label class="lab2"><a class =mail href = "mailto :<?=$v['mail']; ?>"><c:out value="${user.getEmail()}" /></a></label><br>
										<label class="lab2"><c:out value="${user.getMotDePasse()}" /></label><br>
									</div>
								</div>
								<div class="col-sm-3 row">
									<div class="col-sm-5">
										<label class="lab1">Prenom</label><br>
										<label class="lab1">Societe</label><br>
										<label class="lab1">Type</label><br>
									</div>
									<div class="col-sm-7">
										<label class="lab2"><c:out value="${user.getPrenom()}" /></label><br>
										<label class="lab2"><c:out value="${user.getSociete()}" /></label><br>
										<label class="lab2">									
										<c:choose>
										    <c:when test="${user.getAdmin()==1}">
										    	<c:out value="Administrateur" />
										    </c:when>
										    <c:otherwise>
										    	<c:out value="Stagiaire" />
										    </c:otherwise>
										</c:choose>
									</label><br>
									</div>
								</div>
								<div class="col-sm-3 row">
									<div class="col-sm-5">
										<label class="lab1">Téléphone</label><br>
										<label class="lab1">Statut</label><br>
									</div>
									<div class="col-sm-7">
										<label class="lab2"><c:out value="${user.getTelephone()}" /></label><br>
										<label class="lab2">									
											<c:choose>
											    <c:when test="${user.getStatut()==1}">
											    	<c:out value="Actif" />
											    </c:when>
											    <c:otherwise>
											    	<c:out value="Inactif" />
											    </c:otherwise>
											</c:choose>
										</label><br>
										
									</div>
								</div>
								<div class="col-sm-2">
									<button id="button" class="button_nav" class="btn"><a href="<c:url value="modifierUtilisateur" ><c:param name="id" value="${user.getId()}"/></c:url>">Modifier</a></button>
									<button id="button" class="button_nav" class="btn"><a href="<c:url value="supprimerUtilisateur" ><c:param name="id" value="${user.getId()}"/></c:url>">Supprimer</a></button>
									<button id="button" class="button_nav" class="btn"><a href="<c:url value="afficherUtilisateur" ><c:param name="id" value="${user.getId()}"/></c:url>">Afficher</a></button>
								</div>
							</div><br>
		    			</c:forEach>
					</c:when>
				</c:choose>
			</div>
			<div class="col-sm-offset-5 col-sm-6">
				<button id="button" class="button_nav" class="btn"><a href="<c:url value="administrateur/creerUtilisateur.jsp" />">Creer utilisateur</a></button>
			</div>
		</div>
    </body><br><hr/>
</html>