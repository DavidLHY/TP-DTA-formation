package fr.pizzeria.console;

import java.util.Scanner;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.dao.DaoClientJPA;
import fr.pizzeria.dao.DaoCommandeJPA;
import fr.pizzeria.dao.DaoLivreurJPA;
import fr.pizzeria.dao.IPizzaDaoFichier;
import fr.pizzeria.dao.PizzaDaoSpringJDBC;
import fr.pizzeria.dao.config.DaoSpringConfig;
import fr.pizzeria.dao.factory.Factory;
import fr.pizzeria.ihm.menu.option.OptionMenu;
import fr.pizzeria.modele.Commande;
import fr.pizzeria.modele.Livreur;
import fr.pizzeria.modele.Pizza;

@Configuration
@ComponentScan("fr.pizzeria.ihm")
@Import(DaoSpringConfig.class)
public class PizzeriaAppSpringConfig {

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean
	@Qualifier("pizzaP")
	public Dao<Pizza, String> daoPizza(@Qualifier("BaseProd") DataSource dataSource) {
		/*
		 * IPizzaDaoJPA p = new IPizzaDaoJPA(); p.setEmFactory(factory); return
		 * p;
		 */

		return new PizzaDaoSpringJDBC(dataSource);

	}

	@Bean
	public Factory factory() {
		return new Factory();
	}

	@Bean
	@Qualifier("pizzaS")
	public Dao<Pizza, String> daopizzaSource() {
		return new IPizzaDaoFichier();
	}

	@Bean
	public TreeMap<Integer, OptionMenu> listOptions() {
		return null;
	}

	@Bean
	String titre() {
		return "***** Pizzeria Administration *****";
	}

	@Bean
	public Dao<Commande, String> daoCommande() {
		return new DaoCommandeJPA();
	}

	@Bean
	public DaoClientJPA daoClient() {
		return new DaoClientJPA();
	}

	@Bean
	public Dao<Livreur, String> daoLivreur() {
		return new DaoLivreurJPA();
	}

}
