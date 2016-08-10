package urlaubsverwaltung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatenbankVerbindungen {

	/*
	 * Die Methode laedt den Treiber und stellt die Verbindung her
	 * zurueckgeliefert wird ein Connection-Objekt
	 * Uebergeben werden der Treiber und Argumente fuer das Oeffnen
	 */
	/**
	 * @param treiber
	 * @param arg
	 * @return
	 */
	protected Connection dbOeffnen(String treiber, String arg) {
		Connection verbindung = null;

		try {
			//Treiber laden
			Class.forName(treiber).newInstance();
			//die Datenbank heisst urlaubsverwaltungDB
			verbindung = DriverManager.getConnection(arg);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return verbindung;
	}

	/*
	 * Die Methode liefert eine Ergebnismenge
	 * uebergeben wird die Verbindung und der SQL Ausdruck
	 */
	/**
	 * @param verbindung
	 * @param sqlAnweisung
	 * @return
	 */
	protected ResultSet dbErgebnis(Connection verbindung, String sqlAnweisung){
		ResultSet ergebnisMenge = null;

		try {
			Statement ausdruck = verbindung.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ergebnisMenge = ausdruck.executeQuery(sqlAnweisung);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ergebnisMenge;
	}

	/*
	 * Die Methode faehrt das gesamte Datenbanksystem runter
	 * das wird bei der embedded Version von Java DB ausdruecklich empfohlen
	 * uebergeben wird das Protokoll
	 */
	/**
	 * @param protokoll
	 */
	protected void dbSchliessen(String protokoll){
		//das Herunterfahren loest eine Exception aus!
		boolean erfolg = false;
		try {
			DriverManager.getConnection(protokoll + ";shutdown=true");
		} catch (SQLException e) {
			erfolg = true;
			//e.printStackTrace();
		}
		if (erfolg != true){
			System.out.println("Die DB konnte nicht heruntergefahren werden!" + "Datenbankverbindung & dbSchliessen");
		}
	}

}
