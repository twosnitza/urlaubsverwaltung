package urlaubsverwaltung;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class NeuerMitarbeiter {

	public NeuerMitarbeiter(){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("neuerMitarbeiter.fxml"));
		fxmlLoader.setRoot(this);
	    fxmlLoader.setController(this);
	    try {
	        fxmlLoader.load();
	    } catch (IOException exception) {
	        throw new RuntimeException(exception);
	    }
	}

}
