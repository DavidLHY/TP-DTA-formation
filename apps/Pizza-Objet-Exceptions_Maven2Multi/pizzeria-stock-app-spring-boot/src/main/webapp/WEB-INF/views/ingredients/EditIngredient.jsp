<!DOCTYPE html>

<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page import="java.util.Map"%>
<%@page import="fr.pizzeria.modele.Ingredient"%>
<%@page import="java.util.List"%>


<html>

<head>

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

<meta charset="utf-8">

<title>Ma Pizzeria</title>

</head>

<body>


	<div class="container">
		<div class="jumbotron">
			<h1>Editer : ${oldIngredient.nom}</h1>
		</div>


		<form:form method="post" modelAttribute="newIngredient">

			<div class="form-group">
				<label>Nom :</label>
				<form:input class="form-control" path="nom" placeholder="Nom"
					value="${oldIngredient.nom}" />
			</div>
			<div class="form-group">
				<label>Prix : </label>
				<form:input class="form-control" path="prix" placeholder="Prix"
					type="number" step="0.01" value="${oldIngredient.prix}" />
			</div>
			<div class="form-group">
				<label>Quantite :</label>
				<form:input class="form-control" path="quantite"
					placeholder="Quantite" type="number"
					value="${oldIngredient.quantite}" />
			</div>


			<button class="btn btn-success" type="submit">Modifier</button>
		</form:form>


	</div>

</body>

</html>