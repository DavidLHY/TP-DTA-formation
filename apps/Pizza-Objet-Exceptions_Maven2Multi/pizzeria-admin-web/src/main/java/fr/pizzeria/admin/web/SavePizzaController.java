package fr.pizzeria.admin.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import fr.pizzeria.admin.metier.PizzaService;

import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

@WebServlet("/pizzas/save")
public class SavePizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private PizzaService pizzaService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Set<Object> setCategorie = new TreeSet<>();

		for (CategoriePizza current : CategoriePizza.values()) {
			setCategorie.add(current);
		}

		request.setAttribute("listPizzas", pizzaService.findAll());
		request.setAttribute("categoriePizza", setCategorie);

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/pizzas/savePizza.jsp");

		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String newcode = request.getParameter("newcode");
		String ref = request.getParameter("ref");
		String prix = request.getParameter("prix");
		String categorie = request.getParameter("categorie");

		Pizza pizza = new Pizza(newcode, ref, Double.valueOf(prix), CategoriePizza.valueOf(categorie));
		
		try{
		pizzaService.save(pizza);
		response.sendRedirect(request.getContextPath() + "/pizzas/list");
		}catch(SQLException e){
			System.out.println("coucou");
			/*RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/pizzas/savePizza.jsp");
			dispatcher.forward(request, response);
			request.setAttribute("erreurSave", "Veuillez vérifier votre Saisie (code unique...)");
			doGet(request, response);*/
		}
		

	}

}
