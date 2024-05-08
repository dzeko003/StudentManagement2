package com.studentmanagement.entities;

public class Etudiant {
	
	private int id;
	private String matriEt;
	private String nom;
	private String mail;
	private String photo;
	private String sexe;
	
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(int id, String matriEt, String nom, String mail, String photo, String sexe) {
		super();
		this.id = id;
		this.matriEt = matriEt;
		this.nom = nom;
		this.mail = mail;
		this.photo = photo;
		this.sexe = sexe;
	}


	public Etudiant(String matriEt, String nom, String mail, String photo, String sexe) {
		super();
		this.matriEt = matriEt;
		this.nom = nom;
		this.mail = mail;
		this.photo = photo;
		this.sexe = sexe;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatriEt() {
		return matriEt;
	}

	public void setMatriEt(String matriEt) {
		this.matriEt = matriEt;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	@Override
	public String toString() {
		return id+" " +matriEt+" "+nom+" "+mail+" "+sexe;
	}
	
	

	
}
