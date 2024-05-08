package com.studentmanagement.controllers;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.studentmanagement.entities.Classe;
import com.studentmanagement.entities.Etudiant;
import com.studentmanagement.entities.Matiere;
import com.studentmanagement.models.ModelClasse;
import com.studentmanagement.models.ModelEtudiant;
import com.studentmanagement.models.ModelMatiere;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class MatiereController implements Initializable{

	@FXML
    private TableView<Matiere> MatiereTv;
	
	@FXML
	private TableColumn<Matiere,Classe> classeCol;

    @FXML
    private Button accueilBtn;

    @FXML
    private Button classeBtn;

    @FXML
    private ComboBox<Classe> classeCb;

    @FXML
    private Button clearBtn;

    @FXML
    private Button enregistrerBtn;

    @FXML
    private Button etudiantBtn;

    @FXML
    private Button evaluationBtn;

    @FXML
    private TableColumn<Matiere,Integer> idCol;

    @FXML
    private TextField idTf;

    @FXML
    private TableColumn<Matiere,String> libelleCol;

    @FXML
    private TextField libelleTf;

    @FXML
    private Button matiereBtn;

    @FXML
    private TableColumn<Matiere,String> matriculeCol;

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
		 public void matriculeAuto(KeyEvent event) {
			 String libelle = libelleTf.getText();
			 SimpleDateFormat dates = new SimpleDateFormat("yymmhhss");
			 Date date = new Date();
		     String chaine ="fstmat";
		     matriculeTf.setText(chaine+dates.format(date));
		 }
	    
	   @FXML
	    public void save(ActionEvent event) {
			 String libelle =  libelleTf.getText();
			 String matricule = matriculeTf.getText();
			 Classe classe=classeCb.getValue();
			 		 
			 if(libelle.equals("") || matricule.equals("") || classe == null) {
				 
				 com.studentmanagement.tools.Notification.notifWarning("Enregistrement d'une ligne vide", "Vous avez omis de saisir un champ"); 
			 }
			 else {
				 
				Matiere matiere = new Matiere(matricule,libelle,classe);
				ModelMatiere mm = new ModelMatiere();
				mm.save(matiere);
				 
				loadingMatiere();
				loadingClasse();
				
				idTf.setText("");
				matriculeTf.setText("");
				libelleTf.setText("");
				classeCb.setValue(null);
				
				 com.studentmanagement.tools.Notification.notifSuccess("Enregistrement d'une Matiere", "Matiere enregistrée avec succès");
				 
			 }
				 
		 }
	   
	   @FXML
	   public void update(ActionEvent event) {
		   int id = Integer.parseInt(idTf.getText());
	    	String matricule = matriculeTf.getText();
	    	String libelle = libelleTf.getText();
	    	Classe classe = classeCb.getValue();
	    	
	    	Matiere matiere = new Matiere(id,matricule,libelle,classe);
	    	ModelMatiere mm = new ModelMatiere();
	    	mm.update(matiere);
	    	
	    	loadingMatiere();
			loadingClasse();
			
			idTf.setText("");
			matriculeTf.setText("");
			libelleTf.setText("");
			classeCb.setValue(null);
		   
	   }
	   
	   @FXML
	   public void delete(ActionEvent event) {
		   
		   int id = Integer.parseInt(idTf.getText());
			String matricule = matriculeTf.getText();
			String libelle = libelleTf.getText();
			Classe classe = classeCb.getValue();
			
			Matiere matiere = new Matiere(id,matricule,libelle,classe);
	    	ModelMatiere mm = new ModelMatiere();
	    	
			Alert mBox = new Alert(AlertType.CONFIRMATION);
			 mBox.setTitle("Suppression d'une matiere");
			 mBox.setContentText("Voulez-vous vraiment supprimer cette matiere ?");
			 Optional<ButtonType> reponse = mBox.showAndWait();
			 if(reponse.get()==ButtonType.OK)
			 {
				 mm.delete(matiere);;
				 
				 loadingMatiere();
				 loadingClasse();
			    	
				 idTf.setText("");
				 matriculeTf.setText("");
				 libelleTf.setText("");
				 classeCb.setValue(null);
				
				com.studentmanagement.tools.Notification.notifSuccess("Suppression d'une matiere", "matiere supprimée avec succès");
				 
			 }
		   
	   }
	   
	   
	   @FXML
		 public void search() {
		     String searchText = rechecheTf.getText().toLowerCase();

		     ObservableList<Matiere> filteredList = FXCollections.observableArrayList();
		     ModelMatiere mm = new ModelMatiere();
		     List<Matiere> liste = mm.findAll();

		     for (Matiere matiere : liste) {
		         if (String.valueOf(matiere.getId()).toLowerCase().contains(searchText)
		                 || matiere.getIdMat().toLowerCase().contains(searchText)
		                 || matiere.getLibelleMat().toLowerCase().contains(searchText)
		                 ||matiere.getClasse().getLibelleClasse().toLowerCase().contains(searchText)) {
		                
		             filteredList.add(matiere);
		         }
		     }

		     MatiereTv.setItems(filteredList);
		 }
		 
	   
	   @FXML
	   public void clear(ActionEvent event) { 
		     idTf.setText("");
			 matriculeTf.setText("");
			 libelleTf.setText("");
			 classeCb.setValue(null);
	   }
	   
	   
	   @FXML
	    public void tableClicked(MouseEvent event) {
	    	Matiere matiere = MatiereTv.getSelectionModel().getSelectedItem();
	    	int num = MatiereTv.getSelectionModel().getSelectedIndex();
	    	
	    	if ((num - 1) < -1) {
	            return;
	        }
	    	
	    	idTf.setText(String.valueOf(matiere.getId()));
			matriculeTf.setText(matiere.getIdMat());
			libelleTf.setText(matiere.getLibelleMat());
			classeCb.setValue(matiere.getClasse());
			
			modifierBtn.setDisable(false);
			supprimerBtn.setDisable(false);
			clearBtn.setDisable(false);
			enregistrerBtn.setDisable(false);
	    	
	    }
	   
	   @FXML
	    public void loadingClasse() {
	    	ObservableList<Classe> obClasse = FXCollections.observableArrayList();
	    	ModelClasse mc = new ModelClasse();
	    	List<Classe> classeList = mc.findAll();
	    	for(Classe clas:classeList) {
	    		
	    		obClasse.add(clas);
	    	}
	    	
	    	classeCb.setItems(obClasse);
	    }
	   
	   @FXML
	   public void loadingMatiere() {
		   
		   ObservableList<Matiere> matieres = FXCollections.observableArrayList();
		   ModelMatiere mm = new ModelMatiere();
		   List<Matiere> matiereList = mm.findAll();
		   
		   for(Matiere mat: matiereList) {
			   matieres.add(mat);
		   }
		   
		   MatiereTv.setItems(matieres);
		   
	   }
	   
	   @Override
		public void initialize(URL location, ResourceBundle resources) {
			   idCol.setCellValueFactory(new PropertyValueFactory<Matiere,Integer>("id"));
			   matriculeCol.setCellValueFactory(new PropertyValueFactory<Matiere,String>("idMat"));
			   libelleCol.setCellValueFactory(new PropertyValueFactory<Matiere,String>("libelleMat"));
			   classeCol.setCellValueFactory(new PropertyValueFactory<Matiere,Classe>("classe"));
			   
			   loadingMatiere();
			   loadingClasse();
			   
			   modifierBtn.setDisable(false);
				supprimerBtn.setDisable(false);
				clearBtn.setDisable(false);
				enregistrerBtn.setDisable(false);
			
		}


}
