package fr.pizzeria.ihm.tools;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.DaoCommandeJPA;
import fr.pizzeria.dao.DaoLivreurJPA;
import fr.pizzeria.dao.IPizzaDaoInit;
import fr.pizzeria.modele.Commande;
import fr.pizzeria.modele.Livreur;
import fr.pizzeria.modele.Pizza;


public class IhmTools {

	private Scanner scanner;
	private Dao<Pizza, String> daoImpl;
	private Dao<Pizza, String> daoSource;
	private Dao<Livreur, String> daoLivreur;
	private Dao<Commande,String> daoCommande;
	public IhmTools() {

		ResourceBundle bundle = ResourceBundle.getBundle("application");

		String daoimpl = bundle.getString("dao.impl");
		String daoSourceString = bundle.getString("dao.source");
		scanner = new Scanner(System.in);
		try {
			daoImpl = (Dao<Pizza, String>) Class.forName(daoimpl).newInstance();
			daoSource = (Dao<Pizza, String>) Class.forName(daoSourceString).newInstance();
			daoLivreur = new DaoLivreurJPA(); 
			daoCommande = new DaoCommandeJPA();
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

	public Dao<Livreur, String> getDaoLivreur() {
		return daoLivreur;
	}

	public Dao<Commande, String> getDaoCommande() {
		return daoCommande;
	}
	
	
}
