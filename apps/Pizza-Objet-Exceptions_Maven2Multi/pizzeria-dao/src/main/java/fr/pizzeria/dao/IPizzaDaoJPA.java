package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.modele.Pizza;

public class IPizzaDaoJPA implements Dao<Pizza, String> {

	EntityManagerFactory em;

	@Override
	public List<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Pizza pizza) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
