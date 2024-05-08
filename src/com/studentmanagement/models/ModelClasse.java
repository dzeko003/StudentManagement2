package com.studentmanagement.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentmanagement.tools.ConnexionDB;
import com.mysql.jdbc.PreparedStatement;
import com.studentmanagement.entities.Classe;

public class ModelClasse implements Model<Classe> {
	
	PreparedStatement pstmt;
	ResultSet resultat;
	Classe classe;
	List<Classe> classes = new ArrayList<>();

	@Override
	public void save(Classe obj) {
		try {
	
			
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("insert into classe(id_cl,code_cl,libelle_cl) values(?,?,?)");
			pstmt.setInt(1, obj.getId());
			pstmt.setString(2, obj.getIdClasse());
			pstmt.setString(3, obj.getLibelleClasse());
			
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
	public void update(Classe obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("update classe set code_cl=? , libelle_cl=? where id_cl=?");
			pstmt.setString(1, obj.getIdClasse());
			pstmt.setString(2, obj.getLibelleClasse());
			pstmt.setInt(3, obj.getId());
			
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
	public void delete(Classe obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("delete from classe where id_cl=?");
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
	public Classe find(int id) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("select * from classe where id_cl=?");
			pstmt.setInt(1, id);
			
			resultat=pstmt.executeQuery();
			
			while(resultat.next()) {
				classe = new Classe(resultat.getInt("id_cl"),resultat.getString("code_cl"),resultat.getString("libelle_cl"));	
				
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
		
		return classe;
	}

	@Override
	public List<Classe> findAll() {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("select * from classe");		
			resultat=pstmt.executeQuery();
			
			while(resultat.next()) {
				classe = new Classe(resultat.getInt("id_cl"),resultat.getString("code_cl"),resultat.getString("libelle_cl"));	
				
				classes.add(classe);
				
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
	
		return classes;
	}

}
