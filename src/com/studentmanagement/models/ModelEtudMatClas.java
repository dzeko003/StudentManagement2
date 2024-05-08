package com.studentmanagement.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.studentmanagement.entities.EtudMatClas;
import com.studentmanagement.tools.ConnexionDB;

public class ModelEtudMatClas implements Model<EtudMatClas> {
	
	PreparedStatement pstmt;
	List<EtudMatClas> moyennes = new ArrayList<>();

	@Override
	public void save(EtudMatClas obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(EtudMatClas obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EtudMatClas obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EtudMatClas find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EtudMatClas> findAll() {
        try {
            PreparedStatement pstmt = (PreparedStatement) ConnexionDB.getInstance().prepareStatement("SELECT\r\n"
            		+ "    emc.code_cl,\r\n"
            		+ "    emc.matri_et,\r\n"
            		+ "    emc.nom_et,\r\n"
            		+ "    emc.sexe_et,\r\n"
            		+ "    COALESCE(SUM(emc.noteEval), 0) / COUNT(DISTINCT emc.id_mat) AS moyenne\r\n"
            		+ "FROM\r\n"
            		+ "    etud_mat_clas emc\r\n"
            		+ "GROUP BY\r\n"
            		+ "    emc.code_cl,\r\n"
            		+ "    emc.matri_et,\r\n"
            		+ "    emc.nom_et,\r\n"
            		+ "    emc.sexe_et\r\n"
            		+ "");
            ResultSet resultat = pstmt.executeQuery();

                while (resultat.next()) {
                String classe = resultat.getString("code_cl");
                String matricule = resultat.getString("matri_et");
                String nom=resultat.getString("nom_et");
                String sexe=resultat.getString("sexe_et");
                double moyenne = resultat.getDouble("moyenne");

                EtudMatClas moyenneEtudiantMatiereClasse = new EtudMatClas(classe, matricule,nom, sexe, moyenne);
                moyennes.add(moyenneEtudiantMatiereClasse);
            }

            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
        return moyennes;
    }

}
