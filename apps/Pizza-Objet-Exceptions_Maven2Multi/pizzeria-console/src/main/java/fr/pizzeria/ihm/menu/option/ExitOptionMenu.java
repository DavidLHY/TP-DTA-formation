package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

@TagOptionMenu
public class ExitOptionMenu extends OptionMenu {

	private Scanner scanner;
	
	
	
	public ExitOptionMenu(Scanner scanner) {
	
		this.scanner = scanner;
	}

	@Override
	public void libelle() {
		System.out.println("99. Fin du programme");

	}

	@Override
	public boolean execute() {

		System.out.println("Bonne journée bro!");
		scanner.close();
		System.exit(0);
		return true;
	}

}
