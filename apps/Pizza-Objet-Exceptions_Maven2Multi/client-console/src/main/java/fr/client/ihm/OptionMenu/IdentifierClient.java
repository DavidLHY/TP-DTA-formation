package fr.client.ihm.OptionMenu;



import java.util.logging.Level;
import java.util.logging.Logger;


import fr.client.ihm.tools.IhmClientTools;
import fr.pizzeria.exception.DaoException;
import fr.pizzeria.modele.Client;

public class IdentifierClient extends OptionClient {

	public IdentifierClient()
	{
		libelle= "Se connecter";
	}
	
	

	@Override
	public void execute(IhmClientTools ihmToolsClient) {
		
		System.out.println("Veuillez saisir votre email");
		String email=ihmToolsClient.getScanner().next();
		
		try{
		Client client = ihmToolsClient.getDaoClient().findclientmail(email);
		
		System.out.println("Veuillez saisir votre password");
		String pwd=ihmToolsClient.getScanner().next();
		
		if(pwd.equals(client.getMot_de_passe()))
		{
			ihmToolsClient.setClient(client);
			ihmToolsClient.getMenuClient().printMenuCommande(ihmToolsClient);
		}else
		{
			throw new DaoException("Mauvais mot de passe");
		}
		
		}catch(DaoException e)
		{
			Logger.getAnonymousLogger().log(Level.INFO, e.getMessage(),e); 
		}
		
		
		
		
	}

}
