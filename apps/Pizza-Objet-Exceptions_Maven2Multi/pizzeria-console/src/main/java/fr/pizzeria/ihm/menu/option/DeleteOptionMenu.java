package fr.pizzeria.ihm.menu.option;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.tools.IhmTools;


@TagOptionMenu
public class DeleteOptionMenu extends OptionMenu {

	@Override
	public void libelle() {

		System.out.println("4. Supprimer une pizza");

	}

	@Override
	public boolean execute(IhmTools ihmTools) {

		String choix;
		System.out.println("Veuillez donner le code de la pizza à supprimer");
		choix = ihmTools.getScanner().next();

		try {
			ihmTools.getDaoImpl().delete(choix);
		} catch (DaoException e) {
			Logger.getAnonymousLogger().log(Level.INFO, " Pas supprimable, car pas de bonne reference",e); 
		}

		return true;
	}
}
