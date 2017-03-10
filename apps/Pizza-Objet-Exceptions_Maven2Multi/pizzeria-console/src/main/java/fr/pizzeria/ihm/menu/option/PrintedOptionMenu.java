package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.ihm.tools.IhmTools;

@TagOptionMenu
public class PrintedOptionMenu extends OptionMenu {

	@Override
	public void libelle() {

		System.out.println("1. Lister les pizzas");

	}

	@Override
	public boolean execute(IhmTools ihmTools) {

		for (int i = 0; i < ihmTools.getDaoImpl().findAllPizzas().size(); i++) {
			ihmTools.getDaoImpl().findAllPizzas().get(i).printPizza();
		}
		System.out.println("\n" + ihmTools.getDaoImpl().findAllPizzas().size() + " Pizzas restantes \n");
		return true;
	}
}
