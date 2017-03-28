package fr.pizzeria.ihm.menu.option;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Pizza;

public class ImporterDonnesOptionMenu extends OptionMenu {


	private Dao<Pizza,String> dao;
	private Dao<Pizza,String> daoSource;
	
	

	public ImporterDonnesOptionMenu(Dao<Pizza, String> dao, Dao<Pizza, String> daoSource) {
		super();
		this.dao = dao;
		this.daoSource = daoSource;
	}

	@Override
	public void libelle() {

		System.out.println("7. Importer des pizzas");
	}

	@Override
	public boolean execute() {

		try {
			dao.importData(daoSource);
		} catch (DaoException e) {
			Logger.getAnonymousLogger().log(Level.INFO, "Import Failed",e);
		}

		return false;
	}

}
