package fr.pizzeria.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.pizzeria.dao.factory.PizzaMapper;
import fr.pizzeria.modele.Pizza;

@Repository
public class PizzaDaoSpringJDBC implements Dao<Pizza, String> {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	
	public PizzaDaoSpringJDBC(@Qualifier("BaseTest")DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Pizza> findAll() {
		String sql = "SELECT * FROM PIZZA";
		return this.jdbcTemplate.query(sql, new PizzaMapper());

	}

	@Override
	public boolean save(Pizza pizza) {

		String sql = "INSERT INTO PIZZA(reference,libelle,prix,categorie) VALUES(?,?,?,?)";

		Object[] insertObj = { pizza.getCode(), pizza.getNom(), pizza.getPrix(), pizza.getCategoriePizza().name() };

		this.jdbcTemplate.update(sql, insertObj);

		return false;
	}

	@Override
	public boolean update(String code, Pizza pizza) {

		String sql =  "UPDATE PIZZA SET reference=?,libelle=?,prix=?,categorie=? WHERE reference=?";		
		Object[] insertObj = { pizza.getCode(), pizza.getNom(), pizza.getPrix(), pizza.getCategoriePizza().name(),code };
		this.jdbcTemplate.update(sql, insertObj);
		
		return false;
	}

	@Override
	public boolean delete(String code) {

		String sql = "DELETE FROM PIZZA WHERE reference=?";
		this.jdbcTemplate.update(sql, code);

		return false;
	}

}
