package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.IPizzaDaoJPA;
import fr.pizzeria.modele.Pizza;


@WebServlet("/logout")
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	@Inject private PizzaService pizzaService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	     HttpSession session=request.getSession();  
         session.invalidate();
		
		response.sendRedirect(request.getContextPath() + "/pizzas/list");
		
		
		
	}


}
