package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Livreur;

public class AjoutLivreurOptionMenu extends OptionMenu {

	@Override
	public void libelle() {

		System.out.println("8. Ajouter Livreur");

	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		
		Livreur newLivreur=new Livreur();
		
		System.out.println("Nom du livreur");
		newLivreur.setNom(ihmTools.getScanner().next());
		
		System.out.println("Prenom du livreur");
		newLivreur.setPrenom(ihmTools.getScanner().next());
		
		ihmTools.getDaoLivreur().save(newLivreur);
		
		return false;
	}

}
