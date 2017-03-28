package fr.pizzeria.dao.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {

	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("david-pizzeria-model");
	
	

	public EntityManagerFactory getEmFactory() {
		return emFactory;
	}

	public void setEmFactory(EntityManagerFactory emFactory) {
		this.emFactory = emFactory;
	}
	
	
}
