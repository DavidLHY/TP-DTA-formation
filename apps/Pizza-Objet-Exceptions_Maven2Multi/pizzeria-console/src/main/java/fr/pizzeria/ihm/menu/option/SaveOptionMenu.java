package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public class SaveOptionMenu extends OptionMenu {

	private Scanner scanner;
	private Dao<Pizza,String> dao;
	
	

	public SaveOptionMenu(Scanner scanner, Dao<Pizza, String> dao) {
		this.scanner = scanner;
		this.dao = dao;
	}

	@Override
	public void libelle() {

		System.out.println("2. Ajouter une nouvelle pizza");

	}

	@Override
	public boolean execute() {

		Pizza pizza = new Pizza();	

		
		System.out.println("Veuiller donner le nouveau code");
		pizza.setCode(scanner.next());
		System.out.println("Veuiller donner le nouveau nom");
		pizza.setNom(scanner.next());
		System.out.println("Veuiller donner le nouveau Prix");
		pizza.setPrix(scanner.nextDouble());
		System.out.println("Veuiller donner le nouveau type de pizza:");	
		
		int cat = 1;
		for (CategoriePizza current : CategoriePizza.values()) {

			System.out.println(cat + " - " + current);
			cat++;
		}
		cat = scanner.nextInt();		
		pizza.setCategoriePizza(CategoriePizza.values()[cat - 1]);
		
		

		try {
			dao.save(pizza);
		} catch (DaoException e) {
			Logger.getAnonymousLogger().log(Level.INFO, "Code pizza déjà existant",e);
		}

		return true;
	}

}
