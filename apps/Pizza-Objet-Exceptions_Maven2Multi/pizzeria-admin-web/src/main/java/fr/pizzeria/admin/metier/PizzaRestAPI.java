package fr.pizzeria.admin.metier;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.web.event.SavePizzaEvent;
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

		pizzaEJB.save(pizza);		
		

	}
}
