package fr.pizzeria.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.dao.repos.IngredientRepository;
import fr.pizzeria.modele.Ingredient;

@Controller
@RequestMapping("/ingredients")
public class SendIngredientController {

	@Autowired private IngredientRepository ingredientJPA;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView sendIngredient(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		 
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ingredient/listerIngredient");
		mav.addObject("listIngr", ingredientJPA.findAll());
		Ingredient ingredient = new Ingredient();
		ingredient.setNom("Mon iddd");
		mav.addObject("ingredient", ingredient);

		return mav;

	}
	

	
}
