package com.studentmanagement.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentmanagement.tools.ConnexionDB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;


import com.mysql.jdbc.PreparedStatement;
import com.studentmanagement.entities.Etudiant;

public class ModelEtudiant implements Model<Etudiant> {
	
	PreparedStatement pstmt;
	ResultSet resultat;
	Etudiant etudiant;
	List<Etudiant> etudiants = new ArrayList<>();
	ObservableList<Etudiant> listEtudiant= FXCollections.observableArrayList();

	@Override
	public void save(Etudiant obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement(" insert into etudiant(id_et,matri_et,nom_et,mail_et,photo_et,sexe_et) values(?,?,?,?,?,?)");
			pstmt.setInt(1, obj.getId());
			pstmt.setString(2, obj.getMatriEt());
			pstmt.setString(3, obj.getNom());
			pstmt.setString(4, obj.getMail());
			pstmt.setString(5, obj.getPhoto());
			pstmt.setString(6, obj.getSexe());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void update(Etudiant obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("update etudiant set matri_et=? , nom_et=? , mail_et=? , photo_et=? , sexe_et=? where id_et=? ");
			pstmt.setString(1, obj.getMatriEt());
			pstmt.setString(2, obj.getNom());
			pstmt.setString(3, obj.getMail());
			pstmt.setString(4, obj.getPhoto());
			pstmt.setString(5, obj.getSexe());
			pstmt.setInt(6, obj.getId());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
		
	}

	@Override
	public void delete(Etudiant obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("delete from etudiant where id_et=?");
			pstmt.setInt(1, obj.getId());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		

		
	}

	@Override
	public Etudiant find(int id) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("select * from etudiant where id_et=?");
			pstmt.setInt(1, id);
			
			resultat=pstmt.executeQuery();
			
			while(resultat.next()) {
				
				etudiant= new Etudiant(resultat.getInt("id_et"),resultat.getString("matri_et"),resultat.getString("nom_et"),resultat.getString("mail_et"),resultat.getString("photo_et"),resultat.getString("sexe_et"));
				
				etudiants.add(etudiant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
		
		
		return etudiant;
	}

	@Override
	public List<Etudiant> findAll() {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("select * from etudiant");
						
			resultat=pstmt.executeQuery();
			
			while(resultat.next()) {
				
				etudiant= new Etudiant(resultat.getInt("id_et"),resultat.getString("matri_et"),resultat.getString("nom_et"),resultat.getString("mail_et"),resultat.getString("photo_et"),resultat.getString("sexe_et"));
				
				etudiants.add(etudiant);
//				listEtudiant.add(etudiant);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
		
		return etudiants;
	}
		


public int CalculNbreEtudiant() {

    int nbreEtudiant = 0;

    try {
    	
    	pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("select count(id_et) from etudiant");
    	resultat=pstmt.executeQuery();
    	
        if (resultat.next())
        {
        	nbreEtudiant = resultat.getInt("COUNT(id_et)");
        }

//        home_totalEnrolled.setText(String.valueOf(nbreEtudiant));

    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    
    finally
    {
		if(pstmt !=null) 
		{
			try
			{
				pstmt.close();
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
    
   
    return nbreEtudiant;
}


public int CalculNbreEtudiantFemme() {

    int nbreEtudiantFemmme = 0;

    try {
    	
    	pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("SELECT COUNT(id_et) FROM etudiant WHERE sexe_et = 'Feminin'");
    	resultat=pstmt.executeQuery();
    	
        if (resultat.next())
        {
        	nbreEtudiantFemmme = resultat.getInt("COUNT(id_et)");
        }

//        home_totalEnrolled.setText(String.valueOf(nbreEtudiant));

    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    
    finally
    {
		if(pstmt !=null) 
		{
			try
			{
				pstmt.close();
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
    
   
    return nbreEtudiantFemmme;
}

public int CalculNbreEtudiantHomme() {

    int nbreEtudiantHommme = 0;

    try {
    	
    	pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("SELECT COUNT(id_et) FROM etudiant WHERE sexe_et = 'Masculin'");
    	resultat=pstmt.executeQuery();
    	
        if (resultat.next())
        {
        	nbreEtudiantHommme = resultat.getInt("COUNT(id_et)");
        }

//        home_totalEnrolled.setText(String.valueOf(nbreEtudiant));

    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    
    finally
    {
		if(pstmt !=null) 
		{
			try
			{
				pstmt.close();
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
    
   
    return nbreEtudiantHommme;
}


public BarChart<String, Number> totalEtudiantGraphe() {
    BarChart<String, Number> graphique = null;

    try {
        pstmt = (PreparedStatement) ConnexionDB.getInstance().prepareStatement("SELECT sexe_et, COUNT(id_et) FROM etudiant GROUP BY sexe_et");
        resultat = pstmt.executeQuery();

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        graphique = new BarChart<>(xAxis, yAxis);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        while (resultat.next()) {
            String sexeEtudiant = resultat.getString("sexe_et");
            int nombreEtudiants = resultat.getInt("COUNT(id_et)");
            series.getData().add(new XYChart.Data<>(sexeEtudiant, nombreEtudiants));
        }

        graphique.getData().add(series);
        
//        yAxis.setTickLabelsVisible(false);
//        yAxis.setTickMarkVisible(false);
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    return graphique;
}


/*
public void totalEtudiantFemmeGraphe() {
	
try {
    	
    	pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("SELECT date, COUNT(id_et) FROM etudiant where sexe_et='Feminin' GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 5");
    	resultat=pstmt.executeQuery();
    	
    	XYChart.Series chart = new XYChart.Series();
    	
    	resultat=pstmt.executeQuery();
    	
    	while (resultat.next()) {
            chart.getData().add(new XYChart.Data(resultat.getString(1), resultat.getInt(2)));
        }

    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    
    finally
    {
		if(pstmt !=null) 
		{
			try
			{
				pstmt.close();
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
    
	
}

public void totalEtudiantHommmeGraphe() {
	
try {
    	
    	pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("SELECT date, COUNT(id_et) FROM etudiant where sexe_et='Masculin' GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 5");
    	resultat=pstmt.executeQuery();
    	
    	XYChart.Series chart = new XYChart.Series();
    	
    	resultat=pstmt.executeQuery();
    	
    	while (resultat.next()) {
            chart.getData().add(new XYChart.Data(resultat.getString(1), resultat.getInt(2)));
        }

    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    
    finally
    {
		if(pstmt !=null) 
		{
			try
			{
				pstmt.close();
			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
    
	
}

*/

}


