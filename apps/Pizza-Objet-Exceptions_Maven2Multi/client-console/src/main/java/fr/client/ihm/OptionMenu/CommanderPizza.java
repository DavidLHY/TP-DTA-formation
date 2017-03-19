package fr.client.ihm.OptionMenu;

import java.util.Date;
import java.util.List;
import java.util.Set;

import fr.client.ihm.tools.IhmClientTools;
import fr.pizzeria.modele.Commande;
import fr.pizzeria.modele.Pizza;

public class CommanderPizza extends OptionClient {

	public CommanderPizza() {
		libelle=" Commander Pizza";
	}
	
	@Override
	public void execute(IhmClientTools ihmToolsClient) {
		
		List<Pizza> listOfpizza = ihmToolsClient.getDaoPizza().findAll();
		
		for(Pizza current: listOfpizza)
		{			
			current.printPizza();
		}
		System.out.println("Veullez donnez la référence pizza:");
		String code = ihmToolsClient.getScanner().next();
		
		Set<Pizza> pizzaCommander=(Set<Pizza>) ihmToolsClient.getDaoPizza().findby("code",code);
		
		
		Commande newCommande=new Commande();
		newCommande.setPizzas(pizzaCommander);
		newCommande.setDat_commande(new Date());
		newCommande.setClient_id(ihmToolsClient.getClient().getId());		
		ihmToolsClient.setCommande(newCommande);
		
		ihmToolsClient.getDaoCommande().save(ihmToolsClient.getCommande());
		
		ihmToolsClient.getMenuClient().printMenuCommande(ihmToolsClient);
		


	}

}
