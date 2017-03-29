package fr.pizzeria.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.config.DaoSpringConfig;
import fr.pizzeria.modele.CategoriePizza;
import fr.pizzeria.modele.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoSpringConfig.class )
public class PizzaDaoSpringJDBCTest {

	@Autowired
	Dao<Pizza,String> daoJDBC;
	
	@Test
	public void findAll_Test()
	{
		List<Pizza> listPizza = daoJDBC.findAll();
		assertTrue(listPizza != null);
	}
	
	
	@Test
	public void Save_Test()
	{
		int Size1 = daoJDBC.findAll().size();
		daoJDBC.save(new Pizza("code", "nom", 12, CategoriePizza.POISSON));
		
		assertTrue(Size1+1 == daoJDBC.findAll().size());
	}
	
	@Test
	public void Update_Test()
	{
		int Size1 = daoJDBC.findAll().size();
		daoJDBC.update("code",new Pizza("code", "nom2", 12, CategoriePizza.POISSON));
		
		assertTrue(Size1 == daoJDBC.findAll().size());
	}
	
	
	@Test
	public void Delete_Test()
	{
		int Size1 = daoJDBC.findAll().size();
		daoJDBC.delete("code");		
		assertTrue(Size1-1 == daoJDBC.findAll().size());
	}
	
	
}
