package fr.pizzeria.ihm.tools;

import java.util.Scanner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.modele.Pizza;


public class IhmTools {

	private Scanner scanner;
	private Dao<Pizza, String> daoImpl;
	/*private Dao<Pizza, String> daoSource;
	private Dao<Livreur, String> daoLivreur;
	private Dao<Commande,String> daoCommande;*/
	
	public IhmTools() {

		scanner = new Scanner(System.in);

	}

	public Scanner getScanner() {
		return scanner;
	}

	public Dao<Pizza, String> getDaoImpl() {
		return daoImpl;
	}


	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public void setDaoImpl(Dao<Pizza, String> daoImpl) {
		this.daoImpl = daoImpl;
	}

	
	
	
	
}
