<!DOCTYPE html>

<%@page import="fr.pizzeria.modele.Pizza"%>
<%@page import="java.util.List"%>
<html>

<head>


      <link href="listerPizza.css" rel="stylesheet"> 

<meta charset="utf-8">

<title>Ma Pizzeria</title>

</head>

<body>

<div>
<h1> Liste des pizzas</h1>

<%
List<Pizza> pizzas =(List<Pizza>) request.getAttribute("listPizzas");
%>
<ul>
<%for(Pizza current: pizzas) { %>
	<li> <%= current.toString() %></li>
 <%}%>
</ul>

</div>

</body>

</html>