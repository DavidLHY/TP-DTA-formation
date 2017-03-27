var API_PIZZA="http://localhost:8080/pizzeria-admin-web/api/rest/pizzas";

$(document).ready(function()
{
	$.ajax( API_PIZZA, {
	}).then(function(data){

		var bodyLines= data.map(function(pizza){
			var linePizza ='<div class="col-md-4">'
			+'<img class="pizzas" src="Images/Pizzas/'+pizza.code+'.jpg" width=150px>'
			+ '<h3>'+pizza.nom +'</h3>'
			+ '<h4>'+pizza.prix +' euros </h4>'

			+ '</div>';

			return linePizza;
		});

		
		$('.pizzas').html(bodyLines); 


	});

});