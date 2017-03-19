package fr.pizzeria.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Commande;

public class DaoCommandeJPA implements Dao<Commande, String> {

	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("david-pizzeria-model");
	
	@Override
	public boolean save(Commande comm) {


		EntityManager em = emFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {

			em.persist(comm);
			et.commit();
		} catch (DaoException e) {

			et.rollback();
		} finally {
			em.close();
		}
		
		return false;
	}

	@Override
	public boolean update(String t, Commande e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String t) {
		// TODO Auto-generated method stub
		return false;
	}

}
