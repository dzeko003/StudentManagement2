package com.studentmanagement.models;

import java.sql.SQLException;
import java.util.List;


import com.mysql.jdbc.PreparedStatement;
import com.studentmanagement.entities.Classe;
import com.studentmanagement.tools.ConnexionDB;

public class ModelClasse2 implements Model<Classe> {

	PreparedStatement pstmt;
	
	@Override
	public void save(Classe obj) {
		try {
			pstmt = (PreparedStatement) ConnexionDB.getInstance().prepareCall("insert into classe(id_cl,code_cl,libelle_cl) values(?,?,?)");
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Classe obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Classe find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Classe> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
