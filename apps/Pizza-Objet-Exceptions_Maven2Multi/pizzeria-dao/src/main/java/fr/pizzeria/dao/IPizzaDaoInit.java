package fr.pizzeria.dao;


import java.util.List;

import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public class IPizzaDaoInit extends DaoPizza {

		 

	public IPizzaDaoInit() {
	
		listOfPizza.add(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		listOfPizza.add(new Pizza(2, "REI", "Reine", 11.50, CategoriePizza.SANS_VIANDE));
		listOfPizza.add(new Pizza(3, "FRO", "4Fromage", 12.00, CategoriePizza.SANS_VIANDE));
		listOfPizza.add(new Pizza(4, "CAN", "Cannibale", 12.50, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza(5, "SAV", "Savoyarde", 13.00, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza(6, "ORI", "Orientale", 13.50, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza(7, "SAU", "Saumon", 14.00, CategoriePizza.POISSON));
	}

	// unused
	@Override
	public void save(List<Pizza> listOfPizza) {

	}



	
}
