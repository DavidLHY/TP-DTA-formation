package fr.client.console;

import java.util.logging.Level;

import fr.client.ihm.MenuClient;
import fr.client.ihm.tools.IhmClientTools;

public class ClientApp {
	

	private ClientApp(){}

	
	public static void main(String[] args) {	
		
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

		
		IhmClientTools ihmClientTools = new IhmClientTools();
		
	
		
		
		ihmClientTools.getMenuClient().printMenuClient(ihmClientTools);
		
		
	}

}
