package fr.pizzeria.ihm.menu.option;

import java.util.Set;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.modele.Commande;

public class CommandesNonTraiteesOptionMenu extends OptionMenu {

	
	private Dao<Commande,String> daoCommande;
	
	

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
