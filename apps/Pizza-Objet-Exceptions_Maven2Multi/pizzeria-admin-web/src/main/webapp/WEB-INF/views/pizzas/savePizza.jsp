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


		
		<form method="post" >
		<label for="newcode">Code :</label>
		<input id="newcode" name="newcode" type="text" placeholder="Code" >
		
		<label for="ref">Nom :</label>
		<input id="ref" name="ref" type="text" placeholder="Nom" >
		
		<label for="prix">Prix : </label>
		<input id="prix" name="prix" type="text" placeholder="prix" >
		
		<label for="categorie">Categorie :</label>
		<input id="categorie" name="categorie" type="text" placeholder="categorie" >
		
		<input type="submit" value="Valider">
		</form>
		


	</div>

</body>

</html>