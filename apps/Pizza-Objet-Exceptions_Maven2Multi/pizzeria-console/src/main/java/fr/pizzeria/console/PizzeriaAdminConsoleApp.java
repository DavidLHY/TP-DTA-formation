package fr.pizzeria.console;


import java.util.List;
import java.util.logging.Level;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.dao.Dao;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.ihm.tools.IhmTools;
import fr.pizzeria.modele.Pizza;

public class PizzeriaAdminConsoleApp {
	
	private PizzeriaAdminConsoleApp(){}

	
	public static void main(String[] args) {
		
		
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dao-memoire-config.xml","application-config.xml");
		
	java.util.logging.Logger.getLogger("org").setLevel(Level.SEVERE);
	
		Dao<Pizza,String>  daoSpring = context.getBean(Dao.class);
		IhmTools ihmTools = context.getBean(IhmTools.class);
		Menu menu = context.getBean(Menu.class);
		List<Pizza> allPizza= daoSpring.findAll();
		
		for(Pizza pizza:allPizza)
		{
			System.out.println(pizza);
		}

		
		
		//menu.printMenu();

		menu.actionmenu(ihmTools);
	}
}
