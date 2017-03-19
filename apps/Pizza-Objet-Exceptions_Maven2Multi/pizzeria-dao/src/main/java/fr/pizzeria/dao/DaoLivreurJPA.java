package fr.pizzeria.dao;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
			throw new DaoException("probleme lors de l'ajout d'un livreur en base de donnees JPA",e);
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
	
	@Override
	public Set<Livreur> findby(String ref, Object val)
	{
		List<Livreur> listOfLivreur = new ArrayList<>();
		EntityManager em = emFactory.createEntityManager();
		if(!val.equals("all"))
		{
		if (!val.equals(null)) {
			listOfLivreur = em.createQuery("select liv from Livreur liv where liv." + ref + "=:val", Livreur.class)
					.setParameter("val", val).getResultList();
		}
		{
			listOfLivreur = em
					.createQuery("select liv from Livreur liv where liv." + ref + " is null", Livreur.class)
					.getResultList();
		}
		}else
		{
			listOfLivreur = em
					.createQuery("select liv from Livreur liv", Livreur.class).getResultList();
		}

		Set<Livreur> setOfLivreur = new HashSet<Livreur>(listOfLivreur);

		return setOfLivreur;
		
		
	}

}
