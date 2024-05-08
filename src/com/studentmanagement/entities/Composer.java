package com.studentmanagement.entities;

public class Composer {

	private int id;
	private String natureEval;
	private double noteEval;
	private String anneAc;
	
	private Etudiant etudiant;
	private Matiere matiere;
	private Classe classe;
	
	
	public Composer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Composer(int id, String natureEval, double noteEval, String anneAc, Etudiant etudiant, Matiere matiere,Classe classe) {
		super();
		this.id = id;
		this.natureEval = natureEval;
		this.noteEval = noteEval;
		this.anneAc = anneAc;
		this.etudiant = etudiant;
		this.matiere = matiere;
		this.classe = classe;
	}


	public Composer(String natureEval, double noteEval, String anneAc, Etudiant etudiant, Matiere matiere, Classe classe) {
		super();
		this.natureEval = natureEval;
		this.noteEval = noteEval;
		this.anneAc = anneAc;
		this.etudiant = etudiant;
		this.matiere = matiere;
		this.classe = classe;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNatureEval() {
		return natureEval;
	}


	public void setNatureEval(String natureEval) {
		this.natureEval = natureEval;
	}


	public double getNoteEval() {
		return noteEval;
	}


	public void setNoteEval(double noteEval) {
		this.noteEval = noteEval;
	}


	public String getAnneAc() {
		return anneAc;
	}


	public void setAnneAc(String anneAc) {
		this.anneAc = anneAc;
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public Matiere getMatiere() {
		return matiere;
	}


	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	@Override
	public String toString() {
		return id+" "+natureEval+" "+noteEval+" "+anneAc+" "+etudiant+" "+matiere+" "+classe;
	}
	
	
	
}
