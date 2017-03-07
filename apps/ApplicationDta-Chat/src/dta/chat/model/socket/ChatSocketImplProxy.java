package dta.chat.model.socket;

import java.io.IOException;

import dta.chat.history.HistoryFacade;
import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;

public class ChatSocketImplProxy extends ChatObservable<ChatMessage> implements ChatSocket {

	private ChatSocketImpl chatSocketImpl;
	private HistoryFacade hFacade;

	public ChatSocketImplProxy() {
		chatSocketImpl = new ChatSocketImpl();
		hFacade = new HistoryFacade();
	}

	@Override
	public void sendMessage(ChatMessage msg) {

		try {
			chatSocketImpl.getClient().sendObject(msg);
			if (hFacade.getListHistoriqueMessages().size() >= 100) {
				hFacade.getListHistoriqueMessages().remove(0);
			}
			hFacade.getListHistoriqueMessages().add(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Pas de texte");
		}

	}

	@Override
	public ChatMessage readMesssage() {

		try {
			ChatMessage cMessage = (ChatMessage) chatSocketImpl.getClient().readObject();
			if (hFacade.getListHistoriqueMessages().size() >= 100) {
				hFacade.getListHistoriqueMessages().remove(0);
			}
			hFacade.getListHistoriqueMessages().add(cMessage);
			return cMessage;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public HistoryFacade gethFacade() {
		return hFacade;
	}

}
