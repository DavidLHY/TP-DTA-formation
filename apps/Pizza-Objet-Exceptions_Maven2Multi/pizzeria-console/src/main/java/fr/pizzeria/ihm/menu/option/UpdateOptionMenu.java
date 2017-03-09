package fr.pizzeria.ihm.menu.option;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.option.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public class UpdateOptionMenu extends OptionMenu {

	@Override
	public void libelle() {
		System.out.println("3. Mettre à jour une pizza");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {

		String choix;
		
		System.out.println("Veuillez donner le code de la pizza à changer");
		choix = ihmTools.getScanner().next();
		
		Pizza pizza = saisirPizza(ihmTools);		

		

		try {
			ihmTools.getiPizza().update(choix, pizza);
		} catch (DaoException e) {
			Logger.getAnonymousLogger().log(Level.INFO, "Code pizza non existant",e);
		}
		return true;
	}
}
