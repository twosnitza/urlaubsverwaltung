package urlaubsverwaltung;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mitarbeiter {

	// Propertys "Synchronisierung"
	private StringProperty vorname;
	private StringProperty name;
	private IntegerProperty urlaubsanspruch;
	private IntegerProperty resturlaub;
	private IntegerProperty urlaubgesamt;
	private StringProperty vertretung;

	// standard Konstruktor
	public Mitarbeiter() {

	}

	/**
	 * @param name
	 * @param vorname
	 * @param urlaubsanspruch
	 * @param resturlaub
	 * @param genUrlaub
	 * @param vertretung
	 */
	public Mitarbeiter(String name, String vorname, int urlaubsanspruch, int resturlaub, int urlaubgesamt,
			String vertretung) {
		this.name = new SimpleStringProperty(name);
		this.vorname = new SimpleStringProperty(vorname);
		this.urlaubsanspruch = new SimpleIntegerProperty(urlaubsanspruch);
		this.resturlaub = new SimpleIntegerProperty(resturlaub);
		this.urlaubgesamt = new SimpleIntegerProperty(urlaubgesamt);
		this.vertretung = new SimpleStringProperty(vertretung);
	}

	/**
	 * @return the vorname
	 */
	public StringProperty getVorname() {
		return vorname;
	}

	/**
	 * @param vorname the vorname to set
	 */
	public void setVorname(StringProperty vorname) {
		this.vorname = vorname;
	}

	/**
	 * @return the name
	 */
	public StringProperty getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(StringProperty name) {
		this.name = name;
	}

	/**
	 * @return the urlaubsanspruch
	 */
	public IntegerProperty getUrlaubsanspruch() {
		return urlaubsanspruch;
	}

	/**
	 * @param urlaubsanspruch the urlaubsanspruch to set
	 */
	public void setUrlaubsanspruch(IntegerProperty urlaubsanspruch) {
		this.urlaubsanspruch = urlaubsanspruch;
	}

	/**
	 * @return the resturlaub
	 */
	public IntegerProperty getResturlaub() {
		return resturlaub;
	}

	/**
	 * @param resturlaub the resturlaub to set
	 */
	public void setResturlaub(IntegerProperty resturlaub) {
		this.resturlaub = resturlaub;
	}

	/**
	 * @return
	 */
	public IntegerProperty getUrlaubgesamt() {
		return urlaubgesamt;
	}

	/**
	 * @param urlaubsgesamt
	 */
	public void setUrlaubgesamt(IntegerProperty urlaubgesamt) {
		this.urlaubgesamt = urlaubgesamt;
	}

	/**
	 * @return the vertretung
	 */
	public StringProperty getVertretung() {
		return vertretung;
	}

	/**
	 * @param vertretung the vertretung to set
	 */
	public void setVertretung(StringProperty vertretung) {
		this.vertretung = vertretung;
	}

}
