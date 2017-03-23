package fr.pizzeria.admin.web;

import java.io.IOException;

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
import fr.pizzeria.modele.Pizza;


@WebServlet("/pizzas/delete")
public class DeletePizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject private PizzaService pizzaService;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("code");

		pizzaService.delete(code);
		
		response.sendRedirect(request.getContextPath() + "/pizzas/list");
		
		
		
	}


}
