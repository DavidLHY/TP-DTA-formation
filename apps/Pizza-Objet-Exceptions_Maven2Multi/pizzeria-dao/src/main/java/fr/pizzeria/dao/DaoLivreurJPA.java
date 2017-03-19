package fr.pizzeria.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Livreur;


public class DaoLivreurJPA implements Dao<Livreur, String> {

	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("david-pizzeria-model");


	
	@Override
	public boolean save(Livreur livreur) {
		// TODO Auto-generated method stub
		
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {

			em.persist(livreur);
			et.commit();
		} catch (DaoException e) {

			et.rollback();
		} finally {
			em.close();
		}
		
		
		return false;
	}

	@Override
	public boolean update(String t, Livreur e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String t) {
		// TODO Auto-generated method stub
		return false;
	}

}
