package fr.pizzeria.ihm.menu.option;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.menu.option.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.CategoriePizza;
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

		int cat = 1;
		for (CategoriePizza current : CategoriePizza.values()) {

			System.out.println(cat + " - " + current);
			cat++;
		}
		cat = ihmTools.getScanner().nextInt();
		pizza.setCategoriePizza(CategoriePizza.values()[cat - 1]);

		try {
			ihmTools.getiPizza().update(choix, pizza);
		} catch (DaoException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "Code pizza non existant",e);
		}
		return true;
	}
}
