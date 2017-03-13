package fr.client.ihm.OptionMenu;


import fr.client.ihm.tools.IhmClientTools;
import fr.pizzeria.modele.Client;

public class InscriptionOptionClient extends OptionClient {

	 public InscriptionOptionClient() {
		libelle= "S'inscrire";
	}
		

	@Override
	public void execute(IhmClientTools ihmToolsClient) {
		
		Client client = saisirClient(ihmToolsClient);
		ihmToolsClient.getDaoClient().save(client);		
		
	}

}
