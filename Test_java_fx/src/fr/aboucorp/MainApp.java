package fr.aboucorp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private BorderPane rootLayout;
	@Override
	public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Test javafx");
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/FXMLView.fxml"));
        rootLayout = (BorderPane) loader.load();
        FXMLController controller = loader.getController();
        Scene scene = new Scene(rootLayout);
    
        primaryStage.setScene(scene);
        primaryStage.show();
	}

}
