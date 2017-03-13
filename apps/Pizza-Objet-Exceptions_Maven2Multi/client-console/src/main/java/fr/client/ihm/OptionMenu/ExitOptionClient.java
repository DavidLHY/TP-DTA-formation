package fr.client.ihm.OptionMenu;

import fr.client.ihm.tools.IhmClientTools;

public class ExitOptionClient extends OptionClient {

	
	public ExitOptionClient() {	

		libelle=" Sortir";
	}
	

	@Override
	public void execute(IhmClientTools ihmToolsClient) {
		
		System.out.println("Bonne journée et merci d'être venu chez PizzaDavizza!");
		ihmToolsClient.getScanner().close();
		System.exit(0);
		
	}

}
