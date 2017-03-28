package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.modele.Pizza;

@TagOptionMenu
public class PrintedOptionMenu extends OptionMenu {

	
	private Dao<Pizza,String> dao;
	
	

	public PrintedOptionMenu(Dao<Pizza, String> dao) {
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
