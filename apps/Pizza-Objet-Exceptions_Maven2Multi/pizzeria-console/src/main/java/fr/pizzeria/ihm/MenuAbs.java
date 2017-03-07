package fr.pizzeria.ihm;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import fr.pizzeria.ihm.menu.option.OptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public abstract class MenuAbs {

	protected String titre = "***** Pizzeria Administration *****";

	protected Map<Integer, OptionMenu> listOptions = new TreeMap<Integer, OptionMenu>();

	public void actionmenu(IhmTools ihmTools) {

		int choix = 0;
		do {
			this.printMenu();
			try {
				choix = ihmTools.getScanner().nextInt();
				this.listOptions.get(choix).execute(ihmTools);
			} catch (NullPointerException e) {
				System.out.println("Choix indisponible Null");
			} catch (InputMismatchException e) {
				System.out.println("Choix indisponible");
				ihmTools.getScanner().next();
			}

		} while (choix != 99);

	}

	public void printMenu() {
		System.out.println(this.titre);

		for (Entry<Integer, OptionMenu> entrySet : listOptions.entrySet()) {
			entrySet.getValue().libelle();

		}
		System.out.println("\n Veullez choisir l'action:");

	}

	public Map<Integer, OptionMenu> getMapOptions() {
		return listOptions;
	}

	public void setListOptions(Map<Integer, OptionMenu> listOptions) {
		this.listOptions = listOptions;
	}

	public String getTitre() {
		return titre;
	}

	public Map<Integer, OptionMenu> getListOptions() {
		return listOptions;
	}

}
