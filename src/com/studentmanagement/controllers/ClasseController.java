package com.studentmanagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.studentmanagement.entities.Classe;
import com.studentmanagement.models.ModelClasse;
import com.studentmanagement.views.NavigationHelper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.BorderPane;


public class ClasseController implements Initializable {
	
	@FXML
	private TableView<Classe> classeTv;

    @FXML
    private Button accueilBtn;

    @FXML
    private Button classeBtn;

    @FXML
    private Button clearBtn;

    @FXML
    private Button enregistrerBtn;

    @FXML
    private Button etudiantBtn;

    @FXML
    private Button evaluationBtn;

    @FXML
    private TableColumn<Classe,Integer> idCol;

    @FXML
    private TextField idTf;

    @FXML
    private TableColumn<Classe,String> libelleCol;

    @FXML
    private TextField libelleTf;

    @FXML
    private Button matiereBtn;

    @FXML
    private TableColumn<Classe,String> matriculeCol;

    @FXML
    private TextField matriculeTf;

    @FXML
    private Button modifierBtn;

    @FXML
    private TextField rechecheTf;

    @FXML
    private Button resultatBtn;

    @FXML
    private Button statBtn;

    @FXML
    private Button supprimerBtn;

	
	
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
	    public void save(ActionEvent event) {
			 String libelle =  libelleTf.getText();
			 String matricule = matriculeTf.getText();
			 		 
			 if(libelle.equals("") || matricule.equals("")) {
				 
				 com.studentmanagement.tools.Notification.notifWarning("Enregistrement d'une ligne vide", "Vous avez omis de saisir un champ"); 
			 }
			 else {
				 
				Classe classe = new Classe(matricule,libelle);
				ModelClasse mc = new ModelClasse();
				mc.save(classe);
				 
				loadingClasse();
				
				idTf.setText("");
				matriculeTf.setText("");
				libelleTf.setText("");
				
				 com.studentmanagement.tools.Notification.notifSuccess("Enregistrement d'une classe", "classe enregistrée avec succès");
				 
			 }
				 
		 }
	   
	    @FXML
	    public void update(ActionEvent event) {
	    	int id = Integer.parseInt(idTf.getText());
	    	String matricule = matriculeTf.getText();
	    	String libelle = libelleTf.getText();
	    	
	    	Classe classe = new Classe(id,matricule,libelle);
	    	ModelClasse mc = new ModelClasse();
	    	mc.update(classe);
	    	
	    	loadingClasse();
	    	
	    	idTf.setText("");
	    	matriculeTf.setText("");
			libelleTf.setText("");
	    }
	    
	    @FXML
	    public void delete(ActionEvent event) {
	    	int id = Integer.parseInt(idTf.getText());
			String matricule = matriculeTf.getText();
			String libelle = libelleTf.getText();
			Classe classe = new Classe(id,matricule,libelle);
			ModelClasse mc = new ModelClasse();
			Alert mBox = new Alert(AlertType.CONFIRMATION);
			 mBox.setTitle("Suppression d'une classe");
			 mBox.setContentText("Voulez-vous vraiment supprimer cette classe ?");
			 Optional<ButtonType> reponse = mBox.showAndWait();
			 if(reponse.get()==ButtonType.OK)
			 {
				 mc.delete(classe);
				 
				 loadingClasse();
			    	
			    idTf.setText("");
			    matriculeTf.setText("");
				libelleTf.setText("");
				
				com.studentmanagement.tools.Notification.notifSuccess("Suppression d'une classe", "classe supprimée avec succès");
				 
			 }
	    	
	    }
	    
	    @FXML 
	    public void clear(ActionEvent event) {
	    	idTf.setText("");
		    matriculeTf.setText("");
			libelleTf.setText("");
	    	
	    }
	    
	    @FXML
	    public void tableClicked(MouseEvent event) {
	    	Classe classe = classeTv.getSelectionModel().getSelectedItem();
	    	int num = classeTv.getSelectionModel().getSelectedIndex();
	    	
	    	if ((num - 1) < -1) {
	            return;
	        }
	    	
	    	idTf.setText(String.valueOf(classe.getId()));
			matriculeTf.setText(classe.getIdClasse());
			libelleTf.setText(classe.getLibelleClasse());
			
			 modifierBtn.setDisable(false);
			 supprimerBtn.setDisable(false);
			 clearBtn.setDisable(false);
			 enregistrerBtn.setDisable(false);
	    	
	    }
	    
	    @FXML
		 public void search() {
		     String searchText = rechecheTf.getText().toLowerCase();

		     ObservableList<Classe> filteredList = FXCollections.observableArrayList();
		     ModelClasse mc = new ModelClasse();
		     List<Classe> liste = mc.findAll();

		     for (Classe classe : liste) {
		         if (String.valueOf(classe.getId()).toLowerCase().contains(searchText)
		                 || classe.getIdClasse().toLowerCase().contains(searchText)
		                 || classe.getLibelleClasse().toLowerCase().contains(searchText)){
		                
		             filteredList.add(classe);
		         }
		     }

		     classeTv.setItems(filteredList);
		 }

	    @FXML
		 public void matriculeAuto(KeyEvent event) {
			 String libelle = libelleTf.getText();
			 SimpleDateFormat dates = new SimpleDateFormat("yymmhhss");
			 Date date = new Date();
		     String chaine ="fst-clas";
		     matriculeTf.setText(chaine+"-"+dates.format(date));
		 }
	 
	    @FXML
	    public void loadingClasse() {
	    	ObservableList<Classe> obClasse = FXCollections.observableArrayList();
	    	ModelClasse mc = new ModelClasse();
	    	List<Classe> classeList = mc.findAll();
	    	for(Classe clas:classeList) {
	    		
	    		obClasse.add(clas);
	    	}
	    	
	    	classeTv.setItems(obClasse);
	    }
	    
	    
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
			idCol.setCellValueFactory(new PropertyValueFactory<Classe,Integer>("id"));
			libelleCol.setCellValueFactory(new PropertyValueFactory<Classe,String>("libelleClasse"));
			matriculeCol.setCellValueFactory(new PropertyValueFactory<Classe,String>("idClasse"));
			
			loadingClasse();
			
			modifierBtn.setDisable(false);
			supprimerBtn.setDisable(false);
			clearBtn.setDisable(false);
			enregistrerBtn.setDisable(false);
					
		}

}
