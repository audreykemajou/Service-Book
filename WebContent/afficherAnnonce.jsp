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
        <title>Gestion Annonce</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <header class="text-center">
		<div class="head"><p>Creation Annuaire</p></div>
	</header>
    <body>    
		<div class="container-fluid">
			<div class="table-responsive">
   				<div class="row bord">
					<div class="col-sm-8 row">
						<div class="col-sm-5">
							<label class="lab1">Rue</label><br>
							<label class="lab1">Ville</label><br>
							<label class="lab1">Code Postal</label><br>
						</div>
						<div class="col-sm-7">
							<label class="lab2"><c:out value="${adresse['rue']}" /></label><br>
							<label class="lab2"><c:out value="${adresse['ville']}" /></label><br>
							<label class="lab2"><c:out value="${adresse['code_postal']}" /></label><br>
						</div>
					</div>
					<div class="col-sm-4">
						<button id="button" class="button_nav" class="btn"><a href="<c:url value="modifierAnnonce" ><c:param name="id" value="${idAnnonce}"/></c:url>">Modifier</a></button>
					</div>
				</div><br>
			</div>
		</div>
    </body><br><hr/>
</html>