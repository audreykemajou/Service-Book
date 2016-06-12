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
		<script src='<c:url value="pagination.js"/>'></script>
		
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/u/bs/dt-1.10.12/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdn.datatables.net/u/bs/dt-1.10.12/datatables.min.js"></script>
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
   				<form method="post" action="repondreQuestionnaire">
   					<table>
           				   <tr>
				    			<td>
				    				<label class="lab1">Question ${question.getOrdre()}</label><br>
						        </td>
						        <td>
			            			<label class="lab2"><c:out value="${question.getLibelle()}" /></label><br>
			            			<c:forEach items="${question.getReponse()}" var="reponse">
										<input type="radio" class = "radioButton"  name="${reponse.getIdQuestion()}" value ="${reponse.getLibelle()}"><label class="lab2"><c:out value="${reponse.getLibelle()}" /></label><br>
	    							</c:forEach>
	    							<input type="text" class="hidden"  name="index" value ="${index}">
						        </td>   
					     	</tr>
					    </tbody>
					</table>
					<br>
					<c:choose>
						<c:when test="${index == questions.size()-1}">
							<div class="button">
								<button id="button" class="btn" type ="submit">Valider</a></button>
							</div>
						</c:when>
						<c:otherwise>
							<div class="button">
								<button id="button" class="btn" type ="submit">Suivant</button>
							</div>
						</c:otherwise>
					</c:choose>
				</form>
			</div>
		</div>
	</body>
</html>


