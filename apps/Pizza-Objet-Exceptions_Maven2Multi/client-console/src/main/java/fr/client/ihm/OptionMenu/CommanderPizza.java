package fr.client.ihm.OptionMenu;

import java.util.List;


import fr.client.ihm.tools.IhmClientTools;
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
		
		

	}

}
