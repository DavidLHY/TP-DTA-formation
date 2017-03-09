package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;


public class IPizzaDaoFichier implements Dao<Pizza, String> {

	private List<Pizza> listOfPizza = new ArrayList<>();

	public IPizzaDaoFichier() {

		try (Stream<Path> files = Files.list(Paths.get("data"))) {

			listOfPizza = files.map(chemin -> {

				Pizza pz = new Pizza();
				pz.setCode(chemin.getFileName().toFile().getName().replaceFirst(".txt", ""));

				try {

					String[] contenuFichier = Files.lines(chemin, Charset.forName("UTF-8")).findFirst().get()
							.split(";");
					pz.setNom(contenuFichier[0]);
					pz.setPrix(Double.valueOf(contenuFichier[1]));
					pz.setCategoriePizza(CategoriePizza.valueOf(contenuFichier[2]));
					return pz;
				} catch (IOException e) {					
					Logger.getAnonymousLogger().log(Level.SEVERE, "probleme lors de la lecture des fichier pizzas, pizza Null par defaut",e);
					return pz;
				}
				

			}).collect(Collectors.toList());

		} catch (IOException e) {
			throw new DaoException(e);
		}

	}

	@Override
	public List<Pizza> findAllPizzas() {
		return listOfPizza;
	}

	@Override
	public boolean save(Pizza pizza) {

		if (listOfPizza.stream().filter(p -> p.getCode().equals(pizza.getCode())).count() != 0)
			throw new SavePizzaException();

		listOfPizza.add(pizza);

		return true;

	}

	@Override
	public boolean update(String codePizza, Pizza pizza) {

		listOfPizza.removeIf(p -> p.getCode().equals(codePizza));
		listOfPizza.add(pizza);

		return true;
	}

	@Override
	public boolean delete(String codePizza)  {

		listOfPizza.removeIf(p -> p.getCode().equals(codePizza));

		return false;
	}

	@Override
	public boolean quite()  {
		
		System.exit(0);
		
		return false;
	}

}
