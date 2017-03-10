package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.exception.DaoException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public class IPizzaDaoBD extends DaoPizza {

	public IPizzaDaoBD() {

		String sql = "SELECT * FROM	PIZZA";

		try (Connection conn = newCreateConnection();
				Statement statement = conn.createStatement();
				ResultSet resultats = statement.executeQuery(sql);) {

			Class.forName("com.mysql.jdbc.Driver");

			while (resultats.next()) {

				Integer id = resultats.getInt("ID");
				String code = resultats.getString("reference");
				String name = resultats.getString("libelle");
				double price = resultats.getDouble("prix");
				String categorie = resultats.getString("categorie");
				listOfPizza.add(new Pizza(id, code, name, price, CategoriePizza
						.valueOf(categorie)));
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new DaoException(
					"probleme lors de la lecture des pizzas en base de donnees",
					e);
		}

	}

	private Connection newCreateConnection() {

		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");

		try {
			Class.forName(bundle.getString("driver"));
			return DriverManager.getConnection(bundle.getString("url"),
					bundle.getString("admin"), bundle.getString("pwd"));

		} catch (ClassNotFoundException e) {
			throw new DaoException("Pas de Driver", e);
		} catch (SQLException e) {
			throw new DaoException("Pas de connections au serveur", e);

		}

	}

	@Override
	public List<Pizza> findAllPizzas() {
		return listOfPizza;
	}

	@Override
	public boolean save(Pizza pizza) {

		if (listOfPizza.stream()
				.filter(p -> p.getCode().equals(pizza.getCode())).count() != 0)
			throw new SavePizzaException("Code deja existant");

		try (Connection conn = newCreateConnection();
				PreparedStatement statement = conn
						.prepareStatement("INSERT INTO PIZZA(reference,libelle,prix,categorie) VALUES(?,?,?,?)");) {
			listOfPizza.add(pizza);

			statement.setString(1, pizza.getCode());
			statement.setString(2, pizza.getNom());
			statement.setDouble(3, pizza.getPrix());
			statement.setString(4, pizza.getCategoriePizza().name());

			statement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(
					"probleme lors de l'ajout d'une pizza en base de donnees",
					e);
		}

		return true;

	}

	public void save(List<Pizza> listOfPizza) {
		List<List<Pizza>> listOList = ListUtils.partition(listOfPizza, 3);

		for (List<Pizza> listCurrent : listOList) {

			try (Connection conn = newCreateConnection();
					PreparedStatement statement = conn
							.prepareStatement("INSERT INTO PIZZA(reference,libelle,prix,categorie) VALUES(?,?,?,?)");) {

				conn.setAutoCommit(false);
				for (Pizza pizza : listCurrent) {

					if (pizza != null) {
						try {
							statement.setString(1, pizza.getCode());
							statement.setString(2, pizza.getNom());
							statement.setDouble(3, pizza.getPrix());
							statement.setString(4, pizza.getCategoriePizza()
									.name());

							statement.executeUpdate();
						} catch (SQLException e) {
							System.out
									.println("Reference Pizza Deja existante");
						}
					}

				}
				conn.commit();

			} catch (SQLException e) {

				throw new DaoException(
						"probleme lors de l'import des pizzas en base de donnees",
						e);
			}
		}

	}

	@Override
	public boolean update(String codePizza, Pizza pizza) {

		listOfPizza.removeIf(p -> p.getCode().equals(codePizza));
		listOfPizza.add(pizza);

		try (Connection conn = newCreateConnection();
				PreparedStatement statement = conn
						.prepareStatement("UPDATE PIZZA SET reference=?,libelle=?,prix=?,categorie=? WHERE reference=?");) {

			statement.setString(1, pizza.getCode());
			statement.setString(2, pizza.getNom());
			statement.setDouble(3, pizza.getPrix());
			statement.setString(4, pizza.getCategoriePizza().name());
			statement.setString(5, codePizza);

			statement.executeUpdate();
			statement.close();

		} catch (SQLException e) {
			throw new DaoException(
					"probleme lors de la mise à jour d'une pizza en base de donnees",
					e);
		}

		return true;
	}

	@Override
	public boolean delete(String codePizza) {

		listOfPizza.removeIf(p -> p.getCode().equals(codePizza));

		try (Connection conn = newCreateConnection();
				Statement statement = conn.createStatement();) {
			statement.executeUpdate("DELETE FROM PIZZA WHERE reference='"
					+ codePizza + "'");
		} catch (SQLException e) {
			throw new DaoException(
					"probleme lors de la suppression d'une pizza en base de donnees",
					e);
		}

		return false;
	}

	public void importData(Dao<Pizza, String> source) {

		List<List<Pizza>> listOList = ListUtils.partition(
				source.findAllPizzas(), 3);

		try (Connection conn = newCreateConnection();
				PreparedStatement statement = conn
						.prepareStatement("INSERT INTO PIZZA(reference,libelle,prix,categorie) VALUES(?,?,?,?)");) {

			conn.setAutoCommit(false);
			
			for (List<Pizza> listCurrent : listOList) {

				insertInTransaction(conn, statement, listCurrent);

			}

		} catch (SQLException e) {
			throw new DaoException(
					"probleme lors de l'import des pizzas en base de donnees",
					e);
		}

	}

	private void insertInTransaction(Connection conn,
			PreparedStatement statement, List<Pizza> listCurrent)
			throws SQLException {
		
		for (Pizza pizza : listCurrent) {

			statement.setString(1, pizza.getCode());
			statement.setString(2, pizza.getNom());
			statement.setDouble(3, pizza.getPrix());
			statement.setString(4, pizza.getCategoriePizza().name());

			statement.executeUpdate();
		}
		conn.commit();
	}
}
