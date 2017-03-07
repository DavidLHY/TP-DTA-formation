package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

@TagOptionMenu
public class DeleteOptionMenu extends OptionMenu {

	@Override
	public void libelle() {

		System.out.println("4. Supprimer une pizza");

	}

	@Override
	public boolean execute(IhmTools ihmTools) {

		String choix;
		System.out.println("Veuillez donner le code de la pizza � supprimer");
		choix = ihmTools.getScanner().next();

		try {
			ihmTools.getiPizza().delete(choix);
			Pizza.setNbpizzas(ihmTools.getiPizza().findAllPizzas().size());
		} catch (DaoException e) {
			System.out.println(" Pas supprimable, car pas de bonne reference");
		}

		return true;
	}
}
