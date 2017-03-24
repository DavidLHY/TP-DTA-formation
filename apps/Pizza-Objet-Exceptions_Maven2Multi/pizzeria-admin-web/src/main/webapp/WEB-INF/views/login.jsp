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
		<h1>Login</h1>
		<div class="white">
			<form method="post">
				<div class="form-group">
					<label for="admin"> Identifiant : </label> <input id="admin"
						class="form-control" name="admin" type="text">
				</div>
				<div class="form-group">
					<label for="pwd">Mot de passe :</label> <input id="pwd" name="pwd"
						class="form-control" type="text">
				</div>
				<input class="btn btn-primary" type="submit" value="Valider">
			</form>
		</div>


	</div>

</body>

</html>