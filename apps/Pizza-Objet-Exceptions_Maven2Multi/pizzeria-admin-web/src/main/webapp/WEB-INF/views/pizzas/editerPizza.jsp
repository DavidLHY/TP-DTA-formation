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

	<h1>Edition de la référence </h1>
	<div>


		<%
			Pizza pizza = (Pizza) request.getAttribute("editPizzas");
		%>
		<form method="post" >
		<label for="newcode">Code :</label>
		<input id="newcode" name="newcode" type="text" value=<%=pizza.getCode() %>>
		
		<label for="ref">Nom :</label>
		<input id="ref" name="ref" type="text" value=<%= pizza.getNom() %>>
		
		<label for="prix">Prix : </label>
		<input id="prix" name="prix" type="text" value=<%=pizza.getPrix() %> >
		
		<label for="categorie">Categorie :</label>
		<input id="categorie" name="categorie" type="text" value=<%= pizza.getCategoriePizza().name() %> >
		
		<input type="submit" value="Valider">
		</form>
		


	</div>

</body>

</html>