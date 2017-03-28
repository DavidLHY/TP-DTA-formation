package fr.pizzeria.console;


import java.util.logging.Level;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.pizzeria.ihm.Menu;

public class PizzeriaAdminConsoleAppAnnotation {
	
	private PizzeriaAdminConsoleAppAnnotation(){}

	
	public static void main(String[] args) {
		
		
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaAppSpringConfig.class);
		
	java.util.logging.Logger.getLogger("org").setLevel(Level.SEVERE);
	
		
		Menu menu = context.getBean(Menu.class);
		
		menu.actionmenu();
		
		context.close();
	}
}
