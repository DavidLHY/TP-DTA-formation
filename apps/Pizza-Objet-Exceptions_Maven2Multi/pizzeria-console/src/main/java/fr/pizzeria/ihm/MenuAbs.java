package fr.pizzeria.ihm;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.ihm.menu.option.OptionMenu;

public abstract class MenuAbs {

	protected String titre = "***** Pizzeria Administration *****";
	protected Scanner scanner;
	

	protected Map<Integer, OptionMenu> listOptions = new TreeMap<Integer, OptionMenu>();
	
	
public MenuAbs(String titre, Scanner scanner, Map<Integer, OptionMenu> listOptions) {
		
		this.titre = titre;
		this.scanner = scanner;
		this.listOptions = listOptions;
	}

	public void actionmenu() {

		int choix = 0;
		do {
			this.printMenu();
			try {
				choix = scanner.nextInt();
				this.listOptions.get(choix).execute();
			} catch (NullPointerException e) {
		       Logger.getAnonymousLogger().log(Level.INFO, "Choix indisponible",e); 
			} catch (InputMismatchException e) {
				Logger.getAnonymousLogger().log(Level.INFO, "Saisie Incorrecte",e); 
				scanner.next();
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
