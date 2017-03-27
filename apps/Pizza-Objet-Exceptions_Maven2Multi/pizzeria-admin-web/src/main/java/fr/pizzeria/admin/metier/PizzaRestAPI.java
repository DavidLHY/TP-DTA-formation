package fr.pizzeria.admin.metier;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.modele.Pizza;

@Path("/pizzas")
public class PizzaRestAPI {

	@EJB
	private PizzaServiceEJB pizzaEJB;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> findAll() {
		return pizzaEJB.findAll();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(Pizza pizza) {

		
		try {
			pizzaEJB.save(pizza);
		} catch (SQLException e) {
			e.getMessage();
		}		
		

	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
    public void update(String code, Pizza pizza) {
		
		pizzaEJB.update(code, pizza);		
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void delete(String code) {
		
		pizzaEJB.delete(code);
		
	}
	
}
