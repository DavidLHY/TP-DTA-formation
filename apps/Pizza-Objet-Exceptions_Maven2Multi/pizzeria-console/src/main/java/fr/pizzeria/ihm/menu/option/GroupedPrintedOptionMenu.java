package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;
import java.util.stream.Collectors;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.modele.Pizza;

public class GroupedPrintedOptionMenu extends OptionMenu {

	
	private Dao<Pizza,String> dao;
	
	

	public GroupedPrintedOptionMenu(Dao<Pizza, String> dao) {
		this.dao = dao;
	}

	@Override
	public void libelle() {
		System.out.println("5 - Lister les pizzas par categorie");

	}

	@Override
	public boolean execute() {

		dao.findAll().stream().collect(Collectors.groupingBy(Pizza::getCategoriePizza))
				.forEach((k, v) -> {
					System.out.println("Dans la categorie " + k.toString() + ":");
					for (Pizza current : v) {
						current.printPizza();
					}

				});

		return false;
	}

}
