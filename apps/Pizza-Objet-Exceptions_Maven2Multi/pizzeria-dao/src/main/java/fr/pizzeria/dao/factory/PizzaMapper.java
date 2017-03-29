package fr.pizzeria.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public class PizzaMapper implements RowMapper<Pizza> {

	@Override
	public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {

		Pizza p = new Pizza();

		p.setCode(rs.getString("REFERENCE"));
		p.setNom(rs.getString("LIBELLE"));
		p.setPrix(rs.getDouble("PRIX"));
		p.setCategoriePizza(CategoriePizza.valueOf(rs.getString("categorie")));

		return p;

	}

}
