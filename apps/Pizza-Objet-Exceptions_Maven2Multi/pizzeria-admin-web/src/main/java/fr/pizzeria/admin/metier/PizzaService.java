package fr.pizzeria.admin.metier;


import java.time.LocalDateTime;
import java.util.List;

import java.util.Set;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import fr.pizzeria.admin.web.event.EventAction;
import fr.pizzeria.dao.Dao;

import fr.pizzeria.modele.Pizza;

public class PizzaService {

	private LocalDateTime localTime;
	//@Inject private EventAction eventAction;	

	@Inject	private Dao<Pizza, String> pizzaDao;
	
	@Inject private Event<Pizza> eventPizza;

	public List<Pizza> findAll() {
		return pizzaDao.findAll();
	}

	public Set<Pizza> findby(String string, String code) {

		return pizzaDao.findby(string, code);

	}

	public void save(Pizza pizza) {

		pizzaDao.save(pizza);
		eventPizza.fire(pizza);

	}

	public Set<Object> findCat(String string) {

		return pizzaDao.findCat(string);

	}

	public void update(String code, Pizza pizza) {

		pizzaDao.update(code, pizza);
		
	}
	
	public void savePizzaEvent(@Observes Pizza event) {

		localTime=LocalDateTime.now();
		System.out.println("Pizza Ajout");
		System.out.println(event +"  "+ localTime);

		}
	
	

}
