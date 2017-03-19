package fr.pizzeria.ihm.menu.option;

import java.util.Set;

import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Commande;

public class CommandesNonTraiteesOptionMenu extends OptionMenu {

	@Override
	public void libelle() {
		System.out.println("9. Afficher commandes non traitees");
		
	}

	@Override
	public boolean execute(IhmTools ihmTools) {

		Set<Commande> setCommande = ihmTools.getDaoCommande().findby("numero_commande", null);
		
		
		for(Commande current:setCommande)
		{
			System.out.println(current);
		}
		
		return false;
	}

}
