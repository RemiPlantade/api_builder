package fr.aboucorp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class FXMLController implements Initializable{
	@FXML
	private ListView<String> listview;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listview = new ListView<String>();
		
	}
}
