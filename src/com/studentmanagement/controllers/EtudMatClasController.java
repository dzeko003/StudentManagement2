package com.studentmanagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.studentmanagement.entities.Classe;
import com.studentmanagement.entities.EtudMatClas;
import com.studentmanagement.models.ModelClasse;
import com.studentmanagement.models.ModelEtudMatClas;
import com.studentmanagement.views.NavigationHelper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EtudMatClasController implements Initializable {

    @FXML
    private Button accueilBtn;

    @FXML
    private Button admisBtn;

    @FXML
    private Button ajouneBtn;

    @FXML
    private Button classeBtn;

    @FXML
    private TableColumn<EtudMatClas,String> classeCol;

    @FXML
    private Button etudiantBtn;

    @FXML
    private Button evaluationBtn;

    @FXML
    private Button matiereBtn;

    @FXML
    private TableColumn<EtudMatClas, String> matriculeCol;

    @FXML
    private TableColumn<EtudMatClas,Double> moyenneCol;

    @FXML
    private TableColumn<EtudMatClas, String> nomCol;

    @FXML
    private TextField rechecheTf;

    @FXML
    private Button resultatBtn;

    @FXML
    private TableView<EtudMatClas> EtudMatClasTV;

    @FXML
    private TableColumn<EtudMatClas,String> sexeCol;

    @FXML
    private Button statBtn;

    @FXML
    private Button totalBtn;

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
    
    
    @FXML
    public void loadingEtudMatClas() {
		 ObservableList<EtudMatClas> etudMatClas = FXCollections.observableArrayList();
		 ModelEtudMatClas modelEtuMatClas = new ModelEtudMatClas();
		 List<EtudMatClas> etudMatClasList = modelEtuMatClas.findAll();
		 
		 for(EtudMatClas etu : etudMatClasList) {
			 etudMatClas.add(etu);
		 }
		
		 
		EtudMatClasTV.setItems(etudMatClas);
	 }
    
    
    /*
    @FXML
	 public void search() {
	     String searchText = rechecheTf.getText().toLowerCase();

	     ObservableList<EtudMatClas> filteredList = FXCollections.observableArrayList();
	     ModelEtudMatClas memc = new ModelEtudMatClas();
	    
	     List<EtudMatClas> liste = memc.findAll();

	     for (EtudMatClas emc : liste) {
	    	 String moyenneText = String.valueOf(EtudMatClas.).toLowerCase();

	         if (String.valueOf(emc.getClasse().toLowerCase().contains(searchText)
	                 || emc.getMatricule().toLowerCase().contains(searchText)
	                 || emc.getNom().toLowerCase().contains(searchText)
	                 || emc.getSexe().toLowerCase().contains(searchText)
	                 || emc.contains(searchText)){
	                
	             filteredList.add(classe);
	         }
	     }

	     classeTv.setItems(filteredList);
	 }

*/
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		classeCol.setCellValueFactory(new PropertyValueFactory<EtudMatClas,String>("classe"));
		matriculeCol.setCellValueFactory(new PropertyValueFactory<EtudMatClas,String>("matricule"));
		nomCol.setCellValueFactory(new PropertyValueFactory<EtudMatClas,String>("nom"));
		sexeCol.setCellValueFactory(new PropertyValueFactory<EtudMatClas,String>("sexe"));
		moyenneCol.setCellValueFactory(new PropertyValueFactory<EtudMatClas,Double>("moyenne"));
		
		loadingEtudMatClas();
		
		ModelEtudMatClas memc = new ModelEtudMatClas();
		
		memc.findAll();
		
	}

}
