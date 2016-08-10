package urlaubsverwaltung;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VerwaltungController implements Initializable{

	// VerwaltungController controller = new VerwaltungController();

	// Verbindung zur Klasse ErgebnisMengen
	protected ErgebnisMengen verbindungZuErgebnisMengenEins = new ErgebnisMengen();
	protected Mitarbeiter mitarbeiter = new Mitarbeiter();
	protected InfoFenster infoFenster = new InfoFenster();
	protected NeuerMitarbeiterController neuerController = new NeuerMitarbeiterController();

	// Tabellen-Teile ##########################
	// TableView Darstellung der MitarbeiterDaten

	@FXML
	protected TableView<Mitarbeiter> mitarbeiterDaten;
	@FXML
	protected TableColumn<Mitarbeiter, String> nameColumn;
	@FXML
	protected TableColumn<Mitarbeiter, String> vornameColumn;
	@FXML
	protected TableColumn<Mitarbeiter, Integer> urlaubsAnspruchColumn;
	@FXML
	protected TableColumn<Mitarbeiter, Integer> restUrlaubColumn;
	@FXML
	protected TableColumn<Mitarbeiter, Integer> urlaubGesamtColumn;
	@FXML
	protected TableColumn<Mitarbeiter, String> vertretungColumn;

	// Tabelle Ende ############################

	protected ObservableList<Mitarbeiter> obListDummy = FXCollections.observableArrayList();


	// ComboBox zur Auswahl der Mitarbeiter
	@FXML
	protected ComboBox<String> namenComboBox = new ComboBox<>();

	/*
	 * Methode holt selektierten Namen von der ComboBox und uebergibt sie an
	 * tabelleinhaltFuellen()
	 */
	@FXML
	protected void comboBoxAuswahlTreffen() {
		obListDummy.clear();
		String name = namenComboBox.getSelectionModel().getSelectedItem();

		// Debug Ausgabe
		System.out.println("Ausgabe comboBoxAuswahlTeffen " + name);

		// ErgebnisMenge anhand der Auswahl erstellen
		verbindungZuErgebnisMengenEins.ergebnisMengeOberservableList(obListDummy, name);
		vornameColumn.setCellValueFactory(cellData -> cellData.getValue().getVorname());
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
		urlaubsAnspruchColumn.setCellValueFactory(cellData -> cellData.getValue().getUrlaubsanspruch().asObject());
		restUrlaubColumn.setCellValueFactory(cellData -> cellData.getValue().getResturlaub().asObject());
		urlaubGesamtColumn.setCellValueFactory(cellData -> cellData.getValue().getUrlaubgesamt().asObject());
		vertretungColumn.setCellValueFactory(cellData -> cellData.getValue().getVertretung());

		mitarbeiterDaten.setItems(obListDummy);

		// System.out.println(obListDummy.toString());

	}

	@FXML
	protected void listeAllerMitarbeiter() {
		obListDummy.clear();
		// ErgebnisMenge anhand der Auswahl erstellen
		verbindungZuErgebnisMengenEins.ergebnisMengeOberservableListAlleMitarbeiter(obListDummy);
		vornameColumn.setCellValueFactory(cellData -> cellData.getValue().getVorname());
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
		urlaubsAnspruchColumn.setCellValueFactory(cellData -> cellData.getValue().getUrlaubsanspruch().asObject());
		restUrlaubColumn.setCellValueFactory(cellData -> cellData.getValue().getResturlaub().asObject());
		urlaubGesamtColumn.setCellValueFactory(cellData -> cellData.getValue().getUrlaubgesamt().asObject());
		vertretungColumn.setCellValueFactory(cellData -> cellData.getValue().getVertretung());
		mitarbeiterDaten.setItems(obListDummy);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		verbindungZuErgebnisMengenEins.ergebnisMengeComboBoxFuellen(namenComboBox);
		namenComboBox.setPromptText("Mitarbeiter auswählen");

	}

	public void setMitarbeiterVerbindung(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	/*
	 * Schalter-Ecke
	 *
	 */

	@FXML
	private void buttonFuerInfoFenster() {
		infoFenster.programmInfo();
	}

	@FXML
	private void buttonFuerNeuenMitarbeiter() {
		neuerController.neuenMitarbeiterAnlegen();
	}
}
