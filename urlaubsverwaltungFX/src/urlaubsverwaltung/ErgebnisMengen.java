package urlaubsverwaltung;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class ErgebnisMengen {

	// Verbindung zur Klasse DatenbankVerbindung
	protected DatenbankVerbindungen verbindungDatenbankVerbindung = new DatenbankVerbindungen();
	protected Mitarbeiter mitarbeiter = new Mitarbeiter();
	protected Connection verbindung = null;
	protected ResultSet ergebnisMenge = null;
	// protected ResultSet ergebnisMengeLokal = null;

	/**
	 * @param comboDummy
	 * @return
	 */
	protected ComboBox<String> ergebnisMengeComboBoxFuellen(ComboBox<String> comboDummy) {
		ObservableList<String> comboListDummy = FXCollections.observableArrayList();
		String sqlAnweisung = "SELECT name FROM mitarbeiter";
		try {
			// Verbindung herstellen und Ergebnismenge beschaffen
			verbindung = verbindungDatenbankVerbindung.dbOeffnen("org.apache.derby.jdbc.EmbeddedDriver",
					"jdbc:derby:urlaubsverwaltungDB");
			ergebnisMenge = verbindungDatenbankVerbindung.dbErgebnis(verbindung, sqlAnweisung);
			// dbVerbindungsMethode(sqlAnweisung);
			// solange Daten vorhanden sind
			while (ergebnisMenge.next()) {
				String dummy = ergebnisMenge.getString("name");
				comboListDummy.add(dummy);

				// Debug Ausgabe
				System.out.println(ergebnisMenge.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		comboDummy.setItems(comboListDummy);
		try {
			ergebnisMenge.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbSchliessen();
		return comboDummy;
	}

	// ErgebnisMenge fuer TableView beschaffen
	protected ObservableList<Mitarbeiter> ergebnisMengeOberservableList(ObservableList<Mitarbeiter> obListDummy,
			String dummy) {
		String sqlAnweisung = "SELECT * FROM mitarbeiter WHERE name = '" + dummy + "'";
		ResultSet ergebnisMengeLokal = null;
		try {
			// Verbindung herstellen und Ergebnismenge beschaffen
			verbindung = verbindungDatenbankVerbindung.dbOeffnen("org.apache.derby.jdbc.EmbeddedDriver",
					"jdbc:derby:urlaubsverwaltungDB");
			ergebnisMengeLokal = verbindungDatenbankVerbindung.dbErgebnis(verbindung, sqlAnweisung);
			// dbVerbindungsMethode(sqlAnweisung);
			// solange Daten vorhanden sind
			while (ergebnisMengeLokal.next()) {
				String name = ergebnisMengeLokal.getString("name");
				String vorname = ergebnisMengeLokal.getString("vorname");
				Integer urlaubsanspruch = ergebnisMengeLokal.getInt("urlaub");
				Integer resturlaub = ergebnisMengeLokal.getInt("resturlaub");
				Integer urlaubgesamt = ergebnisMengeLokal.getInt("urlaubgesamt");
				String vertretung = ergebnisMengeLokal.getString("vertretung");
				obListDummy.add(new Mitarbeiter(name, vorname, urlaubsanspruch, resturlaub, urlaubgesamt, vertretung));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ergebnisMengeLokal.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbSchliessen();

		return obListDummy;
	}

	// Methode zum Schliessen der DB
	protected void dbSchliessen() {
		try {
			// Ergebnismenge und Verbindung schliessen
//			ergebnisMenge.close();
			verbindung.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// DBMS schliessen
		verbindungDatenbankVerbindung.dbSchliessen("jdbc:derby:urlaubsverwaltungDB");
	}

	protected ObservableList<Mitarbeiter> ergebnisMengeOberservableListAlleMitarbeiter(
			ObservableList<Mitarbeiter> obListDummy) {
		String sqlAnweisung = "SELECT * FROM mitarbeiter";
		ResultSet ergebnisMengeLokal = null;
		try {
			// Verbindung herstellen und Ergebnismenge beschaffen
			verbindung = verbindungDatenbankVerbindung.dbOeffnen("org.apache.derby.jdbc.EmbeddedDriver",
					"jdbc:derby:urlaubsverwaltungDB");
			ergebnisMengeLokal = verbindungDatenbankVerbindung.dbErgebnis(verbindung, sqlAnweisung);
			// dbVerbindungsMethode(sqlAnweisung);
			// solange Daten vorhanden sind
			while (ergebnisMengeLokal.next()) {
				String name = ergebnisMengeLokal.getString("name");
				String vorname = ergebnisMengeLokal.getString("vorname");
				Integer urlaubsanspruch = ergebnisMengeLokal.getInt("urlaub");
				Integer resturlaub = ergebnisMengeLokal.getInt("resturlaub");
				Integer urlaubgesamt = ergebnisMengeLokal.getInt("urlaubgesamt");
				String vertretung = ergebnisMengeLokal.getString("vertretung");
				obListDummy.add(new Mitarbeiter(name, vorname, urlaubsanspruch, resturlaub, urlaubgesamt, vertretung));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ergebnisMengeLokal.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbSchliessen();
		return obListDummy;
	}

	protected void ergebnisMengeMitarbeiterAnlegen(String name, String vorname, int urlaubsAnspruch,
			int restUrlaub, int urlaubGesamt) {

		String sqlAnweisung = "SELECT * FROM mitarbeiter";
		ResultSet ergebnisMengeLokal = null;
		// Verbindung herstellen und Ergebnismenge beschaffen
		try {
			verbindung = verbindungDatenbankVerbindung.dbOeffnen("org.apache.derby.jdbc.EmbeddedDriver",
					"jdbc:derby:urlaubsverwaltungDB");
			ergebnisMengeLokal = verbindungDatenbankVerbindung.dbErgebnis(verbindung, sqlAnweisung);

			System.out.println("Ausgabe aus Methode " + name + " " + vorname + " " + urlaubsAnspruch + " " + restUrlaub + " " + urlaubGesamt);
			ergebnisMengeLokal.moveToInsertRow();

			ergebnisMengeLokal.updateString(3, name);
			ergebnisMengeLokal.updateString(4, vorname);
			ergebnisMengeLokal.updateInt(5, urlaubsAnspruch);
			ergebnisMengeLokal.updateInt(6, restUrlaub);
			ergebnisMengeLokal.updateInt(7, urlaubGesamt);

			ergebnisMengeLokal.insertRow();

		}
		catch (SQLException e) {
			e.printStackTrace();
			e.getCause().printStackTrace();
		}
		try {
			ergebnisMengeLokal.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbSchliessen();

	}

}
