<!DOCTYPE html>

<%@page import="fr.pizzeria.modele.Pizza"%>
<%@page import="java.util.List"%>
<html>

<head>

<link href="../bootstrapL/css/bootstrap.min.css" rel="stylesheet">
<link href="../CSS/listerPizza.css" rel="stylesheet">

<meta charset="utf-8">

<title>Ma Pizzeria</title>

</head>

<body>

	
	<div>
		<h1>Liste des pizzas</h1>

		<%
			List<Pizza> pizzas = (List<Pizza>) request.getAttribute("listPizzas");
		%>

		<%
			for (Pizza current : pizzas) {
		%>
		<div id="listPizza">
			<%=current.toString()%> <a id="button" href="http://localhost:8080/pizzeria-admin-web/pizzas/edit?code=<%=current.getCode()%>"  class="btn btn-info"><span class="glyphicon glyphicon-th-list"></span> Editer </a>
			 <a id="button" href="http://localhost:8080/pizzeria-admin-web/pizzas/delete?code=<%=current.getCode()%>" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span>  Supprimer </a>
			
		</div>
		<%
			}
		%>
		<div id="button">
			
			 <a id="button" href="http://localhost:8080/pizzeria-admin-web/pizzas/save" class="btn btn-success"><span class="glyphicon glyphicon-ok"></span> Ajouter</a>
			
		</div>


	</div>

</body>

</html>