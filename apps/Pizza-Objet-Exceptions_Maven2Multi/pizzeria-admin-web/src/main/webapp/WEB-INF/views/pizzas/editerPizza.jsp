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

		<div class="jumbotron">
			<h1>Edition de la référence ${editPizza.code}</h1>
		</div>
		<form method="post">

			<div class="form-group">
				<label for="newcode">Code :</label> <input id="newcode"
					class="form-control" name="newcode" type="text"
					value="${editPizza.code}">
			</div>

			<div class="form-group">
				<label for="ref">Nom :</label> <input id="ref" name="ref"
					class="form-control" type="text" value="${editPizza.nom}">
			</div>

			<div class="form-group">
				<label for="prix">Prix : </label> <input step="0.01" id="number" name="prix"
					class="form-control" type="number" value="${editPizza.prix}">
			</div>


			<div class="form-group">
				<label for="categorie">Categorie : </label> <select id="categorie"
					class="form-control" name="categorie">
					<c:forEach var="current" items="${categoriePizza}">
						<c:choose>
							<c:when
								test="${editPizza.categoriePizza.name().equals(current.name())}">
								<option selected value="${current}">${current.name()}</option>
							</c:when>
							<c:otherwise>
								<option value="${current}">${current.name()}</option>
							</c:otherwise>
						</c:choose>

					</c:forEach>
				</select>
			</div>

			<input class="btn btn-success" type="submit" value="Valider">
			<a href=<c:url value='/pizzas/list'/> ><button type="button"
				class="btn btn-primary">Retour</button></a>
		</form>




	</div>

</body>

</html>