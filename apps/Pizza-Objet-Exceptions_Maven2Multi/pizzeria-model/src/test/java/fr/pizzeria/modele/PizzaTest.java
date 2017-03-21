package fr.pizzeria.modele;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PizzaTest {

	@Test
	public void testHashCode() {
		Set<Pizza> sets = new HashSet<>();
		Pizza p1 = new Pizza( "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE);
		

		sets.add(p1);
		assertThat(p1, is(p1));
	}

	@Test
	public void testEqualsPizza() {
		Set<Pizza> sets = new HashSet<>();
		Pizza p1 = new Pizza( "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE);
	

		sets.add(p1);
		assertThat(p1, is(p1));
	}

}
