

	$.get("http://localhost:8080/rest/ingredients", function(obj) {
			
			var htmls = obj.map(function(data){
				return "<div>" + data.nom + "</div>";
			})
		
			$(".listIngr").html(htmls);
			
	});
