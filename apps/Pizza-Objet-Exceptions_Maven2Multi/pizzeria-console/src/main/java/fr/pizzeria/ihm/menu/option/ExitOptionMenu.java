package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@TagOptionMenu
@Component
public class ExitOptionMenu implements OptionMenu {

	
	private Scanner scanner;
	
	
	@Autowired
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
