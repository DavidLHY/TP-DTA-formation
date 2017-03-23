package fr.pizzeria.admin.metier;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import java.util.Set;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import fr.pizzeria.admin.web.event.DeletePizzaEvent;
import fr.pizzeria.admin.web.event.SavePizzaEvent;
import fr.pizzeria.admin.web.event.UpdatePizzaEvent;
import fr.pizzeria.dao.Dao;

import fr.pizzeria.modele.Pizza;

public class PizzaService {

	private LocalDateTime localTime;

	@Inject	private Dao<Pizza, String> pizzaDao;
	
	@Inject private Event<SavePizzaEvent> savePizzaEvent;
	@Inject private Event<UpdatePizzaEvent> updatePizzaEvent;
	@Inject private Event<DeletePizzaEvent> deletePizzaEvent;
	
	public List<Pizza> findAll() {
		return pizzaDao.findAll();
	}

	public Set<Pizza> findby(String string, String code) {

		return pizzaDao.findby(string, code);

	}

	public void save(Pizza pizza) {

		pizzaDao.save(pizza);
		
		SavePizzaEvent event = new SavePizzaEvent();
		event.setLocalTime(LocalDateTime.now());
		event.setPizza(pizza);
		savePizzaEvent.fire(event);
		

	}

	public Set<Object> findCat(String string) {

		return pizzaDao.findCat(string);
		
		

	}

	public void update(String code, Pizza pizza) {

		pizzaDao.update(code, pizza);
		
		UpdatePizzaEvent event = new UpdatePizzaEvent();
		event.setLocalTime(LocalDateTime.now());
		event.setPizza(pizza);
		updatePizzaEvent.fire(event);
		
	}

	public void delete(String code) {
		
		Pizza pizza = pizzaDao.findby("code",code).iterator().next();
		pizzaDao.delete(code);
		
		DeletePizzaEvent event = new DeletePizzaEvent();
		event.setLocalTime(LocalDateTime.now());
		event.setPizza(pizza);
		deletePizzaEvent.fire(event);
		
		
	}
	
	
	
	

}
