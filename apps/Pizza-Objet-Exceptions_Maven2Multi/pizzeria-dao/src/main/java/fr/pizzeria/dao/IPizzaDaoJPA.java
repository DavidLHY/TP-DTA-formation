package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Pizza;

public class IPizzaDaoJPA implements Dao<Pizza, String> {

	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("david-pizzeria-model");	
	

    private List<Pizza> listOfPizza= new ArrayList<>();
	
	public IPizzaDaoJPA() {
		
	 EntityManager em = emFactory.createEntityManager();
		listOfPizza= em.createQuery("select piz from Pizza piz",	Pizza.class).getResultList();
		
		em.close();
				
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		
		
		
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
