package fr.pizzeria.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.config.DaoSpringConfig;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoSpringConfig.class )
public class PerformanceDaoSpringTest {
	
	@Autowired
	Dao<Pizza,String> daoJPA;
	
	@Test
	public void Test()
	{
		daoJPA.save(new Pizza("", "noom", 10,CategoriePizza.POISSON));
		daoJPA.save(new Pizza("", "nom2", 102,CategoriePizza.VIANDE));
		
		List<Pizza> listPizza = daoJPA.findAll();
		
		System.out.println(listPizza);
		assertTrue(listPizza != null);
		
	}
	
	

}
