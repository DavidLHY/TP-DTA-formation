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

		<form method="post">
			<label for="admin"> Identifiant : </label> <input id="admin" name="admin" type="text"> 
				<label for="pwd">Mot de	passe :</label>
				 <input id="pwd" name="pwd" type="text"> 
				 <input	type="submit" value="Valider">
		</form>



	</div>

</body>

</html>