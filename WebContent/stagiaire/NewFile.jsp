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
        <title>Liste des questionnaires</title>
        <link type="text/css" rel="stylesheet" href='<c:url value="/inc/style.css"/>' />
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
				<div class="col-sm-2">
					<button id="button" class="button_nav" class="btn"><a href='<c:url value="voirListeQuestionnaires" />'>Retour</a></button>
				</div>
				<div class="col-sm-2">
					<button id="button" class="button_nav" class="btn"><a href='<c:url value="deconnexion" />'>Deconnexion</a></button>
				</div>		
			</div>
		</nav><br>
		<div class="container-fluid">
			<div class="table-responsive">
				
    				<form method="post" action="repondreQuestion">
		    			<c:forEach items="${questions}" var="question">
		    				<div class="row bord">
								<div class="col-sm-9 row">
									<div class="col-sm-5">
										<label class="lab1">Question ${question.getId()}</label><br>
										
									</div>
									<div class="col-sm-7" >
									
										<label class="lab2"><c:out value="${question.getLibelle()}" /></label><br>
						    			<c:forEach items="${question.getReponse()}" var="reponse">
										<input class = "radioButton" type="radio"  name="${reponse.getIdQuestion()}" value ="${reponse.getLibelle()}"><label class="lab2"><c:out value="${reponse.getLibelle()}" /></label><br>
						    			</c:forEach>
									</div>
									<div>
										
									</div>
								</div>
							</div><hr/>
		    			</c:forEach>
		    			<div class="col-sm-offset-5 col-sm-6">
							<button id="button" class="button_nav" class="btn" type ="submit">Valider</a></button>
						</div>	
					</form>
				</div>
			</div>
			
	
</body>
</html>
