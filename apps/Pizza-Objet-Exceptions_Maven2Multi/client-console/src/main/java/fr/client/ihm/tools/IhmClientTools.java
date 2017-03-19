package fr.client.ihm.tools;

import java.util.Scanner;

import fr.client.ihm.MenuClient;
import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.DaoClient;
import fr.pizzeria.dao.DaoClientJPA;
import fr.pizzeria.dao.DaoCommandeJPA;
import fr.pizzeria.dao.IPizzaDaoJPA;
import fr.pizzeria.modele.Client;
import fr.pizzeria.modele.Commande;
import fr.pizzeria.modele.Pizza;

public class IhmClientTools {

	private Scanner scanner;
	private Client client;
	private MenuClient menuClient;
	private DaoClient daoClient;
	private Dao<Pizza,String> daoPizza;
	private Dao<Commande,String> daoCommande;
	private Commande commande;



	
	public IhmClientTools(){
		scanner = new Scanner(System.in);
		menuClient=new MenuClient();
		daoClient = new DaoClientJPA();
		daoPizza = new IPizzaDaoJPA();
		daoCommande = new DaoCommandeJPA();
	}
	
	public Dao<Pizza, String> getDaoPizza() {
		return daoPizza;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	
	public DaoClient getDaoClient() {
		return daoClient;
	}

	
	public MenuClient getMenuClient() {
		return menuClient;
	}


	public Scanner getScanner() {
		return scanner;
	}
	
	

	
	
    public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Dao<Commande, String> getDaoCommande() {
		return daoCommande;
	}

}