package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.DaoException;

import fr.pizzeria.modele.Pizza;


@TagOptionMenu
public class DeleteOptionMenu extends OptionMenu {
	
	
	private Scanner scanner;
	private Dao<Pizza,String> dao;
	
	


	public DeleteOptionMenu(Scanner scanner, Dao<Pizza, String> dao) {
		
		this.scanner = scanner;
		this.dao = dao;
	}

	@Override
	public void libelle() {

		System.out.println("4. Supprimer une pizza");

	}

	@Override
	public boolean execute() {

		String choix;
		System.out.println("Veuillez donner le code de la pizza à supprimer");
		choix = scanner.next();

		try {
			dao.delete(choix);
		} catch (DaoException e) {
			Logger.getAnonymousLogger().log(Level.INFO, " Pas supprimable, car pas de bonne reference",e); 
		}

		return true;
	}
}
