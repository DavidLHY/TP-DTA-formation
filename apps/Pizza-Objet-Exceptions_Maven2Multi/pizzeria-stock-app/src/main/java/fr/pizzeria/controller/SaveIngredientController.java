package fr.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.pizzeria.dao.repos.IngredientRepository;
import fr.pizzeria.modele.Ingredient;

@Controller
@RequestMapping("/ingredients")
public class SaveIngredientController {

	@Autowired private IngredientRepository ingredientJPA;

	
	@RequestMapping(method = RequestMethod.POST)
	public String saveIngredient(@ModelAttribute("ingredient") Ingredient ingr) {
		
			
		ingredientJPA.save(ingr);
		
		return "redirect:/mvc/ingredients";
	}

	
}
