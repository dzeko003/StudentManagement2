package com.studentmanagement.controllers;

import java.io.IOException;
import java.net.URL;
//import java.sql.SQLException;
import java.util.ResourceBundle;

import com.studentmanagement.models.ModelUtilisateur;
import com.studentmanagement.tools.Notification;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;

public class ConnexionController implements Initializable {
	    @FXML
	    private Button loginBtn;

	    @FXML
	    private PasswordField passwordPf;

	    @FXML
	    private TextField usernameTf;
	// 
	private Parent root;
	private Stage stage;
	private Scene scene;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
   
	public void login(ActionEvent event) {
		// Récuperation des données du formulaire
		String username=usernameTf.getText();
		String password=passwordPf.getText();
		//System.out.println(username+" "+password);
		//instanciation de la classe UserModel
		ModelUtilisateur userModel = new ModelUtilisateur();
		
		//vérification des paramètres de l'utilisateur
		
			if(userModel.isLogin(username,password)) {
				//System.out.println("connecté");
				// appel
				FXMLLoader loader =new FXMLLoader(getClass().getResource("/com/studentmanagement/views/Accueil2.fxml"));
				
				try {
					// chargement
					root=loader.load();
					// fenetre principale
					stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
					// lieu
					scene=new Scene(root);
					
					stage.setScene(scene); // recuperer la scene
					
					stage.centerOnScreen(); // afficher la fenetre au milieu
					stage.setFullScreen(false); // Occupe toute la fen de l'ordinateur
					
					stage.show(); // montre la scene
					
//					Notification.notifSuccess("Paramètres correctes", "Connexion réussie");
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				//System.out.println("pas connecté");
				Notification.notifError("Paramètres incorrectes", "Nom utilisateur ou mot de passe incorrecte");
			}
		
	}
	
}
