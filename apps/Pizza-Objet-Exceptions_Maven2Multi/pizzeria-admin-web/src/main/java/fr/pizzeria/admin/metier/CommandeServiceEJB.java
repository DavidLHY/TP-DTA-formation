package fr.pizzeria.admin.metier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.pizzeria.modele.Commande;


@Stateless
public class CommandeServiceEJB {

	@PersistenceContext(unitName = "pizzeria")
	private EntityManager em;

	public List<Commande> findAll() {

		return em.createQuery("select com from Commande com", Commande.class).getResultList();

	}

	public Set<Commande> findby(String ref, Object val) {

		

		return new HashSet<>( em.createQuery("select com from Commande com where piz." + ref + "=:valP", Commande.class)
				.setParameter("valP", val).getResultList());

		

	}

	public void update(String code, Commande commande) {
		
		Commande commandeMod = em.createQuery("select piz from Pizza piz where piz.code=:codP", Commande.class)
				.setParameter("codP", code).getSingleResult();
		commande.setId(commandeMod.getId());
		em.merge(commande);
		
	}

	public void delete(int id) {
		
		Commande commandeDel = em.createQuery("select piz from Commande commande where commande.id=:codP", Commande.class)
				.setParameter("codP", id).getSingleResult();

		em.remove(commandeDel);
		
	}

	public Set<Object> findCat(String categorie){
			
		return new HashSet<>(em.createQuery("select "+categorie+" from Commande com",Object.class).getResultList());
		
		
	}

	public void save(Commande commande) {
		
		em.persist(commande);		
	}

}
