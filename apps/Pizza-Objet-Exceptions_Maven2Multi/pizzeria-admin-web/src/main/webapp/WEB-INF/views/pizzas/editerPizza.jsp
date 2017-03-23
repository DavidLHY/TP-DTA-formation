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

		<h1>Edition de la référence</h1>

		<form method="post">

			<div class="form-group">
				<label for="newcode">Code :</label> <input id="newcode"
					class="form-control" name="newcode" type="text" value="${editPizza.code}">
			</div>

			<div class="form-group">
				<label for="ref">Nom :</label> <input id="ref" name="ref"
					class="form-control" type="text" value="${editPizza.nom}">
			</div>

			<div class="form-group">
				<label for="prix">Prix : </label> <input id="number" name="prix"
				class="form-control" 	type="number" value="${editPizza.prix}">
			</div>

			<div class="form-group">
				<label for="categorie">Categorie :</label> <input id="categorie"
				class="form-control"	name="categorie" type="text"
					value="${editPizza.categoriePizza.name()}">
			</div>



			<input type="submit" value="Valider">
		</form>




	</div>

</body>

</html>