package dta.chat.history;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import dta.chat.model.ChatMessage;
import dta.chat.model.socket.exception.ChatClientException;

public class HistoryFacade {

	private List<ChatMessage> listHistoriqueMessages = new ArrayList<>();

	private String separateur = "//..//";

	public List<ChatMessage> findLastMessages() throws ChatClientException {

		try (Stream<String> linesOfFiles = Files.lines(Paths.get("data/Historique.txt"))) {

			listHistoriqueMessages = (List<ChatMessage>) linesOfFiles.map(ligne -> {
				String[] cham = ligne.split(separateur);

				ChatMessage chatMessage = new ChatMessage(cham[0], cham[1]);
				return chatMessage;
			}).collect(Collectors.toList());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listHistoriqueMessages;
	}

	public void saveMessage() throws ChatClientException {

		try (FileWriter fw = new FileWriter("data/Historique.txt")) {

			for (ChatMessage current : listHistoriqueMessages) {
				fw.write(current.getLogin() + separateur + current.getText() + "\r\n");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// listHistoriqueMessages.add(message);

	}

	public List<ChatMessage> getListHistoriqueMessages() {
		return listHistoriqueMessages;
	}

	public void setListHistoriqueMessages(List<ChatMessage> listHistoriqueMessages) {
		this.listHistoriqueMessages = listHistoriqueMessages;
	}

}
