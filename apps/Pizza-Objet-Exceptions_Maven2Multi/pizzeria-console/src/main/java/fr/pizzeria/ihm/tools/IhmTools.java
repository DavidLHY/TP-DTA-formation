package fr.pizzeria.ihm.tools;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.IPizzaDaoInit;
import fr.pizzeria.modele.Pizza;


public class IhmTools {

	private Scanner scanner;
	private Dao<Pizza, String> daoImpl;
	private Dao<Pizza, String> daoSource;	
	public IhmTools() {

		ResourceBundle bundle = ResourceBundle.getBundle("application");

		String daoimpl = bundle.getString("dao.impl");
		String daoSourceString = bundle.getString("dao.source");
		scanner = new Scanner(System.in);
		try {
			daoImpl = (Dao<Pizza, String>) Class.forName(daoimpl).newInstance();
			daoSource = (Dao<Pizza, String>) Class.forName(daoSourceString).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "Mauvais appel de class dao, utilisation DaoInit Par d&faut",e);
			daoImpl = new IPizzaDaoInit();
		}

	}

	public Scanner getScanner() {
		return scanner;
	}

	public Dao<Pizza, String> getDaoImpl() {
		return daoImpl;
	}

	public Dao<Pizza, String> getDaoSource() {
		return daoSource;
	}

}
