package com.studentmanagement.entities;

public class Matiere {
	
	private int id;
	private String idMat;
	private String libelleMat;
	private Classe classe;
	
	
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Matiere(int id, String idMat, String libelleMat, Classe classe) {
		super();
		this.id = id;
		this.idMat = idMat;
		this.libelleMat = libelleMat;
		this.classe = classe;
	}


	public Matiere(String idMat, String libelleMat, Classe classe) {
		super();
		this.idMat = idMat;
		this.libelleMat = libelleMat;
		this.classe = classe;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getIdMat() {
		return idMat;
	}


	public void setIdMat(String idMat) {
		this.idMat = idMat;
	}


	public String getLibelleMat() {
		return libelleMat;
	}


	public void setLibelleMat(String libelleMat) {
		this.libelleMat = libelleMat;
	}


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	@Override
	public String toString() {
		return id+" "+idMat+" "+libelleMat+" "+classe;
	}
	
	
	
	
	
	

}
