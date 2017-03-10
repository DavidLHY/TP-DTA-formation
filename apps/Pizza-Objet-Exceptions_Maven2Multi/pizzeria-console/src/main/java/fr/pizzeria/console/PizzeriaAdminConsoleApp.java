package fr.pizzeria.console;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.tools.IhmTools;

public class PizzeriaAdminConsoleApp {
	
	private PizzeriaAdminConsoleApp(){}

	
	public static void main(String[] args) {

		IhmTools ihmTools = new IhmTools();
		
		Menu menu = new Menu();
		menu.actionmenu(ihmTools);
	}
}
