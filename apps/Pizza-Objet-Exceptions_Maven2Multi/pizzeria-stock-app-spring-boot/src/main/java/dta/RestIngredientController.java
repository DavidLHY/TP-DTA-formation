package dta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.dao.repos.IngredientRepository;
import fr.pizzeria.modele.Ingredient;

@RestController
@RequestMapping("/rest/ingredients")
public class RestIngredientController {

	@Autowired private IngredientRepository ingredientJPA;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Ingredient> getIngr() {
		return ingredientJPA.findAll(); 
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void postIngr(@RequestBody Ingredient ingr) {
		
		ingredientJPA.save(ingr);
		
	}
	
	
}
