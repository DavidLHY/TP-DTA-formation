package fr.pizzeria.ihm.menu.option;

import java.util.Set;

import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Commande;
import fr.pizzeria.modele.Livreur;

public class TraiterCommandeOptionMenu extends OptionMenu {

	@Override
	public void libelle() {
		System.out.println("10. Traiter Commande");

	}

	@Override
	public boolean execute(IhmTools ihmTools) {

		Set<Commande> ListCommande = ihmTools.getDaoCommande().findby("livreur", null);

		for (Commande current : ListCommande) {
			System.out.println(current);
		}
		System.out.println("Veuillez entrer l'id de la commande non traitee:");
		int id_Commande = ihmTools.getScanner().nextInt();

		Set<Livreur> ListLivreur = ihmTools.getDaoLivreur().findby("id", "all");

		for (Livreur current : ListLivreur) {
			System.out.println(current);
		}
		System.out.println("Veuillez entrer l'id du livreur pour expedier la commande:");
		int id_Livreur = ihmTools.getScanner().nextInt();

		Commande commandeExp=null;
		Livreur livreurExp=null;
		for (Commande current : ListCommande) {
			if (current.getId() == id_Commande) {
				commandeExp = current;
			}
		}
		
		for (Livreur current : ListLivreur) {

			if (current.getId() == id_Livreur) {
				livreurExp = current;
			}
		}
		
		commandeExp.setLivreur(livreurExp);

		ihmTools.getDaoCommande().update(""+id_Commande, commandeExp);
		
		return false;
	}

}
