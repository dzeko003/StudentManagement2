package com.studentmanagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.studentmanagement.models.ModelEtudiant;
import com.studentmanagement.views.FxmlLoader;
import com.studentmanagement.views.NavigationHelper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class AccueilController implements Initializable {
	
	@FXML
    private AnchorPane Switch_form;

    @FXML
    private BarChart<String,Number> T_etudiantBarChart;

    @FXML
    private Label T_etudiantLabel;

    @FXML
    private AreaChart<?, ?> T_femmeAreaChart;

    @FXML
    private Label T_femmeLabel;

    @FXML
    private Label T_hommeLabel;

    @FXML
    private LineChart<?, ?> T_hommeLineChart;

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
    private AnchorPane chartContainer;
    
    
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

    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		int nbreEtud;
		int nbreEtudFemme;
		int nbreEtudHomme;
		
		ModelEtudiant me= new ModelEtudiant();
		
		
		nbreEtud=me.CalculNbreEtudiant();
		nbreEtudFemme=me.CalculNbreEtudiantFemme();
		nbreEtudHomme=me.CalculNbreEtudiantHomme();
		
		 T_etudiantLabel.setText(String.valueOf(nbreEtud));
		 T_femmeLabel.setText(String.valueOf(nbreEtudFemme));
		 T_hommeLabel.setText(String.valueOf(nbreEtudHomme));
		 
		 T_etudiantBarChart = me.totalEtudiantGraphe();
		
		 
		 AnchorPane.setTopAnchor(T_etudiantBarChart, 0.0);
		 AnchorPane.setLeftAnchor(T_etudiantBarChart, 0.0);
		 AnchorPane.setRightAnchor(T_etudiantBarChart, 0.0);
		 AnchorPane.setBottomAnchor(T_etudiantBarChart, 0.0);
		 chartContainer.getChildren().add(T_etudiantBarChart);
		
		
	}
    

   


 

}
