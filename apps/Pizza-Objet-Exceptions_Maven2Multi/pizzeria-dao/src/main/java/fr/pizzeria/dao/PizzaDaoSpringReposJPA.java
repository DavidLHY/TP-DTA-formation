package fr.pizzeria.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.pizzeria.dao.repos.IPizzaRepository;
import fr.pizzeria.modele.Pizza;

@Repository("springDataJPA")
public class PizzaDaoSpringReposJPA implements Dao<Pizza, String> {

	@Autowired private IPizzaRepository pizzaRepository;
	
	
	
	@Override
	public List<Pizza> findAll()
	{
	 return pizzaRepository.findAll();
	}
	
	@Override
	public boolean save(Pizza pizza) {
		
		pizzaRepository.save(pizza);		
		
		return false;
	}

	@Override
	public boolean update(String t, Pizza pizza) {
		
		Pizza pmodi = pizzaRepository.getOne(t);
		
		pizza.setId(pmodi.getId());		
		pizzaRepository.save(pizza);
		
		
		return false;
	}

	@Override
	public boolean delete(String t) {

		pizzaRepository.delete(t);
		
		return false;
	}

}
