package com.studentmanagement.controllers;

import java.io.IOException;

import com.studentmanagement.views.NavigationHelper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class AccueilController2 {

    @FXML
    private Button accueilBtn;

    @FXML
    private Button classeBtn;

    @FXML
    private Button etudiantBtn;

    @FXML
    private Button evaluationBtn;

    @FXML
    private Button matiereBtn;

    @FXML
    private Button resultatBtn;

    @FXML
    private Button statBtn;
    
    @FXML
	private BorderPane borderPane;

    @FXML
    void loadAccueil(ActionEvent event) throws IOException {
    	NavigationHelper navigationHelper = new NavigationHelper();
        navigationHelper.loadPage(event, "Accueil.fxml");
    }

    @FXML
    void loadClasse(ActionEvent event) throws IOException {
    	NavigationHelper navigationHelper = new NavigationHelper();
        navigationHelper.loadPage(event, "Classe.fxml");
    
    }

    @FXML
    void loadComposer(ActionEvent event) throws IOException {
    	NavigationHelper navigationHelper = new NavigationHelper();
        navigationHelper.loadPage(event, "Composer.fxml");
    }

    @FXML
    void loadEtudiant(ActionEvent event) throws IOException {
    	NavigationHelper navigationHelper = new NavigationHelper();
        navigationHelper.loadPage(event, "Etudiant.fxml");
    }

    @FXML
    void loadMatiere(ActionEvent event) throws IOException {
    	NavigationHelper navigationHelper = new NavigationHelper();
        navigationHelper.loadPage(event, "Matiere.fxml");
    }

   
    @FXML
    void loadResultat(ActionEvent event) throws IOException {
    	NavigationHelper navigationHelper = new NavigationHelper();
        navigationHelper.loadPage(event, "Resultat.fxml");

    }

   
    @FXML
    void loadStatistique(ActionEvent event) throws IOException {
    	NavigationHelper navigationHelper = new NavigationHelper();
        navigationHelper.loadPage(event, "Statistique.fxml");

    }
    
    

}
