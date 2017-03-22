<!DOCTYPE html>

<%@page import="fr.pizzeria.modele.Pizza"%>
<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<input id="newcode" name="newcode" type="text" value="${editPizza.code}" >
		
		<label for="ref">Nom :</label>
		<input id="ref" name="ref" type="text" value="${editPizza.nom}">
		
		<label for="prix">Prix : </label>
		<input id="number" name="prix" type="number" value="${editPizza.prix}" >
		
		<label for="categorie">Categorie :</label>
		<input id="categorie" name="categorie" type="text" value="${editPizza.categoriePizza.name()}"  >
		
		 
		
		
		<input type="submit" value="Valider">
		</form>
		


	</div>

</body>

</html>