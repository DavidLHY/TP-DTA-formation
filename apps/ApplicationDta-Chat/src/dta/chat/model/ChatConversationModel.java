package dta.chat.model;

import dta.chat.model.observer.ChatObservable;
import dta.chat.model.socket.ChatSocketImplProxy;

public class ChatConversationModel extends ChatObservable<ChatMessage> {

	private String login;
	private ChatSocketImplProxy adapter;

	public ChatConversationModel() {
		adapter = new ChatSocketImplProxy();
		adapter.gethFacade().findLastMessages();

	}

	public void readMessage() {
		ChatMessage chatMessage = adapter.readMesssage();
		notifyObservers(chatMessage);
	}

	public void sendMessage(String msg) {
		// observers.forEach(ov -> ov.update(this, new ChatMessage(login,
		// msg)));
		// notifyObservers(new ChatMessage(login, msg));
		adapter.sendMessage(new ChatMessage(login, msg));
	}

	public ChatSocketImplProxy getAdapter() {
		return adapter;
	}

	public void setLogin(String login) {

		this.login = login;

	}

}
