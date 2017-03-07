package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;

import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public class PrixMaxOptionMenu extends OptionMenu {

	@Override
	public void libelle() {
		System.out.println("6 - Afficher la pizza au tarif le plus �lev�");

	}

	@Override
	public boolean execute(IhmTools ihmTools) {

		System.out.println("La pizza la plus cher est:");
		ihmTools.getiPizza().findAllPizzas().stream().max(Comparator.comparing(Pizza::getPrix)).get().printPizza();

		return false;
	}

}
