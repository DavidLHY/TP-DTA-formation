package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

import dta.chat.controller.ChatAuthController;
import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObserver;

public abstract class ViewComposite implements ChatObserver<ChatMessage> {

	protected String libelle;

	protected List<ViewComposite> listChatView = new ArrayList<>();
	protected String user;
	protected ChatAuthController authController;
	protected ChatMessage chatMessage;

	public ChatMessage getChatMessage() {
		return chatMessage;
	}

	public void setChatMessage(ChatMessage chatMessage) {
		this.chatMessage = chatMessage;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setAuthController(ChatAuthController authController) {
		this.authController = authController;
	}

	public void setLogin(String login) {
		this.user = login;
		this.listChatView.forEach(view -> view.setLogin(user));
	}

	public abstract void execute();

}
