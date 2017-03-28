package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

@Component
public class UpdateOptionMenu implements OptionMenu {

	private Scanner scanner;	
	private Dao<Pizza, String> dao;

	@Autowired
	public UpdateOptionMenu(Scanner scanner,@Qualifier("pizzaP") Dao<Pizza, String> dao) {

		this.scanner = scanner;
		this.dao = dao;
	}

	@Override
	public void libelle() {
		System.out.println("3. Mettre à jour une pizza");
	}

	@Override
	public boolean execute() {

		String choix;

		System.out.println("Veuillez donner le code de la pizza à changer");
		choix = scanner.next();

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
			dao.update(choix, pizza);
		} catch (DaoException e) {
			Logger.getAnonymousLogger().log(Level.INFO, "Code pizza non existant", e);
		}
		return true;
	}
}
