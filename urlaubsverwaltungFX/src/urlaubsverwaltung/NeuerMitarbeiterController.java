package urlaubsverwaltung;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NeuerMitarbeiterController implements Initializable{

	ErgebnisMengen verbindungZuErgebnisMengenZwei = new ErgebnisMengen();

	@FXML
	protected TextField name;
	@FXML
	protected TextField vorname;
	@FXML
	protected TextField urlaubsAnspruch;
	@FXML
	protected TextField restUrlaub;
	@FXML
	protected TextField urlaubGesamt;

	@FXML
	protected void neuenMitarbeiterAnlegen() {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("neuerMitarbeiter.fxml"));
		Parent root1 = (Parent) loader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));
		stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	protected void testbutton(){
		System.out.println(name.getText().toString());
	}

	// Button in neuer Stage, Mitarbeiteranlegen
		@FXML
		protected void neuenMitarbeiterAnlegenButton() {

			String stringName = name.getText().toString();
			String stringVorname = vorname.getText().toString();
			int intUrlaubsAnspruch = Integer.parseInt(urlaubsAnspruch.getText().toString());
			int intRestUrlaub = Integer.parseInt(restUrlaub.getText().toString());
			int intUrlaubGesamt = Integer.parseInt(urlaubGesamt.getText().toString());

			System.out.println(stringName + " " + stringVorname + " " + intUrlaubsAnspruch + " " + intRestUrlaub + " " + intUrlaubGesamt);

			verbindungZuErgebnisMengenZwei.ergebnisMengeMitarbeiterAnlegen(stringName, stringVorname, intUrlaubsAnspruch, intRestUrlaub, intUrlaubGesamt);

		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
