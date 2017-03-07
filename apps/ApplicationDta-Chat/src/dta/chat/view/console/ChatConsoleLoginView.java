package dta.chat.view.console;

import java.util.Scanner;

import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;

public class ChatConsoleLoginView extends ViewComposite {

	Scanner sc;

	public ChatConsoleLoginView(Scanner sc) {
		libelle = "== Authentification ==";
		this.sc = sc;
	}

	@Override
	public void execute() {

		System.out.println(super.libelle);

		System.out.print("Veuillez saisir votre Login (pas d'espace): ");
		String saisie = sc.next();
		this.authController.authenticate("\033[32m " + saisie);

	}

	@Override
	public void update(ChatObservable<ChatMessage> observable, ChatMessage obj) {
		// TODO Auto-generated method stub

	}

}
