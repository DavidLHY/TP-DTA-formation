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
		
		<div class="form-group">
				<label for="categorie">Categorie : </label>
				<select id="categorie" class="form-control" name="categorie">
					<c:forEach var="current" items="${categoriePizza}">
						<c:choose>
						<c:when test="${editPizza.categoriePizza.name().equals(current.name())}">
							<option selected value="${current}">${current.name()}</option>
						</c:when>
						<c:otherwise>
							<option  value="${current}">${current.name()}</option>
						</c:otherwise>	
						</c:choose>
						
					</c:forEach>
				</select>
			</div>
		<input type="submit" value="Valider">
		</form>
		


	</div>

</body>

</html>