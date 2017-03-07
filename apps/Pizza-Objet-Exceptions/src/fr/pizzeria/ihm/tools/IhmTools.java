package fr.pizzeria.ihm.tools;

import java.util.Scanner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.IPizzaDaoFichier;
import fr.pizzeria.modele.Pizza;

public class IhmTools {

	Scanner scanner = new Scanner(System.in);
	// Dao<Pizza, String> iPizza = new IPizzaDaoInit();
	Dao<Pizza, String> iPizza = new IPizzaDaoFichier();

	public Scanner getScanner() {
		return scanner;
	}

	public Dao<Pizza, String> getiPizza() {
		return iPizza;
	}

}
