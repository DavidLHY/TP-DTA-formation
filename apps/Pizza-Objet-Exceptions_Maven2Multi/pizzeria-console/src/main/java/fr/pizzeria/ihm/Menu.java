
package fr.pizzeria.ihm;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import fr.pizzeria.ihm.menu.option.ExitOptionMenu;
import fr.pizzeria.ihm.menu.option.OptionMenu;
import fr.pizzeria.ihm.menu.option.PrintedOptionMenu;
import fr.pizzeria.ihm.menu.option.SaveOptionMenu;

@Component
public class Menu implements MenuAbs {

	
	protected String titre;


	protected Scanner scanner;

	
	protected TreeMap<Integer, OptionMenu> listOptions ;

	@Autowired
	public Menu(String titre, Scanner scanner, TreeMap<Integer, OptionMenu> listOptions) {
		super();
		this.titre = titre;
		this.scanner = scanner;
		this.listOptions = listOptions;
	}
	
	@Autowired private ApplicationContext context;
	
	@PostConstruct
	public void init(){
		this.listOptions = new TreeMap<Integer, OptionMenu>();
		this.listOptions.put(1,context.getBean(PrintedOptionMenu.class));
		this.listOptions.put(2,context.getBean(SaveOptionMenu.class));
		this.listOptions.put(99,context.getBean(ExitOptionMenu.class));
		
	}

	public void actionmenu() {

		int choix = 0;
		do {
			this.printMenu();
			try {
				choix = scanner.nextInt();
				this.listOptions.get(choix).execute();
			} catch (NullPointerException e) {
				Logger.getAnonymousLogger().log(Level.INFO, "Choix indisponible", e);
			} catch (InputMismatchException e) {
				Logger.getAnonymousLogger().log(Level.INFO, "Saisie Incorrecte", e);
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

	public void setListOptions(TreeMap<Integer, OptionMenu> listOptions) {
		this.listOptions = listOptions;
	}

	public String getTitre() {
		return titre;
	}

	public Map<Integer, OptionMenu> getListOptions() {
		return listOptions;
	}

}
