package com.studentmanagement.entities;

public class EtudMatClas {
	
	private String classe;
	private String matricule;
	private String nom;
	private String sexe;
	private double moyenne;
	
	
	public EtudMatClas() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EtudMatClas(String classe, String matricule, String nom, String sexe, double moyenne) {
		super();
		this.classe = classe;
		this.matricule = matricule;
		this.nom = nom;
		this.sexe = sexe;
		this.moyenne = moyenne;
	}


	public String getClasse() {
		return classe;
	}


	public void setClasse(String classe) {
		this.classe = classe;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getSexe() {
		return sexe;
	}


	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	public double getMoyenne() {
		return moyenne;
	}


	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}


	@Override
	public String toString() {
		return classe+""+matricule+""+nom+""+sexe+""+moyenne;
	}
	
	
	

}
