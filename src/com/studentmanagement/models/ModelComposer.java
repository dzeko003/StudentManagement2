package com.studentmanagement.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.studentmanagement.entities.Composer;
import com.studentmanagement.tools.ConnexionDB;

public class ModelComposer implements Model<Composer> {
	
	PreparedStatement pstmt;
	ResultSet resultat;
	Composer composer;
	List<Composer> composers = new ArrayList<>();

	@Override
	public void save(Composer obj) {
		
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("insert into composer(id_com,natureEval,noteEval,anneAc,id_et,id_mat,id_cl) values(?,?,?,?,?,?,?)");
			
			pstmt.setInt(1, obj.getId());
			pstmt.setString(2, obj.getNatureEval());
			pstmt.setDouble(3, obj.getNoteEval());
			pstmt.setString(4, obj.getAnneAc());
			pstmt.setInt(5, obj.getEtudiant().getId());
			pstmt.setInt(6, obj.getMatiere().getId());
			pstmt.setInt(7, obj.getClasse().getId());
			
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
	public void update(Composer obj) {
		
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("update composer set natureEval=? , noteEval=? , anneAc=? , id_et=? , id_mat=? , id_cl=? where id_com=?  ");
					
			pstmt.setString(1, obj.getNatureEval());
			pstmt.setDouble(2, obj.getNoteEval());
			pstmt.setString(3, obj.getAnneAc());
			pstmt.setInt(4, obj.getEtudiant().getId());
			pstmt.setInt(5, obj.getMatiere().getId());
			pstmt.setInt(6, obj.getClasse().getId());
			pstmt.setInt(7, obj.getId());
			
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
	public void delete(Composer obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("delete from composer where id_com=? ");
			
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
	public Composer find(int id) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("select * from composer where id_com=?");
			
			pstmt.setInt(1, id);
			
			resultat=pstmt.executeQuery();
			
			ModelEtudiant modeletudiant = new ModelEtudiant();
			ModelClasse modelclasse = new ModelClasse();
			ModelMatiere modelmatiere = new ModelMatiere();
			
			while(resultat.next()) {
				
				composer=new Composer(resultat.getInt("id_com"),resultat.getString("natureEval"),resultat.getDouble("noteEval"),resultat.getString("anneAc"),modeletudiant.find(resultat.getInt("id_et")),modelmatiere.find(resultat.getInt("id_mat")),modelclasse.find(resultat.getInt("id_cl")));
				
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
		
		return composer;
	}

	@Override
	public List<Composer> findAll() {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("select * from composer");
			
			resultat=pstmt.executeQuery();
			
			ModelEtudiant modeletudiant = new ModelEtudiant();
			ModelClasse modelclasse = new ModelClasse();
			ModelMatiere modelmatiere = new ModelMatiere();
			
			while(resultat.next()) {
				
				composer=new Composer(resultat.getInt("id_com"),resultat.getString("natureEval"),resultat.getDouble("noteEval"),resultat.getString("anneAc"),modeletudiant.find(resultat.getInt("id_et")),modelmatiere.find(resultat.getInt("id_mat")),modelclasse.find(resultat.getInt("id_cl")));
				
				composers.add(composer);
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
		
		return composers;
		
	}

}
