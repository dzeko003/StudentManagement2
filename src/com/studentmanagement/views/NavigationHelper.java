package com.studentmanagement.views;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NavigationHelper {
	
	public void loadPage(ActionEvent event, String fxmlFileName) throws IOException {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/studentmanagement/views/" + fxmlFileName));
	    Pane pane = loader.load();
	    Scene scene = new Scene(pane);
	    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    window.setScene(scene);
	    window.show();
	    
	}

}
