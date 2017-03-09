package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;

import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

@TagOptionMenu
public class PrixMaxOptionMenu implements OptionMenu {

	@Override
	public void libelle() {
		System.out.println("6 - Afficher la pizza au tarif le plus élevé");

	}

	@Override
	public boolean execute(IhmTools ihmTools) {

		System.out.println("La pizza la plus cher est:");
		ihmTools.getiPizza().findAllPizzas().stream().max(Comparator.comparing(Pizza::getPrix)).get().printPizza();

		return false;
	}

}
