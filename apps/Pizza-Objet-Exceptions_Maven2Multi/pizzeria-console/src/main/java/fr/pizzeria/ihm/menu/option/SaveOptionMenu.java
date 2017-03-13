package fr.pizzeria.ihm.menu.option;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.option.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public class SaveOptionMenu extends OptionMenu {

	@Override
	public void libelle() {

		System.out.println("2. Ajouter une nouvelle pizza");

	}

	@Override
	public boolean execute(IhmTools ihmTools) {

		Pizza pizza = saisirPizza(ihmTools);	


		try {
			ihmTools.getDaoImpl().save(pizza);
		} catch (DaoException e) {
			Logger.getAnonymousLogger().log(Level.INFO, "Code pizza déjà existant",e);
		}

		return true;
	}

}
