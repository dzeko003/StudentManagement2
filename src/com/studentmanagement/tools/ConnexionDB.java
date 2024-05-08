package com.studentmanagement.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.PreparedStatement;
//import com.pharmacie.entities.Categorie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConnexionDB {
     
    /*URL de connexion*/
	
	private static String dburl;
	
	/*Nom du user*/
	
    private static String user;
    
    /*Mot de passe du user*/

    private static String password;
    
    /*Objet Connexion*/
    
    private static Connection connect;
    static PreparedStatement pstmt;
   static ResultSet resultat;
    
   
    public static Connection getInstance() {
    	
    	if(connect == null) {
    		
            try {
            	// Récupérer les propriétés de la base de données depuis le fichier
            	Properties props = new Properties();
            	props.load(new FileInputStream("data.properties")) ;
            	user = props.getProperty("user");
            	password = props.getProperty("password");
            	dburl = props.getProperty("dburl");
            	
				connect = DriverManager.getConnection(dburl, user, password);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Connexion réussie à : "+dburl);
    	}
    	return connect;
    }
   

}