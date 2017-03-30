package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.pizzeria.modele.Pizza;

@Repository("springJPA")
public class PizzaDaoSpringJPA implements Dao<Pizza, String> {

	@PersistenceContext
	private EntityManager em;
	



	@Override
	public List<Pizza> findAll()
	{		
		
		return em.createQuery("select piz from Pizza piz", Pizza.class).getResultList();
	}
	
	
	@Override
	
	public boolean save(Pizza pizza) {


		em.persist(pizza);
		
		return false;
	}

	@Override
	
	public boolean update(String codePizza, Pizza pizza) {


		Pizza pizzaMod = em.createQuery("select piz from Pizza piz where piz.code=:codP", Pizza.class)
				.setParameter("codP", codePizza).getSingleResult();
		pizza.setId(pizzaMod.getId());
		em.merge(pizza);
		
		return false;
	}

	@Override
	
	public boolean delete(String codePizza) {


		Pizza pizzaDel = em.createQuery("select piz from Pizza piz where piz.code=:codP", Pizza.class)
				.setParameter("codP", codePizza).getSingleResult();

		em.remove(pizzaDel);
		
		
		
		return false;
	}




	
	
}
