package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.IPizzaDaoJPA;
import fr.pizzeria.modele.Pizza;


public class ListerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao<Pizza, String> daoserv = new IPizzaDaoJPA();
    
    public ListerPizzaController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	request.setAttribute("listPizzas", daoserv.findAll());
    	
    	
    	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/listerPizza.jsp");
    	
    	dispatcher.forward(request, response);
    	

    	
    	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

  

}
