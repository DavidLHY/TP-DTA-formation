package fr.pizzeria.admin.metier;



import java.time.LocalDateTime;

import java.util.List;

import java.util.Set;

import javax.ejb.EJB;
import javax.enterprise.event.Event;

import javax.inject.Inject;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import fr.pizzeria.admin.web.event.DeletePizzaEvent;
import fr.pizzeria.admin.web.event.SavePizzaEvent;
import fr.pizzeria.admin.web.event.UpdatePizzaEvent;


import fr.pizzeria.modele.Pizza;


public class PizzaService {



	@EJB private PizzaServiceEJB pizzaEJB;
	
	
	@Inject private Event<SavePizzaEvent> savePizzaEvent;
	@Inject private Event<UpdatePizzaEvent> updatePizzaEvent;
	@Inject private Event<DeletePizzaEvent> deletePizzaEvent;
	

	public List<Pizza> findAll() {
		return pizzaEJB.findAll();
		
	}

	
	public Set<Pizza> findby(String string, String code) {

		return pizzaEJB.findby(string, code);

	}

	public void save(Pizza pizza) throws MySQLIntegrityConstraintViolationException {

		pizzaEJB.save(pizza);
		
		SavePizzaEvent event = new SavePizzaEvent();
		event.setLocalTime(LocalDateTime.now());
		event.setPizza(pizza);
		savePizzaEvent.fire(event);
		

	}

	public Set<Object> findCat(String string) {

		return pizzaEJB.findCat(string);
		
		

	}

	public void update(String code, Pizza pizza) {

		pizzaEJB.update(code, pizza);
		
		UpdatePizzaEvent event = new UpdatePizzaEvent();
		event.setLocalTime(LocalDateTime.now());
		event.setPizza(pizza);
		updatePizzaEvent.fire(event);
		
	}

	public void delete(String code) {
		
		Pizza pizza = pizzaEJB.findby("code",code).iterator().next();
		pizzaEJB.delete(code);
		
		DeletePizzaEvent event = new DeletePizzaEvent();
		event.setLocalTime(LocalDateTime.now());
		event.setPizza(pizza);
		deletePizzaEvent.fire(event);
		
		
	}
	
	
	
	

}
