package com.studentmanagement.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		//chargement de la page Connexion.fxml
		Parent root = FXMLLoader.load(getClass().getResource("Connexion.fxml"));

		 Scene scene = new Scene(root);
		 primaryStage.setTitle("studentmanagement"); 
		 primaryStage.setScene(scene);
		 primaryStage.show();
		 
	}
	
	public static void main(String[] args) {
//		System.out.println("bonjour");
		launch(args);
	}

}
