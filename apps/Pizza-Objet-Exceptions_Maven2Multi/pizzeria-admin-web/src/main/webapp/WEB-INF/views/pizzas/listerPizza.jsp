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

	<%!
	 void supprimer(String code)
	{
		
		//request.setAttribute("supprimerPizza", code);
	}
	
	%>

	<div>
		<h1>Liste des pizzas</h1>

		<%
			List<Pizza> pizzas = (List<Pizza>) request.getAttribute("listPizzas");
		%>

		<%
			for (Pizza current : pizzas) {
		%>
		<div id="listPizza">
			<%=current.toString()%> <button id="button" > Editer </button> <button id="button" onclick="supprimer(<%=current.getCode() %>)"> Supprimer </button>
			
		</div>
		<%
			}
		%>


	</div>

</body>

</html>