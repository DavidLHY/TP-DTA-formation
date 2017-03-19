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
import fr.pizzeria.modele.Commande;
import fr.pizzeria.modele.Pizza;

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

	@Override
	public Set<Commande> findby(String ref, Object val) {
		List<Commande> listOfCommandes = new ArrayList<>();
		EntityManager em = emFactory.createEntityManager();
		if (val != null) {
			listOfCommandes = em.createQuery("select com from Commande com where com." + ref + "=:val", Commande.class)
					.setParameter("val", val).getResultList();
		}
		{
			listOfCommandes = em
					.createQuery("select com from Commande com where com." + ref + " is null", Commande.class)
					.getResultList();
		}

		Set<Commande> setOfCommande = new HashSet<Commande>(listOfCommandes);

		return setOfCommande;
	}

}
