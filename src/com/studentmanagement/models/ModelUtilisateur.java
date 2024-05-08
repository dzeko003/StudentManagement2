package com.studentmanagement.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import com.mysql.jdbc.PreparedStatement;
import java.sql.PreparedStatement;
import com.studentmanagement.entities.Utilisateur;
import com.studentmanagement.tools.ConnexionDB;
import com.studentmanagement.tools.Secure;

public class ModelUtilisateur implements Model<Utilisateur> {

	PreparedStatement pstmt;
	Utilisateur user=null;
	ResultSet resultat;
	boolean status; 
	@Override
	public void save(Utilisateur obj) {
		
		try {
			pstmt=ConnexionDB.getInstance().prepareStatement("insert into utilisateur(username,password) values(?,?)");
			pstmt.setString(1, obj.getUsername());
			pstmt.setString(2, Secure.encrypt(obj.getPassword()));
			
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
	public void update(Utilisateur obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Utilisateur obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isLogin(String username, String password) {
		 status = false;
		 try 
		 {
			 	pstmt= ConnexionDB.getInstance().prepareStatement("select * from utilisateur where username=? and password=? ");
					pstmt.setString(1, username);
					pstmt.setString(2, Secure.encrypt(password));
					
				//execution de la requête dans la base de données
			
				resultat=pstmt.executeQuery();
		
		  		  
				if(resultat.next())
				{
					status= true;
				}
			
				else 
				{
				status=false;
				}
			     
		  } 
		 
		 catch (SQLException e) 
		 {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 } 
		 finally
		 {
	        	if (pstmt !=null)
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

	 
		return status;
	}
	
	

}