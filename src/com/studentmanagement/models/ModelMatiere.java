package com.studentmanagement.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.studentmanagement.entities.Matiere;
import com.studentmanagement.tools.ConnexionDB;

public class ModelMatiere implements Model<Matiere> {

	PreparedStatement pstmt;
	ResultSet resultat;
	Matiere matiere;
	List<Matiere> matieres = new ArrayList<>();
	
	
	@Override
	public void save(Matiere obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("insert into matiere(id_mat,code_mat,libelle_mat,id_cl) values(?,?,?,?)");
			pstmt.setInt(1, obj.getId());
			pstmt.setString(2, obj.getIdMat());
			pstmt.setString(3, obj.getLibelleMat());
			pstmt.setInt(4, obj.getClasse().getId());
			
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
	public void update(Matiere obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("update matiere set code_mat=? , libelle_mat=? , id_cl=? where id_mat=? ");
			pstmt.setString(1, obj.getIdMat());
			pstmt.setString(2, obj.getLibelleMat());
			pstmt.setInt(3, obj.getClasse().getId());
			pstmt.setInt(4, obj.getId());
			
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
	public void delete(Matiere obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("delete from matiere where id_mat=? ");
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
	public Matiere find(int id) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("select * from matiere where id_mat=?");
			pstmt.setInt(1, id);
			
			resultat=pstmt.executeQuery();
			
			ModelClasse mc = new ModelClasse();
			
			while(resultat.next()) {
				
				matiere= new Matiere(resultat.getInt("id_mat"),resultat.getString("code_mat"),resultat.getString("libelle_mat"),mc.find(resultat.getInt("id_cl")));
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
		
		return matiere;
	}

	@Override
	public List<Matiere> findAll() {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("select * from matiere");
			
			resultat=pstmt.executeQuery();
			ModelClasse mc = new ModelClasse();
			
			while(resultat.next()) {
				
				matiere= new Matiere(resultat.getInt("id_mat"),resultat.getString("code_mat"),resultat.getString("libelle_mat"),mc.find(resultat.getInt("id_cl")));
				
				matieres.add(matiere);
				
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
		
		return matieres;
		
	}

}
