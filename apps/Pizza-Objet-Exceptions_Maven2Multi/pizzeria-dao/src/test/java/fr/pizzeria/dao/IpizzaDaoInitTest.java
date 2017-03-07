package fr.pizzeria.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import fr.pizzeria.dao.IPizzaDaoInit;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

public class IpizzaDaoInitTest {

	IPizzaDaoInit pizzaDao = new IPizzaDaoInit();

	/*
	 * @Test public void testFindAll() {
	 * 
	 * fail("J'echoue"); }
	 */

	@Test
	public void test_Find_All() {
		List<Pizza> listPizza = pizzaDao.findAllPizzas();
		assertEquals(8, listPizza.size());
	}

	@Test
	public void test_save() {
		List<Pizza> listPizza = pizzaDao.findAllPizzas();
		Pizza pz = new Pizza(5, "SEV", "Savoyarde", 13.00, CategoriePizza.VIANDE);

		pizzaDao.save(pz);
		assertEquals(9, listPizza.size());
		assertThat(listPizza.size(), is(9));
	}

}
