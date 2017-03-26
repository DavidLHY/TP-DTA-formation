<!DOCTYPE html>

<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.Map"%>
<%@page import="fr.pizzeria.modele.CategoriePizza"%>
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


	<div class="container">
		<div class="jumbotron">
			<h1>Liste des Pizzas</h1>
		</div>
		<div class="panel panel-primary">
			<!-- Default panel contents -->

			<c:forEach var="entry" items="${listPizzas.entrySet()}">

				<div class="panel-heading">
					<h4>${entry.getKey().toString()}</h4>
				</div>

				<table class="table table-striped">

					<tr id="">
						<td class="col-md-2">Code</td>
						<td class="col-md-2">Nom</td>
						<td class="col-md-2">Prix</td>
						<td class="col-md-2">Images</td>
						<td class="col-md-2"></td>
					</tr>


					<c:forEach var="current" items="${entry.getValue()}">


						<tr>
							<td>${current.code}</td>
							<td>${current.nom}</td>
							<td>${current.prix}</td>
							<td></td>

							<td><a
								href=<c:url value='/pizzas/edit?code=${current.code}'/>
								class="btn btn-info"><span
									class="glyphicon glyphicon-edit"></span> Editer </a> <a
								id="button"
								href=<c:url value='/pizzas/delete?code=${current.code}'/>
								class="btn btn-danger"><span
									class="glyphicon glyphicon-trash"></span> Supprimer </a></td>
						</tr>

					</c:forEach>
				</table>
			</c:forEach>


		</div>

		<div id="button">

			<a id="button" href=<c:url value='/pizzas/save'/>
				class="btn btn-success"><span class="glyphicon glyphicon-ok"></span>
				Ajouter</a> <a id="button" href=<c:url value='/logout'/>
				class="btn btn-danger"><span class="glyphicon glyphicon-log-out"></span>
				LogOut</a> <a id="button" href=<c:url value='/technique'/>
				class="btn btn-primary"><span class="glyphicon glyphicon-list"></span>
				Technique</a>


		</div>

		<div id="button"></div>

	</div>

</body>

</html>