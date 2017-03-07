package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.exception.DaoException;
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

		Pizza pizza = new Pizza();
		System.out.println("Veuillez donner le nouveau code");
		pizza.setCode(ihmTools.getScanner().next());
		System.out.println("Veuillez donner le nouveau nom");
		pizza.setNom(ihmTools.getScanner().next());
		System.out.println("Veuillez donner le nouveau Prix");
		pizza.setPrix(ihmTools.getScanner().nextDouble());
		System.out.println("Veuiller donner type de pizza:");

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
			Pizza.setNbpizzas(ihmTools.getiPizza().findAllPizzas().size());
		} catch (DaoException e) {
			System.out.println(" Code déjà  existant");
		}

		return true;
	}

}
