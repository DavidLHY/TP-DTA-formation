package fr.pizzeria.ihm.menu.option;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.modele.Pizza;

@Component
public class GroupedPrintedOptionMenu implements OptionMenu {

	
	private Dao<Pizza,String> dao;
	
	
	@Autowired
	public GroupedPrintedOptionMenu(@Qualifier("pizzaP") Dao<Pizza, String> dao) {
		this.dao = dao;
	}

	@Override
	public void libelle() {
		System.out.println("5 - Lister les pizzas par categorie");

	}

	@Override
	public boolean execute() {

		dao.findAll().stream().collect(Collectors.groupingBy(Pizza::getCategoriePizza))
				.forEach((k, v) -> {
					System.out.println("Dans la categorie " + k.toString() + ":");
					for (Pizza current : v) {
						current.printPizza();
					}

				});

		return false;
	}

}
