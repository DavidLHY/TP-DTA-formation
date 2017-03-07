package dta.chat.model.socket;

import java.io.IOException;

import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;

public class ChatSocketImpl extends ChatObservable<ChatMessage> implements ChatSocket {

	private ClientSocket client;

	public ChatSocketImpl() {
		try {
			this.client = new ClientSocket("192.168.99.31", 1800);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(" bug");
		}
	}

	@Override
	public void sendMessage(ChatMessage msg) {

		try {
			client.sendObject(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Pas de texte");
		}

	}

	@Override
	public ChatMessage readMesssage() {

		try {
			return (ChatMessage) client.readObject();
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

	public ClientSocket getClient() {
		return client;
	}

	public void setClient(ClientSocket client) {
		this.client = client;
	}

}
