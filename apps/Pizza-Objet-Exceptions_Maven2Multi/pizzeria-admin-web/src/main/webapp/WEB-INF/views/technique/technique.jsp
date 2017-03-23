<!DOCTYPE html>

<%@page import="fr.pizzeria.modele.Pizza"%>
<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>

<link href="../bootstrapL/css/bootstrap.min.css" rel="stylesheet">
<link href="CSS/listerPizza.css" rel="stylesheet">

<meta charset="utf-8">

<title>Ma Pizzeria</title>

</head>


<body>



	<div class="container">

		<h1>Operateur Technique</h1>

	    Nombre de sessions ouvertes : ${applicationScope.compteur}		

		


	</div>

</body>

</html>