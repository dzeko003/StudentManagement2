package com.studentmanagement.views;
import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class FxmlLoader {
private Pane views;

private Parent root;
private Scene scene;
private Stage stage;

	
	public Pane getPage(String fileName) {
		try {
			URL fileURL = Main.class.getResource("/com/studentmanagement/views/"+fileName+".fxml");
			if(fileName == null) {
				throw new java.io.FileNotFoundException("Document FXML introuvable");
			}
			new FXMLLoader();
			views = FXMLLoader.load(fileURL);
		} catch (Exception e) {
			System.out.println("Pas de page "+fileName+", veuillez vérifier la classe FxmlLoader");
		}
		return views ;
	}
	
	
	public void loadFXML(String fxmlFileName) {
		
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/studentmanagement/views/"+fxmlFileName));
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	        Stage stage = new Stage();
	        stage.setScene(scene);
	        stage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
}

