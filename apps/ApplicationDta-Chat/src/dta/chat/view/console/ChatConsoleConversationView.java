package dta.chat.view.console;

import java.util.Scanner;

import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;

public class ChatConsoleConversationView extends ViewComposite {

	Scanner sc;

	public ChatConsoleConversationView(Scanner sc) {
		libelle = "== Conversations ==";
		this.sc = sc;
	}

	@Override
	public void execute() {
		System.out.println(libelle);
		System.out.println("Welcome " + user);

	}

	@Override
	public void update(ChatObservable<ChatMessage> observable, ChatMessage obj) {
		System.out.println(obj.getLogin() + " : " + obj.getText());
	}

}
