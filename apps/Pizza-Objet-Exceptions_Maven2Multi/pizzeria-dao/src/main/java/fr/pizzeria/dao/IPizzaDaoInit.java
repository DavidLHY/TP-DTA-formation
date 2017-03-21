package fr.pizzeria.dao;


import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public class IPizzaDaoInit implements Dao<Pizza,String> {

	private List<Pizza> listOfPizza = new ArrayList<>();

	public IPizzaDaoInit() {
	
		listOfPizza.add(new Pizza( "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza( "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		listOfPizza.add(new Pizza( "REI", "Reine", 11.50, CategoriePizza.SANS_VIANDE));
		listOfPizza.add(new Pizza( "FRO", "4Fromage", 12.00, CategoriePizza.SANS_VIANDE));
		listOfPizza.add(new Pizza( "CAN", "Cannibale", 12.50, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza( "SAV", "Savoyarde", 13.00, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza( "ORI", "Orientale", 13.50, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza( "SAU", "Saumon", 14.00, CategoriePizza.POISSON));
	}


	@Override
	public List<Pizza> findAll() {
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

	
	public List<Pizza> getListOfPizza() {
		return listOfPizza;
	}

	public void setListOfPizza(List<Pizza> listOfPizza) {
		this.listOfPizza = listOfPizza;
	}



	
}
