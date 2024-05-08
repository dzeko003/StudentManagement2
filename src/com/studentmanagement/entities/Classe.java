package com.studentmanagement.entities;

public class Classe {
	
	private int id;
	private String idClasse;
	private String libelleClasse;
	
	
	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Classe(int id, String idClasse, String libelleClasse) {
		super();
		this.id = id;
		this.idClasse = idClasse;
		this.libelleClasse = libelleClasse;
	}


	public Classe(String idClasse, String libelleClasse) {
		super();
		this.idClasse = idClasse;
		this.libelleClasse = libelleClasse;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getIdClasse() {
		return idClasse;
	}


	public void setIdClasse(String idClasse) {
		this.idClasse = idClasse;
	}


	public String getLibelleClasse() {
		return libelleClasse;
	}


	public void setLibelleClasse(String libelleClasse) {
		this.libelleClasse = libelleClasse;
	}


	@Override
	public String toString() {
		return id+" "+idClasse+" "+libelleClasse;		
	}
		

}
