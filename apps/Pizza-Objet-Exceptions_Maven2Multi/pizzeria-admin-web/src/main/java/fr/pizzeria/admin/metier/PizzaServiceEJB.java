package fr.pizzeria.admin.metier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.pizzeria.modele.Pizza;

@Stateless
public class PizzaServiceEJB {

	@PersistenceContext(unitName = "pizzeria")
	private EntityManager em;

	public List<Pizza> findAll() {

		return em.createQuery("select piz from Pizza piz", Pizza.class).getResultList();

	}

	public Set<Pizza> findby(String ref, Object val) {

		

		return new HashSet<>( em.createQuery("select piz from Pizza piz where piz." + ref + "=:valP", Pizza.class)
				.setParameter("valP", val).getResultList());

		

	}

	public void update(String code, Pizza pizza) {
		
		Pizza pizzaMod = em.createQuery("select piz from Pizza piz where piz.code=:codP", Pizza.class)
				.setParameter("codP", code).getSingleResult();
		pizza.setId(pizzaMod.getId());
		em.merge(pizza);
		
	}

	public void delete(String code) {
		
		Pizza pizzaDel = em.createQuery("select piz from Pizza piz where piz.code=:codP", Pizza.class)
				.setParameter("codP", code).getSingleResult();

		em.remove(pizzaDel);
		
	}

	public Set<Object> findCat(String categorie){
			
		return new HashSet<>(em.createQuery("select "+categorie+" from Pizza piz",Object.class).getResultList());
		
		
	}

	public void save(Pizza pizza) {
		
		em.persist(pizza);		
	}

}
