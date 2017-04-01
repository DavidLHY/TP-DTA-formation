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
<link href="../CSS/listerPizza.css" rel="stylesheet">

<meta charset="utf-8">

<title>Ma Pizzeria</title>

</head>

<body>


	<div class="container">
		<div class="jumbotron">
			<h1>Liste des Ingredients</h1>
		</div>
		<div class="containers">
			<div class="row" style="height: 300px; overflow-y: auto;">
				<table class="table table-striped">
					<thead>
						<tr>
							<th class="col-md-3">Nom</th>
							<th class="col-md-3">Prix</th>
							<th class="col-md-3">Quantite</th>
							<th class="col-md-3"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listIngr}" var="ingr">
							<tr>
								<td>${ingr.nom}</td>
								<td>${ingr.prix}</td>
								<td>${ingr.quantite}</td>
								<td><a
									href=<c:url value='/mvc/ingredients/edit/${ingr.id}'/>
									class="btn btn-info"><span class="glyphicon glyphicon-edit"></span>
										Editer </a> <a id="button"
									href=<c:url value='/mvc/ingredients/delete/${ingr.id}'/>
									class="btn btn-danger"><span
										class="glyphicon glyphicon-trash"></span> Supprimer </a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
		<div class="containers">

			<form:form method="post" modelAttribute="ingredient">

				<div class="form-group">
					<label>Nom :</label>
					<form:input class="form-control" path="nom" placeholder="Nom" />
				</div>
				<div class="form-group">
					<label>Prix : </label>
					<form:input class="form-control" path="prix" placeholder="Prix"
						type="number" step="0.01" />
				</div>
				<div class="form-group">
					<label>Quantite :</label>
					<form:input class="form-control" path="quantite"
						placeholder="Quantite" type="number" />
				</div>


				<button class="btn btn-success" type="submit">Ajouter</button>
			</form:form>

		</div>
	</div>


</body>

</html>