package dta.chat.view.console;

import java.util.Scanner;

import dta.chat.controller.ChatAuthController;
import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;

public class ChatConsoleView extends ViewComposite {

	Scanner sc;
	ChatConsoleConversationView conversationView;

	public ChatConsoleView(Scanner sc) {
		this.sc = sc;
		listChatView.add(new ChatConsoleTitleView());
		listChatView.add(new ChatConsoleLoginView(sc));
		conversationView = new ChatConsoleConversationView(sc);
		listChatView.add(conversationView);

	}

	@Override
	public void execute() {

		for (ViewComposite currentview : listChatView) {
			currentview.execute();
		}

	}

	public void setAuthController(ChatAuthController authController) {
		this.authController = authController;
		this.listChatView.forEach(view -> view.setAuthController(authController));
	}

	@Override
	public void update(ChatObservable<ChatMessage> observable, ChatMessage obj) {
		conversationView.update(observable, obj);
	}

}
