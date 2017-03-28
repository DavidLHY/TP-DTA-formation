package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import fr.pizzeria.dao.factory.Factory;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Pizza;


public class IPizzaDaoJPA implements Dao<Pizza, String> {

	private Factory emFactory;
	
	
	public IPizzaDaoJPA() {


	}

	@Override
	public List<Pizza> findAll() {

		EntityManager em = emFactory.getEmFactory().createEntityManager();
		List<Pizza> listOfPizza = em.createQuery("select piz from Pizza piz", Pizza.class).getResultList();

		return listOfPizza;
	}

	@Override
	public boolean save(Pizza pizza) {

		EntityManager em = emFactory.getEmFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {

			em.persist(pizza);
			et.commit();
			
		} catch (DaoException e) {

			et.rollback();
			throw new DaoException(
					"probleme lors de l'ajout d'une pizza en base de donnees JPA",
					e);
		} finally {
			em.close();
		}

		return false;
	}

	@Override
	public boolean update(String codePizza, Pizza pizza) {

		EntityManager em = emFactory.getEmFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {

			Pizza pizzaMod = em.createQuery("select piz from Pizza piz where piz.code=:codP", Pizza.class)
					.setParameter("codP", codePizza).getSingleResult();
			pizza.setId(pizzaMod.getId());
			em.merge(pizza);
			et.commit();

		} catch (DaoException e) {

			et.rollback();
			throw new DaoException(	"probleme lors de la mise à jour d'une pizza en base de donnees JPA",
					e);
		} finally {
			em.close();
		}

		return false;
	}

	@Override
	public boolean delete(String codePizza) {

		EntityManager em = emFactory.getEmFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {

			Pizza pizzaDel = em.createQuery("select piz from Pizza piz where piz.code=:codP", Pizza.class)
					.setParameter("codP", codePizza).getSingleResult();

			em.remove(pizzaDel);
			et.commit();

		} catch (DaoException e) {

			et.rollback();
			throw new DaoException(
					"probleme lors de la suppression d'une pizza en base de donnees JPA",
					e);
		} finally {
			em.close();
		}

		return false;
	}

	@Override
	public Set<Pizza> findby(String ref, Object val) {

		List<Pizza> listOfPizza=new ArrayList<>();
		EntityManager em = emFactory.getEmFactory().createEntityManager();
		listOfPizza = em.createQuery("select piz from Pizza piz where piz."+ref+"=:valP", Pizza.class).setParameter("valP",val).getResultList();
		
		Set<Pizza> setOfPizza= new HashSet<Pizza>(listOfPizza);
		
		return setOfPizza;
	}
	
	@Override
	public Set<Object> findCat(String categorie){
		List<Object> listOfCategorie= new ArrayList<>();
		EntityManager em = emFactory.getEmFactory().createEntityManager();
		listOfCategorie = em.createQuery("select "+categorie+" from Pizza piz",Object.class).getResultList();
		
		Set<Object> setOfCategorie= new HashSet<Object>(listOfCategorie);
		
		return setOfCategorie;
	}

	public Factory getEmFactory() {
		return emFactory;
	}

	public void setEmFactory(Factory emFactory) {
		this.emFactory = emFactory;
	}
	
	
	

}
