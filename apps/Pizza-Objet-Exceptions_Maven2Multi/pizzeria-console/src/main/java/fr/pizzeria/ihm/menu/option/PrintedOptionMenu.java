package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.ihm.tools.IhmTools;

@TagOptionMenu
public class PrintedOptionMenu implements OptionMenu {

	@Override
	public void libelle() {

		System.out.println("1. Lister les pizzas");

	}

	@Override
	public boolean execute(IhmTools ihmTools) {

		for (int i = 0; i < ihmTools.getiPizza().findAllPizzas().size(); i++) {
			ihmTools.getiPizza().findAllPizzas().get(i).printPizza();
		}
		System.out.println("\n" + ihmTools.getiPizza().findAllPizzas().size() + " Pizzas restantes \n");
		return true;
	}
}
