
package fr.pizzeria.ihm;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import fr.pizzeria.ihm.menu.option.DeleteOptionMenu;
import fr.pizzeria.ihm.menu.option.ExitOptionMenu;
import fr.pizzeria.ihm.menu.option.GroupedPrintedOptionMenu;
import fr.pizzeria.ihm.menu.option.OptionMenu;
import fr.pizzeria.ihm.menu.option.PrintedOptionMenu;
import fr.pizzeria.ihm.menu.option.PrixMaxOptionMenu;
import fr.pizzeria.ihm.menu.option.SaveOptionMenu;
import fr.pizzeria.ihm.menu.option.UpdateOptionMenu;
import fr.pizzeria.ihm.tools.IhmTools;

public class Menu {

	private String titre = "***** Pizzeria Administration *****";

	private Map<Integer, OptionMenu> listOptions = new TreeMap<Integer, OptionMenu>();

	public Menu() {
		listOptions.put(1, new PrintedOptionMenu());
		listOptions.put(2, new SaveOptionMenu());
		listOptions.put(3, new UpdateOptionMenu());
		listOptions.put(4, new DeleteOptionMenu());
		listOptions.put(5, new GroupedPrintedOptionMenu());
		listOptions.put(6, new PrixMaxOptionMenu());
		listOptions.put(99, new ExitOptionMenu());

	}

	public void Actionmenu(IhmTools ihmTools) {

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

}
