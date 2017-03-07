package dta.chat.controller;

import dta.chat.model.ChatConversationModel;
import dta.chat.view.console.ViewComposite;

public class ChatAuthControllerImpl implements ChatAuthController {

	private ViewComposite view;

	private ChatConversationModel chatModel;

	public void setChatModel(ChatConversationModel chatModel) {
		this.chatModel = chatModel;
	}

	public ChatAuthControllerImpl(ViewComposite view, ChatConversationModel chatModel) {

		this.view = view;
		this.chatModel = chatModel;
	}

	@Override
	public void authenticate(String login) {

		view.setLogin(login);
		chatModel.setLogin(login);

	}

}
