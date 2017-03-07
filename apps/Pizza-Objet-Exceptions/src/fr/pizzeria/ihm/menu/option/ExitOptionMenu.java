package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.ihm.tools.IhmTools;

public class ExitOptionMenu extends OptionMenu {

	@Override
	public void libelle() {
		System.out.println("99. Fin du programme");

	}

	@Override
	public boolean execute(IhmTools ihmTools) {

		System.out.println("Bonne journée bro!");

		return true;
	}

}
