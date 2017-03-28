package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Commande;
import fr.pizzeria.modele.Livreur;

@Component
public class TraiterCommandeOptionMenu implements OptionMenu {

	private Scanner scanner;
	private Dao<Commande,String> daoCommande;
	private Dao<Livreur,String> daoLivreur;
	
	
	@Autowired
	public TraiterCommandeOptionMenu(Scanner scanner, Dao<Commande, String> daoCommande,
			Dao<Livreur, String> daoLivreur) {
		this.scanner = scanner;
		this.daoCommande = daoCommande;
		this.daoLivreur = daoLivreur;
	}

	@Override
	public void libelle() {
		System.out.println("10. Traiter Commande");

	}

	@Override
	public boolean execute() {

		Set<Commande> ListCommande = daoCommande.findby("livreur", null);

		for (Commande current : ListCommande) {
			System.out.println(current);
		}
		System.out.println("Veuillez entrer l'id de la commande non traitee:");
		int id_Commande = scanner.nextInt();

		Set<Livreur> ListLivreur = daoLivreur.findby("id", "all");

		for (Livreur current : ListLivreur) {
			System.out.println(current);
		}
		System.out.println("Veuillez entrer l'id du livreur pour expedier la commande:");
		int id_Livreur = scanner.nextInt();

		Commande commandeExp = null;
		Livreur livreurExp = null;
		for (Commande current : ListCommande) {
			if (current.getId() == id_Commande) {
				commandeExp = current;
				break;
			}
		}

		for (Livreur current : ListLivreur) {

			if (current.getId() == id_Livreur) {
				livreurExp = current;
				break;
			}
		}

		try {
			if (commandeExp != null && livreurExp != null) {
				commandeExp.setLivreur(livreurExp);
				daoCommande.update(Integer.toString(id_Commande), commandeExp);
			}else
			{
				throw new DaoException("id commande et/ou Livreur null");
			}
		} catch (NullPointerException e) {
			Logger.getAnonymousLogger().log(Level.INFO, "Choix Commande et/ou livreur incorrect ", e);

		}

		return false;
	}

}
