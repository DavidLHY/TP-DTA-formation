package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public class IPizzaDaoBD implements Dao<Pizza, String> {

	private List<Pizza> listOfPizza = new ArrayList<>();
	private Statement statement;
	private ResultSet resultats;
    private Connection connection;
	 

	public IPizzaDaoBD() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria","root",null);
			statement = connection.createStatement();
			resultats = statement.executeQuery("SELECT * FROM	PIZZA");
			
			
			while(resultats.next()) {

				Integer id = resultats.getInt("ID");
				String code = resultats.getString("reference");
				String name = resultats.getString("libelle");
				double price = resultats.getDouble("prix");
				String categorie = resultats.getString("categorie");				
				listOfPizza.add(new Pizza(id,code,name,price,CategoriePizza.valueOf(categorie)));
			}			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new DaoException("probleme lors de la lecture des pizzas en base de donnees",e);
		}
		
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return listOfPizza;
	}

	@Override
	public boolean save(Pizza pizza) throws DaoException {

		if (listOfPizza.stream().filter(p -> p.getCode().equals(pizza.getCode())).count() != 0)
			throw new SavePizzaException();

		
		
		try {
			listOfPizza.add(pizza);
			statement.executeUpdate("INSERT INTO PIZZA(reference,libelle,prix,categorie)"+ " VALUES('"+
					pizza.getCode()+"','"+
							pizza.getNom()+ "',"+
								pizza.getPrix()	+",'"+
								pizza.getCategoriePizza().name()+"')");
			
		} catch (SQLException e) {
			throw new DaoException("probleme lors de l'ajout d'une pizza en base de donnees",e);
		}

		return true;

	}

	@Override
	public boolean update(String codePizza, Pizza pizza) {

		listOfPizza.removeIf(p -> p.getCode().equals(codePizza));
		listOfPizza.add(pizza);
		
		try {
			statement.executeUpdate("UPDATE PIZZA SET "	
		      + "prix="+pizza.getPrix()
		      + ",reference='"+pizza.getCode()+"'"
		      + ",libelle='"+pizza.getNom()+"'"
		      + ",categorie='"+pizza.getCategoriePizza().name()+"' WHERE reference='"+codePizza+"'");
		} catch (SQLException e) {
			throw new DaoException("probleme lors de la mise à jour d'une pizza en base de donnees",e);
		}

		return true;
	}

	@Override
	public boolean delete(String codePizza) throws DaoException {

		listOfPizza.removeIf(p -> p.getCode().equals(codePizza));
		
		try {
			statement.executeUpdate("DELETE FROM PIZZA WHERE reference='"+codePizza+"'");
		} catch (SQLException e) {
			throw new DaoException("probleme lors de la suppression d'une pizza en base de donnees",e);
		}
		

		return false;
	}

	@Override
	public boolean quite() throws DaoException {
		
		try {
			connection.close();
			System.exit(0);
		} catch (SQLException e) {
			throw new DaoException("probleme lors de la fermeture de la base de donnees",e);
		}
		
		
		return false;
	}
}
