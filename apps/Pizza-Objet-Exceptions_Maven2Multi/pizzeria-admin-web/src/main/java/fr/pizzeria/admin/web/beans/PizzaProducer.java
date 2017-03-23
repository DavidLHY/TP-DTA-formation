package fr.pizzeria.admin.web.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.IPizzaDaoJPA;
import fr.pizzeria.modele.Pizza;

public class PizzaProducer {
	
	
	
	@Produces
	@ApplicationScoped
	public Dao<Pizza,String>  pizzaDao(){
		
		return new IPizzaDaoJPA();
	}


}
