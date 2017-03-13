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

		for (int i = 0; i < ihmTools.getDaoImpl().findAll().size(); i++) {
			ihmTools.getDaoImpl().findAll().get(i).printPizza();
		}
		System.out.println("\n" + ihmTools.getDaoImpl().findAll().size() + " Pizzas restantes \n");
		return true;
	}
}
