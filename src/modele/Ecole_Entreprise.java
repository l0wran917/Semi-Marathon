package modele;

import java.util.ArrayList;

public class Ecole_Entreprise {
	
	private String nom;
	private ArrayList<Coureur> coureurs;

	public Ecole_Entreprise(String nom, ArrayList<Coureur> coureurs)
	{
		this.nom = nom;
		this.coureurs = coureurs;
	}
	
	public Ecole_Entreprise(String nom) {
		this.nom = nom;
		
		coureurs = new ArrayList<Coureur>();
	}

	public String getNom()
	{ return nom; }

	public void ajoutCoureur(Coureur coureurTmp) {
		this.coureurs.add(coureurTmp);
	}
	
	
}
