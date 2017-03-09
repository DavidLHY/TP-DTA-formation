package fr.pizzeria.ihm.tools;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.dao.IPizzaDaoInit;


public class IhmTools {

	Scanner scanner;
	DaoPizza iPizza;
	public IhmTools() {

		ResourceBundle bundle = ResourceBundle.getBundle("application");

		String daoimpl = bundle.getString("dao.impl");
		scanner = new Scanner(System.in);
		try {
			iPizza = (DaoPizza) Class.forName(daoimpl).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "Mauvais appel de class dao, utilisation DaoInit Par d&faut",e);
			iPizza = new IPizzaDaoInit();
		}

	}

	public Scanner getScanner() {
		return scanner;
	}

	public DaoPizza getiPizza() {
		return iPizza;
	}

}
