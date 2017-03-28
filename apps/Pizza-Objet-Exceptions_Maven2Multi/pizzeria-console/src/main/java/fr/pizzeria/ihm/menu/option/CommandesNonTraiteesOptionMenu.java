package fr.pizzeria.ihm.menu.option;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.modele.Commande;

@Component
public class CommandesNonTraiteesOptionMenu implements OptionMenu {

	
	private Dao<Commande,String> daoCommande;
	
	
	@Autowired
	public CommandesNonTraiteesOptionMenu(Dao<Commande, String> daoCommande) {
		super();
		this.daoCommande = daoCommande;
	}

	@Override
	public void libelle() {
		System.out.println("9. Afficher commandes non traitees");
		
	}

	@Override
	public boolean execute() {

		Set<Commande> setCommande = daoCommande.findby("livreur_id", null);
		
		
		for(Commande current:setCommande)
		{
			System.out.println(current);
		}
		
		return false;
	}

}
