package dta;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.dao.repos.IngredientRepository;
import fr.pizzeria.modele.Ingredient;

@Controller
@RequestMapping("page/ingredients")
public class SendIngredientController {

	@Autowired private IngredientRepository ingredientJPA;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView sendIngredient(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("ingredients/listerIngredient");
		mav.addObject("listIngr", ingredientJPA.findAll());
		Ingredient ingredient = new Ingredient();
		mav.addObject("ingredient", ingredient);

		return mav;

	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public String saveIngredient(@ModelAttribute("ingredient") Ingredient ingr) {
		
			
		ingredientJPA.save(ingr);
		
		return "redirect:/page/ingredients";
	}
	

	@RequestMapping(value="delete/{id}", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN" )
	public String saveIngredient(@PathVariable Integer id) {
		
		
		ingredientJPA.deleteById(id);
		
		return "redirect:/page/ingredients";
	}
	
	
	@RequestMapping(value="edit/{id}", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN" )
	public ModelAndView getupdateIngredient(Model model, @PathVariable Integer id) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ingredients/EditIngredient");
		mav.addObject("oldIngredient", ingredientJPA.findById(id));
		model.addAttribute("newIngredient",new Ingredient());
		
		return mav;
		
		
	
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "edit/{id}")
	@Secured("ROLE_ADMIN")
	public String postEdit(@PathVariable Integer id, @ModelAttribute("oldIngredient") Ingredient ingredient) {
		ingredientJPA.updateById(id, ingredient);
		return "redirect:/page/ingredients";
	}
	
}
