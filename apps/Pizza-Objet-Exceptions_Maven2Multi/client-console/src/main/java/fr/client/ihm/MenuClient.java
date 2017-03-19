package fr.client.ihm;



import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import fr.client.ihm.OptionMenu.CommanderPizza;
import fr.client.ihm.OptionMenu.ExitOptionClient;
import fr.client.ihm.OptionMenu.IdentifierClient;
import fr.client.ihm.OptionMenu.InscriptionOptionClient;
import fr.client.ihm.OptionMenu.OptionClient;
import fr.client.ihm.tools.IhmClientTools;


public class MenuClient {
	
	private String titre = "***** Pizzeria Client *****";
	private Map<Integer,OptionClient> optionClient=new TreeMap<Integer, OptionClient>();
	private Map<Integer,OptionClient> optionCommande=new TreeMap<Integer, OptionClient>();
	
	public MenuClient() {
		
		optionClient.put(2,new IdentifierClient());
		optionClient.put(1,new InscriptionOptionClient());
		optionClient.put(99,new ExitOptionClient());
		
		
		optionCommande.put(1, new CommanderPizza());
		optionCommande.put(99,new ExitOptionClient());
		
	}
	
	public void printMenuClient(IhmClientTools ihmClientTools){
		
		System.out.println(titre);
		for (Entry<Integer, OptionClient> entrySet : optionClient.entrySet()) {
			
			System.out.println(entrySet.getKey() + ". " + entrySet.getValue().getLibelle());

		}
		
		System.out.println("Veuillez choisir votre option");
		int choix = ihmClientTools.getScanner().nextInt();		
		optionClient.get(choix).execute(ihmClientTools);
		
		printMenuClient(ihmClientTools);
		
	}
	
	public void printMenuCommande(IhmClientTools ihmClientTools){
		
		System.out.println(titre);
		for (Entry<Integer, OptionClient> entrySet : optionCommande.entrySet()) {
			
			System.out.println(entrySet.getKey() + ". " + entrySet.getValue().getLibelle());

		}
		
		System.out.println("Veuillez choisir votre option");
		int choix = ihmClientTools.getScanner().nextInt();		
		optionCommande.get(choix).execute(ihmClientTools);
		
		
	}
	
	
	

}
