package dta.chat;

import java.util.Scanner;

import dta.chat.controller.ChatAuthControllerImpl;
import dta.chat.model.ChatConversationModel;
import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			/*
			 * HistoryFacade hF = new HistoryFacade();
			 * 
			 * hF.findLastMessages();
			 * 
			 * for (ChatMessage current : hF.getListHistoriqueMessages()) {
			 * System.out.println(current.getLogin() + ": " +
			 * current.getText()); }
			 */

			ChatConversationModel model = new ChatConversationModel();
			ChatConsoleView view = new ChatConsoleView(sc);
			view.setAuthController(new ChatAuthControllerImpl(view, model));
			view.execute();

			model.addObserver(view);

			new Thread(() -> {

				while (true) {
					model.readMessage();
				}

			}).start();

			String message;
			while (true) {
				message = sc.nextLine();
				// message = "Troll";
				if (!message.equals("Exit")) {
					model.sendMessage("\033[31m" + message + "\033[0m");
				} else {
					model.getAdapter().gethFacade().saveMessage();
					;
					System.exit(0);
				}

			}

		}

	}

}
