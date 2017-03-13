package fr.client.ihm.tools;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.client.ihm.MenuClient;
import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.DaoClient;
import fr.pizzeria.dao.DaoClientJPA;
import fr.pizzeria.modele.Client;
import fr.pizzeria.modele.Pizza;

public class IhmClientTools {

	private Scanner scanner;
	private Client client;
	private MenuClient menuClient;
	private DaoClient daoClient;
	



	public IhmClientTools(){
		scanner = new Scanner(System.in);
		menuClient=new MenuClient();
		daoClient = new DaoClientJPA();
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

}