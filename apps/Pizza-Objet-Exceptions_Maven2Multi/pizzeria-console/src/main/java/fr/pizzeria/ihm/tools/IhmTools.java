package fr.pizzeria.ihm.tools;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.IPizzaDaoInit;
import fr.pizzeria.modele.Pizza;

public class IhmTools {

	Scanner scanner;
	Dao<Pizza, String> iPizza;
	// Dao<Pizza, String> iPizza = new IPizzaDaoFichier();

	public IhmTools() {

		ResourceBundle bundle = ResourceBundle.getBundle("application");

		String daoimpl = bundle.getString("dao.impl");
		System.out.println(daoimpl);
		scanner = new Scanner(System.in);
		try {
			iPizza = (Dao<Pizza, String>) Class.forName(daoimpl).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			iPizza = new IPizzaDaoInit();
		}

	}

	public Scanner getScanner() {
		return scanner;
	}

	public Dao<Pizza, String> getiPizza() {
		return iPizza;
	}

}
