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

	 

	public IPizzaDaoBD() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria","root",null);
			statement = connection.createStatement();
			resultats = statement.executeQuery("SELECT * FROM	PIZZA");
			
			
			while(resultats.next()) {

				Integer id = resultats.getInt("ID");
				String code = resultats.getString("reference");
				String name = resultats.getString("libelle");
				double price = resultats.getDouble("prix");
				String categorie = resultats.getString("categorie");
				//System.out.println("[id=" + id + " code="+code+" name=" + name + " price=" + price + " categorie="+categorie+"]"); 
				
				listOfPizza.add(new Pizza(id,code,name,price,CategoriePizza.valueOf(categorie)));
			}			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		/*listOfPizza.add(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		listOfPizza.add(new Pizza(2, "REI", "Reine", 11.50, CategoriePizza.SANS_VIANDE));
		listOfPizza.add(new Pizza(3, "FRO", "4Fromage", 12.00, CategoriePizza.SANS_VIANDE));
		listOfPizza.add(new Pizza(4, "CAN", "Cannibale", 12.50, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza(5, "SAV", "Savoyarde", 13.00, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza(6, "ORI", "Orientale", 13.50, CategoriePizza.VIANDE));
		listOfPizza.add(new Pizza(7, "SAU", "Saumon", 14.00, CategoriePizza.POISSON));*/
		Pizza.setNbpizzas(listOfPizza.size());
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
			e.printStackTrace();
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
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean delete(String codePizza) throws DaoException {

		listOfPizza.removeIf(p -> p.getCode().equals(codePizza));
		
		try {
			statement.executeUpdate("DELETE FROM PIZZA WHERE reference='"+codePizza+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return false;
	}
}
