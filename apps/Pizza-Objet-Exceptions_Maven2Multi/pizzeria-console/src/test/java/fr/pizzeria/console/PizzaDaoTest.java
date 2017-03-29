package fr.pizzeria.console;


import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.modele.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzeriaAppSpringConfig.class )
public class PizzaDaoTest {

	@Autowired
	@Qualifier("pizzaP")
	private Dao<Pizza,String> daoPizza;
	
	@Test
	public void testfindAll(){
		
		List<Pizza> listPizza = daoPizza.findAll();
		assertTrue(listPizza!=null);
	}
	
	
}
