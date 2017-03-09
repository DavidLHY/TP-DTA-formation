package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;


public class IPizzaDaoFichier extends DaoPizza {

	

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

	


}
