package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.modele.Livreur;

@Component
public class AjoutLivreurOptionMenu implements OptionMenu {

	private Scanner scanner;
	private Dao<Livreur, String> daoLivreur;

	@Autowired
	public AjoutLivreurOptionMenu(Scanner scanner, Dao<Livreur, String> daoLivreur) {
		super();
		this.scanner = scanner;
		this.daoLivreur = daoLivreur;
	}

	@Override
	public void libelle() {

		System.out.println("8. Ajouter Livreur");

	}

	@Override
	public boolean execute() {

		Livreur newLivreur = new Livreur();

		System.out.println("Nom du livreur");
		newLivreur.setNom(scanner.next());

		System.out.println("Prenom du livreur");
		newLivreur.setPrenom(scanner.next());

		daoLivreur.save(newLivreur);

		return false;
	}

}
