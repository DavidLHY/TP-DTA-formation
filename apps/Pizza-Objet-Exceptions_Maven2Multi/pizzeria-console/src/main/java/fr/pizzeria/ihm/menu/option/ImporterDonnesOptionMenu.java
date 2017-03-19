package fr.pizzeria.ihm.menu.option;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.tools.IhmTools;

public class ImporterDonnesOptionMenu extends OptionMenu {

	@Override
	public void libelle() {

		System.out.println("7. Importer des pizzas");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {

		try {
			ihmTools.getDaoImpl().importData(ihmTools.getDaoSource());
		} catch (DaoException e) {
			Logger.getAnonymousLogger().log(Level.INFO, "Import Failed",e);
		}

		return false;
	}

}
