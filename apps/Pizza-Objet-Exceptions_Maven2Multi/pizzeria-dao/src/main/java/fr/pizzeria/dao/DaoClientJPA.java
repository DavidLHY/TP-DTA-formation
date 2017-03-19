package fr.pizzeria.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Client;

public class DaoClientJPA implements DaoClient {

	private EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("david-pizzeria-model");
	
	@Override
	public boolean save(Client client) {
		
		
		
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			
			
			em.persist(client);
			
			et.commit();
		
		} catch (DaoException e) {
		
			et.rollback();
			throw new DaoException(
					"probleme lors de l'ajout d'un client en base de donnees JPA",e);
		} finally {
			em.close();
		}
		
		
		return false;
	}

	@Override
	public boolean update(String email, Client client) {
		
		
		
		return false;
	}

	@Override
	public boolean delete(String t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Client findclientmail(String email) throws DaoException  {
		
		
		EntityManager em = emFactory.createEntityManager();
		try{
			  TypedQuery<Client> qClient = em.createNamedQuery("Client.findByMail",Client.class).setParameter("email", email);
			  
			  Client client = qClient.getSingleResult();

			  return client;
			  
		}catch(NoResultException e)
		{
				throw new DaoException("Identifiant Inconnu");
				
		}
		
		
		
	}

}
