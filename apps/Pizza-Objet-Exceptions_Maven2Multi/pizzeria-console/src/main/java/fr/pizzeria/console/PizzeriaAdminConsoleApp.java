package fr.pizzeria.console;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.tools.IhmTools;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Menu menu = new Menu();

		IhmTools ihmTools = new IhmTools();

		menu.actionmenu(ihmTools);

	}
}
