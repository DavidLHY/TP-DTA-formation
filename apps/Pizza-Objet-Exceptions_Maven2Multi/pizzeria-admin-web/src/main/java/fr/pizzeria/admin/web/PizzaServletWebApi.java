package fr.pizzeria.admin.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;


@WebServlet("/api/servlet/pizzas")
public class PizzaServletWebApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	@Inject private PizzaService pizzaService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append(pizzaService.findAll().toString() + "\n");

	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		String prix = request.getParameter("prix");
		String categoriePizza = request.getParameter("categorie");

		try {
			pizzaService.save(new Pizza(code, nom, Double.valueOf(prix), CategoriePizza.valueOf(categoriePizza)));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
	
	


}
