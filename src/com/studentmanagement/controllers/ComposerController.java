package com.studentmanagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.studentmanagement.entities.Classe;
import com.studentmanagement.entities.Composer;
import com.studentmanagement.entities.Etudiant;
import com.studentmanagement.entities.Matiere;
import com.studentmanagement.models.ModelClasse;
import com.studentmanagement.models.ModelComposer;
import com.studentmanagement.models.ModelEtudMatClas;
import com.studentmanagement.models.ModelEtudiant;
import com.studentmanagement.models.ModelMatiere;
import com.studentmanagement.tools.Notification;
import com.studentmanagement.views.NavigationHelper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ComposerController implements Initializable{

    @FXML
    private Button accueilBtn;

    @FXML
    private ComboBox<String> anneeAcCb;

    @FXML
    private TableColumn<Composer, String> anneeAcCol;

    @FXML
    private Button classeBtn;

    @FXML
    private ComboBox<Classe> classeCb;

    @FXML
    private TableColumn<Composer,Classe> classeCol;

    @FXML
    private Button clearBtn;

    @FXML
    private TableView<Composer> composerTv;

    @FXML
    private Button enregistrerBtn;

    @FXML
    private Button etudiantBtn;

    @FXML
    private ComboBox<Etudiant> etudiantCb;

    @FXML
    private TableColumn<Composer,Etudiant> etudiantCol;

    @FXML
    private Button evaluationBtn;

    @FXML
    private TableColumn<Composer,Integer> idCol;

    @FXML
    private TextField idTf;

    @FXML
    private ImageView imageIv;

    @FXML
    private Button matiereBtn;

    @FXML
    private ComboBox<Matiere> matiereCb;

    @FXML
    private TableColumn<Composer,Matiere> matiereCol;

    @FXML
    private Button modifierBtn;

    @FXML
    private ComboBox<String> natureEvalCb;

    @FXML
    private TableColumn<Composer,String> natureEvalCol;

    @FXML
    private TableColumn<Composer,Double> noteEvalCol;

    @FXML
    private TextField noteTf;

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
	    
	    
	    private String[] anneAcList = {"2021-2022","2022-2023","2023-2024"};
	    private String[] natureEvalList= {"Ordinaire","Rattrapage"};

	    
	    public void ajouterAnneAc() {
	    	List<String> anneAcL = new ArrayList<>();
	    	
	    	for(String data : anneAcList ) {
	    		anneAcL.add(data);
	    	}
	    	
	    	ObservableList obList = FXCollections.observableArrayList(anneAcL);
	    	anneeAcCb.setItems(obList);
	    }
	    
	    
	    public void ajouterNatureEval() {
	    	List<String> natureEvalL = new ArrayList<>();
	    	for(String data :natureEvalList ) {
	    		
	    		natureEvalL.add(data);
	    	}
	    	
	    	ObservableList obList = FXCollections.observableArrayList(natureEvalL);
	    	natureEvalCb.setItems(obList);
	    }
	    
	    
	   
	    public void loadingMatiere() {
	    	ObservableList<Matiere> obMatiere = FXCollections.observableArrayList();
	    	ModelMatiere mm = new ModelMatiere();
	    	List<Matiere> matiereList = mm.findAll();
	    	
	    	for(Matiere mat : matiereList) {
	    		
	    		obMatiere.add(mat);
	    		
	    	}
	    	
	    	matiereCb.setItems(obMatiere);
	    }
	    
	    
	    public void loadingClasse() {
	    	ObservableList<Classe> obClasse = FXCollections.observableArrayList();
	    	ModelClasse mc = new ModelClasse();
	    	List<Classe> classeList = mc.findAll();
	    	for(Classe clas:classeList) {
	    		
	    		obClasse.add(clas);
	    	}
	    	
	    	classeCb.setItems(obClasse);
	    }
	    
	  
	    public void loadingEtudiant() {
	    	ObservableList<Etudiant> obEtudiant = FXCollections.observableArrayList();
	    	ModelEtudiant me = new ModelEtudiant();
	    	List<Etudiant> etudiantL = me.findAll();
	    	
	    	for(Etudiant etu : etudiantL) {
	    		
	    		obEtudiant.add(etu);
	    		
	    	}
	    	
	    	etudiantCb.setItems(obEtudiant);
	    }
	    
	    public void loadingComposer() {
	    	ObservableList<Composer> obComposer = FXCollections.observableArrayList();
	    	ModelComposer mc = new ModelComposer();
	    	List<Composer> composerL = mc.findAll();
	    	
	    	for(Composer com :composerL ) {
	    		
	    		obComposer.add(com);
	    	}
	    	
	    	composerTv.setItems(obComposer);
	    }
	    
	    @FXML
	    public void save(ActionEvent event) {
	    	
	    	Etudiant etudiant = etudiantCb.getValue();
	    	Classe classe = classeCb.getValue();
	    	Matiere matiere= matiereCb.getValue();
	    	String natureEval = natureEvalCb.getValue();
	    	String anneAc = anneeAcCb.getValue();
	    	String noteText = noteTf.getText();
	    	
	    	if(etudiant==null || classe==null || matiere==null || natureEval.equals("") || anneAc.equals("") || noteText.isEmpty()) {
	    		com.studentmanagement.tools.Notification.notifWarning("Enregistrement d'une ligne vide", "Vous avez omis de saisir un champ");
	    	}
	    	else if(!noteText.matches("\\d+(\\.\\d+)?")) {
	    		Notification.notifWarning("Saisie incorrecte", "Veuillez saisir un nombre valide pour la note");	
	    	}
	    	else{
	    		Double note = Double.parseDouble(noteText);
	    		Composer composer = new Composer(natureEval,note,anneAc,etudiant,matiere,classe);
	    		ModelComposer mc = new ModelComposer();
	    		mc.save(composer);
	    		
	    		loadingClasse();
	     		loadingMatiere();
	     		loadingEtudiant();
	     		loadingComposer();
	     		
	     		idTf.setText("");
	     		classeCb.setValue(null);
	     		etudiantCb.setValue(null);
	     		matiereCb.setValue(null);
	     		natureEvalCb.setValue(null);
	     		anneeAcCb.setValue(null);
	     		noteTf.setText(null);
	     		
	     		com.studentmanagement.tools.Notification.notifSuccess("Enregistrement d'une Evaluation", "Evaluation enregistrée avec succès");
	    	}
	     		 	
	    }
	    
	    @FXML
    	public void update(ActionEvent event) {
	    	
	    	int id = Integer.parseInt(idTf.getText());
	    	Etudiant etudiant = etudiantCb.getValue();
	    	Classe classe = classeCb.getValue();
	    	Matiere matiere= matiereCb.getValue();
	    	String natureEval = natureEvalCb.getValue();
	    	String anneAc = anneeAcCb.getValue();
	    	Double note = Double.parseDouble(noteTf.getText());
	    	
	    	Composer composer = new Composer(id,natureEval,note,anneAc,etudiant,matiere,classe);
    		ModelComposer mc = new ModelComposer();
	    	mc.update(composer);
	    	
	    	
	    	loadingClasse();
     		loadingMatiere();
     		loadingEtudiant();
     		loadingComposer();
     		
     		idTf.setText("");
     		classeCb.setValue(null);
     		etudiantCb.setValue(null);
     		matiereCb.setValue(null);
     		natureEvalCb.setValue(null);
     		anneeAcCb.setValue(null);
     		noteTf.setText(null);
    		
    	}
	    
	    @FXML
	    public void delete(ActionEvent event) {
	    	
	    	int id = Integer.parseInt(idTf.getText());
	    	Etudiant etudiant = etudiantCb.getValue();
	    	Classe classe = classeCb.getValue();
	    	Matiere matiere= matiereCb.getValue();
	    	String natureEval = natureEvalCb.getValue();
	    	String anneAc = anneeAcCb.getValue();
	    	Double note = Double.parseDouble(noteTf.getText());
	    	
	    	Composer composer = new Composer(id,natureEval,note,anneAc,etudiant,matiere,classe);
    		ModelComposer mc = new ModelComposer();
    		
    		Alert mBox = new Alert(AlertType.CONFIRMATION);
			 mBox.setTitle("Suppression d'une matiere");
			 mBox.setContentText("Voulez-vous vraiment supprimer cette evaluation ?");
			 Optional<ButtonType> reponse = mBox.showAndWait();
			 if(reponse.get()==ButtonType.OK)
			 {
				 mc.delete(composer);
				 
				     loadingClasse();
		     		loadingMatiere();
		     		loadingEtudiant();
		     		loadingComposer();
		     		
		     		idTf.setText("");
		     		classeCb.setValue(null);
		     		etudiantCb.setValue(null);
		     		matiereCb.setValue(null);
		     		natureEvalCb.setValue(null);
		     		anneeAcCb.setValue(null);
		     		noteTf.setText(null);
				
				com.studentmanagement.tools.Notification.notifSuccess("Suppression d'une evaluation", "evaluation supprimée avec succès");
				 
			 }	
	    }
	    
	    @FXML
	    public void clear(ActionEvent event) {
	    	
	    	idTf.setText("");
     		classeCb.setValue(null);
     		etudiantCb.setValue(null);
     		matiereCb.setValue(null);
     		natureEvalCb.setValue(null);
     		anneeAcCb.setValue(null);
     		noteTf.setText(null);
	    	
	    }
	    
	    @FXML
	    public void tableClicked(MouseEvent event) {
	    	Composer composer = composerTv.getSelectionModel().getSelectedItem();
	    	int num = composerTv.getSelectionModel().getSelectedIndex();
	    	
	    	if ((num - 1) < -1) {
	            return;
	        }
	    	
	    	idTf.setText(String.valueOf(composer.getId()));
	    	classeCb.setValue(composer.getClasse());
     		etudiantCb.setValue(composer.getEtudiant());
     		matiereCb.setValue(composer.getMatiere());
     		natureEvalCb.setValue(composer.getNatureEval());
     		anneeAcCb.setValue(composer.getAnneAc());
     		noteTf.setText(""+composer.getNoteEval());
			
			modifierBtn.setDisable(false);
			supprimerBtn.setDisable(false);
			clearBtn.setDisable(false);
			enregistrerBtn.setDisable(false);
	    	
	    }
	    
	   
	    @FXML
	    public void search() {
	        String searchText = rechecheTf.getText().toLowerCase();

	        ObservableList<Composer> filteredList = FXCollections.observableArrayList();
	        ModelComposer mc = new ModelComposer();
	        List<Composer> liste = mc.findAll();

	        for (Composer composer : liste) {
	            String noteText = String.valueOf(composer.getNoteEval()).toLowerCase();

	            if (String.valueOf(composer.getId()).toLowerCase().contains(searchText)
	                    || composer.getEtudiant().getNom().toLowerCase().contains(searchText)
	                    || composer.getAnneAc().toLowerCase().contains(searchText)
	                    || composer.getClasse().getLibelleClasse().toLowerCase().contains(searchText)
	                    || composer.getMatiere().getLibelleMat().toLowerCase().contains(searchText)
	                    || composer.getNatureEval().toLowerCase().contains(searchText)
	                    || noteText.contains(searchText)) {

	                filteredList.add(composer);
	            }
	        }

	        composerTv.setItems(filteredList);
	    }

	    
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
			
			idCol.setCellValueFactory(new PropertyValueFactory<Composer,Integer>("id"));
			natureEvalCol.setCellValueFactory(new PropertyValueFactory<Composer,String>("natureEval"));
			noteEvalCol.setCellValueFactory(new PropertyValueFactory<Composer,Double>("noteEval"));
			anneeAcCol.setCellValueFactory(new PropertyValueFactory<Composer,String>("anneAc"));
			
			etudiantCol.setCellValueFactory(new PropertyValueFactory<Composer,Etudiant>("etudiant"));
			matiereCol.setCellValueFactory(new PropertyValueFactory<Composer,Matiere>("matiere"));
			classeCol.setCellValueFactory(new PropertyValueFactory<Composer,Classe>("classe"));
			
			ajouterAnneAc();
			ajouterNatureEval();
			loadingClasse();
     		loadingMatiere();
     		loadingEtudiant();
     		loadingComposer();
     		
     		ModelEtudMatClas memc = new ModelEtudMatClas();
    		
    		memc.findAll();
		}
}
