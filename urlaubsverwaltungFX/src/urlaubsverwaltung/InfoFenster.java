package urlaubsverwaltung;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;

public class InfoFenster {

	protected void programmInfo() {
		String copyRight = new String("\u00a9");
		Alert infoFenster = new Alert(AlertType.INFORMATION);
		infoFenster.setTitle("Urlaubsverwaltung Alfa 0.1");
		infoFenster.setHeaderText("Urlaubsverwaltung " + "Timo Wosnitza " + copyRight + " 2016" + "\n"
				+ "Erstellt mit: \n" + "Linux\n" + "Eclipse\n" + "JavaDB\n" + "Scenebuilder");
		infoFenster.setGraphic(new ImageView(this.getClass().getResource("gnu.jpeg").toString()));
		infoFenster.showAndWait();
	}

}
