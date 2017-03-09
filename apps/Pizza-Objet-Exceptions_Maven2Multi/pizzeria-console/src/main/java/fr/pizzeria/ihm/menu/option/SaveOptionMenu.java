package fr.pizzeria.ihm.menu.option;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.option.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public class SaveOptionMenu extends OptionMenu {

	@Override
	public void libelle() {

		System.out.println("2. Ajouter une nouvelle pizza");

	}

	@Override
	public boolean execute(IhmTools ihmTools) {

		Pizza pizza = saisirPizza(ihmTools);	

		int cat = 1;
		for (CategoriePizza current : CategoriePizza.values()) {

			System.out.println(cat + " - " + current);
			cat++;
		}

		cat = ihmTools.getScanner().nextInt();
		pizza.setCategoriePizza(CategoriePizza.values()[cat - 1]);

		pizza.setId(ihmTools.getiPizza().findAllPizzas().size());
		try {
			ihmTools.getiPizza().save(pizza);
		} catch (DaoException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "Code pizza déjà existant",e);
		}

		return true;
	}

}
