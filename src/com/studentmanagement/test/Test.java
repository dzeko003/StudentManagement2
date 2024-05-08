package com.studentmanagement.test;

import com.studentmanagement.entities.Classe;
import com.studentmanagement.entities.Etudiant;
import com.studentmanagement.entities.Utilisateur;
import com.studentmanagement.models.ModelClasse;
import com.studentmanagement.models.ModelEtudMatClas;
import com.studentmanagement.models.ModelEtudiant;
import com.studentmanagement.models.ModelMatiere;
import com.studentmanagement.models.ModelUtilisateur;

public class Test {

	public static void main(String[] args) {
	
 /*
	ModelClasse mc = new ModelClasse();
		
	Classe classe = new Classe("L2","licence 2");
		
	mc.save(classe);
		
		
		ModelUtilisateur mu = new ModelUtilisateur();
		Utilisateur user = new Utilisateur("christ","abcd");
		mu.save(user);*/
		
//		Etudiant etudiant = new Etudiant("ABC","nnnn","nnnnn","dnvjadhj@hhhh","C:/nnnnnn/");
//		ModelEtudiant me = new ModelEtudiant();
//		me.save(etudiant);
//		Etudiant etudiant = new Etudiant(10,"BBK","kilou","jjjjj","llllllll","hhhhhhhhh");
//		me.update(etudiant);
		
//		System.out.println(me.find(10));
		
//		ModelMatiere mm = new ModelMatiere();
		ModelEtudMatClas memc = new ModelEtudMatClas();
		System.out.println(memc.findAll());
		
	}

}
