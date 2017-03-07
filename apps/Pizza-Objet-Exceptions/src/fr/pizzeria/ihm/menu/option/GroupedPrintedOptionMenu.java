package fr.pizzeria.ihm.menu.option;

import java.util.stream.Collectors;

import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public class GroupedPrintedOptionMenu extends OptionMenu {

	@Override
	public void libelle() {
		System.out.println("5 - Lister les pizzas par categorie");

	}

	@Override
	public boolean execute(IhmTools ihmTools) {

		ihmTools.getiPizza().findAllPizzas().stream().collect(Collectors.groupingBy(Pizza::getCategoriePizza))
				.forEach((k, v) -> {
					System.out.println("Dans la categorie " + k.toString() + ":");
					for (Pizza current : v) {
						current.printPizza();
					}

				});

		return false;
	}

}
