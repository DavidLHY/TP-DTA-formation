package fr.pizzeria.ihm.menu.option;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public class ImporterDonnesOptionMenu extends OptionMenu {

	@Override
	public void libelle() {
	
		System.out.println("7. Importer des pizzas");
	}

	@Override
	public boolean execute(IhmTools ihmTools) {
		
		ResourceBundle bundle = ResourceBundle.getBundle("application");

		String daoimpl = bundle.getString("dao.impl");
		
		
		if(!"fr.pizzeria.dao.IPizzaDaoBD".equals(daoimpl))
		{
			System.out.println("Veulliez configurer votre Appli en mode Base de donnees");
			return false;
		}
		
		
		try (Stream<Path> files = Files.list(Paths.get("data"))) {

			List<Pizza> listOfPizza = files.map(chemin -> {
				
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
					Logger.getAnonymousLogger().log(Level.SEVERE, "probleme lors de la lecture des fichiers pizzas, pizza Null par defaut",e);
					return pz;
				}
				

			}).collect(Collectors.toList());
			
			
			ihmTools.getiPizza().save(listOfPizza);
			

		} catch (IOException e) {
			throw new DaoException(e);
		}
		
		
		

		
		return false;
	}

}
