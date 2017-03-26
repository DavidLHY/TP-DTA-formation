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
		<div class="jumbotron">
			<h1>Technique</h1>
			<h2>Nombre de sessions ouvertes : ${nbSession}</h2>
		</div>

		<div class="row">
			<div class="col-md-6">

				<table class="table table-striped">
					<thead>
						<tr>
							<th>Temps</th>
							<th>Chemin</th>
						</tr>
					</thead>

					<c:forEach var="val" items="${tempsReq}" varStatus="status">
						<tr>
							<td>${val} [ms]</td>
							<td>${cheminReq[status.index]}</td>
						</tr>

					</c:forEach>
				</table>


			</div>

			<div class="col-md-6">
				Pizzas ajoutees :
				<table class="table table-striped">
					<thead>
						<tr>
							<th align="left">Code</th>
							<th align="left">Description</th>
							<th align="left">Prix</th>
							<th align="left">Categorie</th>
							<th aligne="left">Date</th>
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
							<th aligne="left">Date</th>
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
							<th aligne="left">Date</th>
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





		</div>

		<a href=<c:url value='/pizzas/list'/> ><button type="button"
				class="btn btn-primary">Retour</button></a>

	</div>




</body>

</html>