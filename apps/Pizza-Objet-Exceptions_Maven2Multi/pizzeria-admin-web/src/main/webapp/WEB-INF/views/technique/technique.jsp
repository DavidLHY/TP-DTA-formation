<!DOCTYPE html>

<%@page import="fr.pizzeria.modele.Pizza"%>
<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>

<link href="bootstrapL/css/bootstrap.min.css" rel="stylesheet">
<link href="CSS/listerPizza.css" rel="stylesheet">

<meta charset="utf-8">

<title>Ma Pizzeria</title>

</head>


<body>
	<div class="container">
		<h1 class="jumbotron">Technique</h1>
		<div>
			<h1>Nombre de sessions ouvertes :
				${applicationScope.sessionCount}</h1>
		</div>
		<div>
			Pizzas ajoutees :
			<table class="table table-striped">
				<thead>
					<tr>
						<th align="left">Code</th>
						<th align="left">Description</th>
						<th align="left">Prix</th>
						<th align="left">Categorie</th>
						<th aligne="left"> Date </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pizzaEvent" items="${stats.savePizzas}">
						<tr>
							<td>${pizzaEvent.pizza.code}</td>
							<td>${pizzaEvent.pizza.nom}</td>
							<td>${pizzaEvent.pizza.prix}</td>
							<td>${pizzaEvent.pizza.categoriePizza}</td>
							<td>${pizzaEvent.localTime}</td>
							<td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			Pizzas modifiees :
			<table class="table table-striped">
				<thead>
					<tr>
						<th align="left">Code</th>
						<th align="left">Description</th>
						<th align="left">Prix</th>
						<th align="left">Categorie</th>
						<th aligne="left"> Date </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pizzaEvent" items="${stats.updatePizzas}">
						<tr>
							<td>${pizzaEvent.pizza.code}</td>
							<td>${pizzaEvent.pizza.nom}</td>
							<td>${pizzaEvent.pizza.prix}</td>
							<td>${pizzaEvent.pizza.categoriePizza}</td>
							<td>${pizzaEvent.localTime}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			Pizzas supprimees :
			<table class="table table-striped">
				<thead>
					<tr>
						<th align="left">Code</th>
						<th align="left">Description</th>
						<th align="left">Prix</th>
						<th align="left">Categorie</th>
						<th aligne="left"> Date </th>
					</tr>
				</thead>
				<c:forEach var="pizzaEvent" items="${stats.deletePizzas}">
					<tr>
						<td>${pizzaEvent.pizza.code}</td>
						<td>${pizzaEvent.pizza.nom}</td>
						<td>${pizzaEvent.pizza.prix}</td>
						<td>${pizzaEvent.pizza.categoriePizza}</td>
						<td>${pizzaEvent.localTime}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<a href="pizzas/list"><button type="button"
				class="btn btn-primary">Retour</button></a>

	</div>
</body>

</html>