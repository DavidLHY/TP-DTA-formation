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
import fr.pizzeria.modele.Pizza;

public class IPizzaDaoJPA implements Dao<Pizza, String> {

	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("david-pizzeria-model");

	private List<Pizza> listOfPizza = new ArrayList<>();

	public IPizzaDaoJPA() {

		EntityManager em = emFactory.createEntityManager();
		listOfPizza = em.createQuery("select piz from Pizza piz", Pizza.class).getResultList();

		em.close();

	}

	@Override
	public List<Pizza> findAll() {

		EntityManager em = emFactory.createEntityManager();
		listOfPizza = em.createQuery("select piz from Pizza piz", Pizza.class).getResultList();

		return listOfPizza;
	}

	@Override
	public boolean save(Pizza pizza) {

		EntityManager em = emFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {

			em.persist(pizza);
			et.commit();
			listOfPizza.add(pizza);
		} catch (DaoException e) {

			et.rollback();
		} finally {
			em.close();
		}

		return false;
	}

	@Override
	public boolean update(String codePizza, Pizza pizza) {

		EntityManager em = emFactory.createEntityManager();
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
		} finally {
			em.close();
		}

		return false;
	}

	@Override
	public boolean delete(String codePizza) {

		EntityManager em = emFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {

			Pizza pizzaDel = em.createQuery("select piz from Pizza piz where piz.code=:codP", Pizza.class)
					.setParameter("codP", codePizza).getSingleResult();

			em.remove(pizzaDel);
			et.commit();

		} catch (DaoException e) {

			et.rollback();
		} finally {
			em.close();
		}

		return false;
	}

	@Override
	public Set<Pizza> findby(String ref, String val) {

		List<Pizza> listOfPizza=new ArrayList<>();
		EntityManager em = emFactory.createEntityManager();
		listOfPizza = em.createQuery("select piz from Pizza piz where piz."+ref+"=:valP", Pizza.class).setParameter("valP",val).getResultList();
		
		Set<Pizza> setOfPizza= new HashSet<Pizza>(listOfPizza);
		
		return setOfPizza;
	}

}
