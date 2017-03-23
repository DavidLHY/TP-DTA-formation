package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.IPizzaDaoJPA;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;


@WebServlet("/pizzas/edit")
public class EditerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Inject private PizzaService pizzaService;
	
	private String code;
	public EditerPizzaController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.code = request.getParameter("code");
		
		Set<Object> setCategorie = pizzaService.findCat("categoriePizza");
		
		
		
		request.setAttribute("editPizza", pizzaService.findby("code",this.code).iterator().next());
		request.setAttribute("categoriePizza", setCategorie);
		
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp");

		dispatcher.forward(request, response);

		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String newcode = request.getParameter("newcode");
		String ref = request.getParameter("ref");
		String prix= request.getParameter("prix");
		String categorie = request.getParameter("categorie");
		
		Pizza pizza = new Pizza(newcode, ref, Double.valueOf(prix), CategoriePizza.valueOf(categorie));
		
		pizzaService.update(this.code,pizza);
		
		response.sendRedirect(request.getContextPath() + "/pizzas/list");
		
	}
	

	
}
