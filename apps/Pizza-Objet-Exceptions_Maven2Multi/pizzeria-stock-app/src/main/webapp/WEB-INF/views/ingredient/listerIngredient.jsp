<!DOCTYPE html>

<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page import="java.util.Map"%>
<%@page import="fr.pizzeria.modele.Ingredient"%>
<%@page import="java.util.List"%>


<html>

<head>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="../CSS/listerPizza.css" rel="stylesheet">

<meta charset="utf-8">

<title>Ma Pizzeria</title>

</head>

<body>


	<div class="container">
		<div class="jumbotron">
			<h1>Liste des Ingredients</h1>
		</div>
		<div>
		
			
			<table>
				<thead>
				<th> Nom </th> <th> Prix</th> <th> Quantite </th>
				</thead>
				<c:forEach items="${listIngr}" var="ingr">
				<tr> 
			<td>${ingr.nom} </td><td>${ingr.prix}</td><td>${ingr.quantite}</td>
			</tr>
		       </c:forEach>
			</table>

		</div>
		<div>

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

				<button type="submit">Ajouter</button>
			</form:form>

		</div>
	</div>


</body>

</html>