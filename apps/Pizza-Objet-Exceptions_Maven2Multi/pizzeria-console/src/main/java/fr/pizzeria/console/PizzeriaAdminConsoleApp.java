package fr.pizzeria.console;


import java.util.logging.Level;

import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.tools.IhmTools;

public class PizzeriaAdminConsoleApp {
	
	private PizzeriaAdminConsoleApp(){}

	
	public static void main(String[] args) {

		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		
		IhmTools ihmTools = new IhmTools();
		
		Menu menu = new Menu();
		menu.actionmenu(ihmTools);
	}
}
