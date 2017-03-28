package fr.pizzeria.ihm.menu.option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.modele.Pizza;

@TagOptionMenu
@Component
public class PrintedOptionMenu implements OptionMenu {

	
	private Dao<Pizza,String> dao;
	
	
	@Autowired
	public PrintedOptionMenu(@Qualifier("pizzaP") Dao<Pizza, String> dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void libelle() {

		System.out.println("1. Lister les pizzas");

	}

	@Override
	public boolean execute() {

		for (int i = 0; i < dao.findAll().size(); i++) {
			dao.findAll().get(i).printPizza();
		}
		System.out.println("\n" + dao.findAll().size() + " Pizzas restantes \n");
		return true;
	}
}
