package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.modele.Pizza;

@TagOptionMenu
@Component
public class PrixMaxOptionMenu implements OptionMenu {

	
	private Dao<Pizza,String> dao;
	
	@Autowired
	public PrixMaxOptionMenu(@Qualifier("pizzaP") Dao<Pizza, String> dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void libelle() {
		System.out.println("6 - Afficher la pizza au tarif le plus élevé");

	}

	@Override
	public boolean execute() {

		System.out.println("La pizza la plus cher est:");
		dao.findAll().stream().max(Comparator.comparing(Pizza::getPrix)).get().printPizza();

		return false;
	}

}
