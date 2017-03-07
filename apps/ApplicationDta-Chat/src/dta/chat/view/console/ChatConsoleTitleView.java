package dta.chat.view.console;

import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;

public class ChatConsoleTitleView extends ViewComposite {

	public ChatConsoleTitleView() {
		super.libelle = "= CHAT APP =";
	}

	@Override
	public void execute() {
		System.out.println(super.libelle);

	}

	@Override
	public void update(ChatObservable<ChatMessage> observable, ChatMessage obj) {
		// TODO Auto-generated method stub

	}

}
