package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public abstract class OptionMenu {

	public abstract void libelle();

	public abstract boolean execute(IhmTools ihmTools);
	
	public Pizza saisirPizza(IhmTools ihmTools)
	{
		Pizza pizza = new Pizza();
		System.out.println("Veuiller donner le nouveau code");
		pizza.setCode(ihmTools.getScanner().next());
		System.out.println("Veuiller donner le nouveau nom");
		pizza.setNom(ihmTools.getScanner().next());
		System.out.println("Veuiller donner le nouveau Prix");
		pizza.setPrix(ihmTools.getScanner().nextDouble());
		System.out.println("Veuiller donner le nouveau type de pizza:");		
		
		return pizza;
	}

}
