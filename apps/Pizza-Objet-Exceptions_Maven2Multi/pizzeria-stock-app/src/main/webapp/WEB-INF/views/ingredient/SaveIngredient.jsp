<!DOCTYPE html>

<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page import="java.util.Map"%>
<%@page import="fr.pizzeria.modele.Ingredient"%>
<%@page import="java.util.List"%>


<html>

<head>

<link href="../bootstrapL/css/bootstrap.min.css" rel="stylesheet">

<meta charset="utf-8">

<title>Ma Pizzeria</title>

</head>

<body>


	<div class="container">
		<div class="jumbotron">
			<h1>Liste des Ingredients</h1>
		</div>

		<form:form method="post" modelAttribute="ingredient">
			<table>
				<tr>
					<td>Nom</td>
					<td><form:input path="nom" /></td>
				</tr>

				<tr>
					<td>Prix</td>
					<td><form:input path="prix" /></td>
				</tr>
				<tr>
					<td>Quantite</td>
					<td><form:input path="quantite" /></td>
				</tr>

			</table>


		</form:form>


	</div>

</body>

</html>