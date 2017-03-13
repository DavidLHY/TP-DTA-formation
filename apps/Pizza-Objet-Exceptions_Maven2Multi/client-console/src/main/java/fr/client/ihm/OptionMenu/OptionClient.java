package fr.client.ihm.OptionMenu;

import fr.client.ihm.tools.IhmClientTools;
import fr.pizzeria.modele.Client;

public abstract class OptionClient {
	
	protected String libelle;
	
	public String getLibelle() {
		return libelle;
	}

	public void printLabelOption() {
		
		System.out.println(libelle);

	}
	
	public abstract void execute(IhmClientTools ihmToolsClient);
	
	public Client saisirClient(IhmClientTools ihmToolsClient)
	{
		Client client= new Client();
		System.out.println("Veuillez saisir votre nom");
		client.setNom(ihmToolsClient.getScanner().next() );
		System.out.println("Veuillez saisir votre prenom");
		client.setPrenom(ihmToolsClient.getScanner().next() );
		System.out.println("Veuillez saisir votre email");
		client.setEmail(ihmToolsClient.getScanner().next() );
		System.out.println("Veuillez saisir votre password");
		client.setMot_de_passe(ihmToolsClient.getScanner().next() );
		
		return client;
		
	}
	

}
