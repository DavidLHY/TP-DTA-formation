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

	
	<div class="container">

<h1>Edition de la référence </h1>
		
		<form method="post" >
		<label for="newcode">Code :</label>
		<input class="form-control" id="newcode" name="newcode" type="text" placeholder="Code" >
		
		<label for="ref">Nom :</label>
		<input class="form-control" id="ref" name="ref" type="text" placeholder="Nom" >
		
		<label for="prix">Prix : </label>
		<input class="form-control" id="prix" name="prix" type="text" placeholder="prix" >
		
		<label for="categorie">Categorie :</label>
		<input class="form-control" id="categorie" name="categorie" type="text" placeholder="categorie" >
		
		<input type="submit" value="Valider">
		</form>
		


	</div>

</body>

</html>