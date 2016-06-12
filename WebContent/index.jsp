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
        <title>Page de connexion</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <header class="text-center">
		<div class="head"><p>Evaluation stagiaire</p></div>
	</header>
    <body>
        <div class="container-fluid text-center tab-content"><br/><br/>
			<div class ="consigne">Saisir votre mail et mot de passe de connexion</div><br/>
			<div class ="iform">
				<fieldset>	
					<div id="iform">
           			<form class="iform"class="content" method="post" action="<c:url value="/connexion" />">
           				<div class ="champ">	
							<label class="lab">Mail:</label>
							<input type="email" class="input" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
						</div>
						<div class ="champ">	
							<label class="lab">Mot de passe:</label>
							<input type="password" class="input" id="mdp" name="motdepasse" value="" size="20" maxlength="20" />	
						</div>
						<div class ="errors">
							<span class="erreur">${form.erreurs['email']}</span>		
							<span class="erreur">${form.erreurs['motdepasse']}</span>
						</div>
						<div class ="button">	
							<button id="button" class="btn" type ="submit">Connexion</button>	
						</div>
                 
 
		               	<%-- <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p> --%>
		               	
		               	<%-- Vérification de la présence d'un objet utilisateur en session --%>
		               	<%-- <c:if test="${!empty sessionScope.sessionUtilisateur}"> --%>
		                   	<%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
		                   	<%-- <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>--%>
		               	<%--</c:if> --%>
		    		</form>
		    		</div>
               	</fieldset>
               </div>
               </div>
       	</div>
    </body>
</html>

