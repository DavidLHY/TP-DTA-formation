package fr.pizzeria.dao;


import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Client;

public interface DaoClient extends Dao<Client, String> {


	public Client findclientmail(String mail) throws DaoException;
	
	

}
