package fr.pizzeria.ihm.menu.option;

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
		Pizza pizza = new Pizza();
		System.out.println("Veuillez donner le code de la pizza à changer");
		choix = ihmTools.getScanner().next();

		System.out.println("Veuiller donner le nouveau code");
		pizza.setCode(ihmTools.getScanner().next());
		System.out.println("Veuiller donner le nouveau nom");
		pizza.setNom(ihmTools.getScanner().next());
		System.out.println("Veuiller donner le nouveau Prix");
		pizza.setPrix(ihmTools.getScanner().nextDouble());
		System.out.println("Veuiller donner le nouveau type de pizza:");

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
			System.out.println(" Code non existant");
		}
		return true;
	}
}
