package dta.chat.model.socket;

import dta.chat.model.ChatMessage;
import dta.chat.model.socket.exception.ChatClientException;

public interface ChatSocket {

	void sendMessage(ChatMessage msg) throws ChatClientException;

	ChatMessage readMesssage() throws ChatClientException;

}
