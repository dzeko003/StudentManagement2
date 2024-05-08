package com.studentmanagement.controllers;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.UUID;

import com.studentmanagement.entities.Etudiant;
import com.studentmanagement.models.ModelEtudiant;
import com.studentmanagement.views.NavigationHelper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;



public class EtudiantController implements Initializable{
	
	@FXML
	private AnchorPane main_form;

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
    private TableView<Etudiant> etudiantTv;

    @FXML
    private Button evaluationBtn;

    @FXML
    private TableColumn<Etudiant, Integer> idCol;

    @FXML
    private TextField idTf;

    @FXML
    private ImageView imageIv;

    @FXML
    private Button insererBtn;

    @FXML
    private TableColumn<Etudiant, String> mailCol;

    @FXML
    private TextField mailTf;

    @FXML
    private Button matiereBtn;

    @FXML
    private TableColumn<Etudiant, String> matriculeCol;

    @FXML
    private TextField matriculeTf;

    @FXML
    private Button modifierBtn;

    @FXML
    private TableColumn<Etudiant, String> nomCol;

    @FXML
    private TextField nomTf;

    @FXML
    private TextField rechecheTf;

    @FXML
    private Button resultatBtn;

    @FXML
    private ComboBox<String> sexeCb;

    @FXML
    private TableColumn<Etudiant, String> sexeCol;

    @FXML
    private Button statBtn;

    @FXML
    private Button supprimerBtn;
    
    @FXML
    private TableColumn<Etudiant, String> photoCol;

	
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
	    
	     
	 private ObservableList<Etudiant> ObEtudiant ;
	 private String[] genreList = {"Masculin", "Feminin"};
	 private Image image;
	 private ObservableList<Etudiant> etudiants;

	    
	 @FXML
	 public void AjouterGenreList()
	 {
	        List<String> genreL = new ArrayList<>();

	        for (String data : genreList ) {
	            genreL.add(data);
	        }

	        ObservableList ObList = FXCollections.observableArrayList(genreL);
	        sexeCb.setItems(ObList);
	 }
	  
	
	 @FXML 
	 public void save(ActionEvent event) {
		 String matricule =  matriculeTf.getText();
		 String nom = nomTf.getText();
		 String sexe = ""+sexeCb.getValue();
		 String mail = mailTf.getText();
		 String photo = getData.path;
		 		 
		 if(matricule.equals("") || nom.equals("") || sexe.equals("") || mail.equals("") || photo.equals("")) {
			 
			 com.studentmanagement.tools.Notification.notifWarning("Enregistrement d'une ligne vide", "Vous avez omis de saisir un champ"); 
		 }
		 else {
			 
			 Etudiant etudiant = new Etudiant(matricule,nom,mail,photo,sexe);
			 ModelEtudiant me = new ModelEtudiant();
			 me.save(etudiant);
			 loadingEtudiant();
			 
			 // Mise a jour du graphe
			 
			 me.totalEtudiantGraphe();
			 me.CalculNbreEtudiant();
			 me.CalculNbreEtudiantFemme();
			 me.CalculNbreEtudiantHomme();
			 
			 idTf.setText("");
			 matriculeTf.setText("");
			 nomTf.setText("");
			 sexeCb.setValue(null);
			 mailTf.setText("");
			 imageIv.setImage(null);
			 com.studentmanagement.tools.Notification.notifSuccess("Enregistrement d'un etudiant", "etudiant enregistrée avec succès");
			 
		 }
			 
	 }
	 
	 @FXML
	 public void clear(ActionEvent event) {
		 idTf.setText("");
		 matriculeTf.setText("");
		 nomTf.setText("");
		 sexeCb.setValue(null);
		 mailTf.setText("");
		 imageIv.setImage(null);
	 }
	 
	 @FXML
	 public void update(ActionEvent event) {
		 int id = Integer.parseInt(idTf.getText());
		 String matricule = matriculeTf.getText();
		 String nom = nomTf.getText();
		 String sexe = ""+sexeCb.getValue();
		 String mail = mailTf.getText();
		 
		 String photo = getData.path;
		
		 Etudiant etudiant = new Etudiant(id,matricule,nom,mail,photo,sexe);
		 
		 ModelEtudiant me = new ModelEtudiant();
		 me.update(etudiant);
		 
		 loadingEtudiant();
		 
		// Mise a jour du graphe
	    me.totalEtudiantGraphe();
		me.CalculNbreEtudiant();
	    me.CalculNbreEtudiantFemme();
		me.CalculNbreEtudiantHomme();
		
		 idTf.setText("");
		 matriculeTf.setText("");
		 nomTf.setText("");
		 sexeCb.setValue(null);
		 mailTf.setText("");
		 imageIv.setImage(null);
		 
	 }
	 
