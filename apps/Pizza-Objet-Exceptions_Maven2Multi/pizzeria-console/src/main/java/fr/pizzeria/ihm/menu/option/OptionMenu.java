package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.ihm.tools.IhmTools;

public interface OptionMenu {

	public abstract void libelle();

	public abstract boolean execute(IhmTools ihmTools);

}
