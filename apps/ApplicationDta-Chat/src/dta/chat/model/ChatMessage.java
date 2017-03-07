package dta.chat.model;

import java.io.Serializable;

public class ChatMessage implements Serializable {

	private static final long serialVersionUID = 12L;

	public ChatMessage(String login, String text) {
		super();
		this.login = login;
		this.text = text;
	}

	private String login;
	private String text;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
