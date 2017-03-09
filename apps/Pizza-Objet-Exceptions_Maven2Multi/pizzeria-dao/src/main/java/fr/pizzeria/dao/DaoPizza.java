package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.modele.Pizza;

public abstract class DaoPizza implements Dao<Pizza, String> {
	
	protected List<Pizza> listOfPizza = new ArrayList<>();
	
	@Override
	public List<Pizza> findAllPizzas() {
		return listOfPizza;
	}

	@Override
	public boolean save(Pizza pizza) {

		if (listOfPizza.stream().filter(p -> p.getCode().equals(pizza.getCode())).count() != 0)
			throw new SavePizzaException();

		listOfPizza.add(pizza);

		return true;

	}

	@Override
	public boolean update(String codePizza, Pizza pizza) {

		listOfPizza.removeIf(p -> p.getCode().equals(codePizza));
		listOfPizza.add(pizza);

		return true;
	}

	@Override
	public boolean delete(String codePizza)  {

		listOfPizza.removeIf(p -> p.getCode().equals(codePizza));

		return false;
	}

	public abstract void save(List<Pizza> listOfPizza);
	
	public List<Pizza> getListOfPizza() {
		return listOfPizza;
	}

	public void setListOfPizza(List<Pizza> listOfPizza) {
		this.listOfPizza = listOfPizza;
	}

	
	

}
