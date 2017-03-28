package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.modele.Pizza;

@TagOptionMenu
public class PrixMaxOptionMenu extends OptionMenu {

	
	private Dao<Pizza,String> dao;
	
		
	public PrixMaxOptionMenu(Dao<Pizza, String> dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void libelle() {
		System.out.println("6 - Afficher la pizza au tarif le plus élevé");

	}

	@Override
	public boolean execute() {

		System.out.println("La pizza la plus cher est:");
		dao.findAll().stream().max(Comparator.comparing(Pizza::getPrix)).get().printPizza();

		return false;
	}

}
