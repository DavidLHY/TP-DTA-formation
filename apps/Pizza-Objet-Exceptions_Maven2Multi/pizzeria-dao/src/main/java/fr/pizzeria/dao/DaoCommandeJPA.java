package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.pizzeria.dao.factory.Factory;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Commande;


public class DaoCommandeJPA implements Dao<Commande, String> {

	//private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("david-pizzeria-model");

	private Factory emFactory;
		
	@Override
	public boolean save(Commande comm) {

		EntityManager em = emFactory.getEmFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {

			em.persist(comm);
			et.commit();
		} catch (DaoException e) {

			et.rollback();
			throw new DaoException(
					"probleme lors de l'ajout d'une Commande en base de donnees JPA",e);
		} finally {
			em.close();
		}

		return false;
	}

	@Override
	public boolean update(String id, Commande commande) {

		
		EntityManager em = emFactory.getEmFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {

			Commande commandeMod = em.createQuery("select com from Commande com where  com.id=:codP", Commande.class)
					.setParameter("codP", Integer.parseInt(id)).getSingleResult();
			commande.setId(commandeMod.getId());
			em.merge(commande);
			et.commit();

		} catch (DaoException e) {

			et.rollback();
			throw new DaoException(
					"probleme lors de la mise à jour d'une Commande en base de donnees JPA",e);
		} finally {
			em.close();
		}
		
		
		
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
		EntityManager em = emFactory.getEmFactory().createEntityManager();
		if (val != null) {
			listOfCommandes = em.createQuery("select com from Commande com where com." + ref + "=:val", Commande.class)
					.setParameter("val", val).getResultList();
		}
		{
			listOfCommandes = em
					.createQuery("select com from Commande com where com." + ref + " is NULL", Commande.class)
					.getResultList();
		}

		Set<Commande> setOfCommande = new HashSet<Commande>(listOfCommandes);

		return setOfCommande;
	}

	public Factory getEmFactory() {
		return emFactory;
	}

	public void setEmFactory(Factory emFactory) {
		this.emFactory = emFactory;
	}

	
}