	 @FXML
	 public void delete(ActionEvent event) {
		 int id = Integer.parseInt(idTf.getText());
		 String matricule = matriculeTf.getText();
		 String nom = nomTf.getText();
		 String sexe = ""+sexeCb.getValue();
		 String mail = mailTf.getText();
		 String photo = getData.path;
		 
         Etudiant etudiant = new Etudiant(id,matricule,nom,mail,photo,sexe);
		 
		 ModelEtudiant me = new ModelEtudiant();
		 Alert mBox = new Alert(AlertType.CONFIRMATION);
		 mBox.setTitle("Suppression d'un etudiant");
		 mBox.setContentText("Voulez-vous vraiment supprimer cet etudiant ?");
		 Optional<ButtonType> reponse = mBox.showAndWait();
		 if(reponse.get()==ButtonType.OK)
		 {
			 me.delete(etudiant);
			 
			 loadingEtudiant();
			 
			// Mise a jour du graphe
			 me.totalEtudiantGraphe();
			 me.CalculNbreEtudiant();
			 me.CalculNbreEtudiantFemme();
			 me.CalculNbreEtudiantHomme();

				
			 idTf.setText("");
			 matriculeTf.setText("");
			 nomTf.setText("");
			 sexeCb.setValue(null);
			 mailTf.setText("");
			 imageIv.setImage(null);
			 
			 com.studentmanagement.tools.Notification.notifSuccess("Suppression d'un etudiant", "etudiant supprimée avec succès");
			
		 }
		 

		 
	 }
	 
	 
	 
	 @FXML
	 public void matriculeAuto(KeyEvent event) {
		 String nom = nomTf.getText();
		 SimpleDateFormat dates = new SimpleDateFormat("yymmhhss");
		 Date date = new Date();
	     String chaine ="fstetud";
	     matriculeTf.setText(chaine+dates.format(date));
	 }
	 

	 @FXML
	 public void AjouterImage() {
		 FileChooser open = new FileChooser();
		 open.setTitle("Open Image File");
	     open.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));
	     File file = open.showOpenDialog(main_form.getScene().getWindow());
	     if (file != null) {
	    	 
	    	 image = new Image(file.toURI().toString(), 202, 215, false, true);
	    	 imageIv.setImage(image);
	    	 
	    	 getData.path=file.getAbsolutePath();
	    	 
	     }
		 
	 }
	 
	 
	 @FXML
	 public void tableClicked(MouseEvent event) {
		 Etudiant etudiant = etudiantTv.getSelectionModel().getSelectedItem();
		 int num = etudiantTv.getSelectionModel().getSelectedIndex();
		 
		 if ((num - 1) < -1) {
	            return;
	        }
		 
		 idTf.setText(String.valueOf(etudiant.getId()));
		 matriculeTf.setText(etudiant.getMatriEt());
		 nomTf.setText(etudiant.getNom());
		 sexeCb.setValue(etudiant.getSexe());
		 mailTf.setText(etudiant.getMail());
		 		 
		 String imagePath = etudiant.getPhoto();
		 File imageFile = new File(imagePath);
		 Image image = new Image(imageFile.toURI().toString(), 202, 215, false, true);
		 
		 imageIv.setImage(image);
		 
		 getData.path = etudiant.getPhoto();
		 
		 modifierBtn.setDisable(false);
		 supprimerBtn.setDisable(false);
		 clearBtn.setDisable(false);
		 enregistrerBtn.setDisable(false);
		 
	 }
	 
	 
	 @FXML
	 public void search() {
	     String searchText = rechecheTf.getText().toLowerCase();

	     ObservableList<Etudiant> filteredList = FXCollections.observableArrayList();
	     ModelEtudiant me = new ModelEtudiant();
	     List<Etudiant> liste = me.findAll();

	     for (Etudiant etudiant : liste) {
	         if (String.valueOf(etudiant.getId()).toLowerCase().contains(searchText)
	                 || etudiant.getMatriEt().toLowerCase().contains(searchText)
	                 || etudiant.getNom().toLowerCase().contains(searchText)
	                 || etudiant.getSexe().toLowerCase().contains(searchText)
	                 || etudiant.getMail().toLowerCase().contains(searchText)) {
	             filteredList.add(etudiant);
	         }
	     }

	     etudiantTv.setItems(filteredList);
	 }

	
	
	 @FXML
	    public void loadingEtudiant() {
			 ObservableList<Etudiant> etudiants = FXCollections.observableArrayList();
			 ModelEtudiant me = new ModelEtudiant();
			 List<Etudiant> etudiantList = me.findAll();
			 
			 for(Etudiant etu : etudiantList) {
				 etudiants.add(etu);
			 }
			
			 
			 etudiantTv.setItems(etudiants);
		 }
		 
	
	 
	 @Override
		public void initialize(URL location, ResourceBundle resources) {
			
			idCol.setCellValueFactory(new PropertyValueFactory<Etudiant,Integer>("id"));
			matriculeCol.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("matriEt"));
			nomCol.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("nom"));
			sexeCol.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("sexe"));
			mailCol.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("mail"));
			photoCol.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("photo"));
				
			loadingEtudiant();
//			showList();
			AjouterGenreList();
			
			
			// Mise a jour du graphe
			ModelEtudiant me = new ModelEtudiant();
			  me.totalEtudiantGraphe();
			  me.CalculNbreEtudiant();
			  me.CalculNbreEtudiantFemme();
			  me.CalculNbreEtudiantHomme();
				
			 			
			modifierBtn.setDisable(false);
			supprimerBtn.setDisable(false);
			clearBtn.setDisable(false);
			enregistrerBtn.setDisable(false);
		
		}
	 
}
