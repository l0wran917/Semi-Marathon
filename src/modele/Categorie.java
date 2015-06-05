package modele;

import java.util.ArrayList;

public class Categorie {
	
	private String nom;
	private String code;
	private int anneeDeb;
	private int anneeFin;
	
	private ArrayList<Coureur> coureurs;
	
	public Categorie(String nom, String code, int anneeDeb, int anneeFin)
	{
		this.nom = nom;
		this.code = code;
		this.anneeDeb = anneeDeb;
		this.anneeFin = anneeFin;
		this.coureurs = new ArrayList<Coureur>();
	}

	public String getCode()
	{ return code; }
	
	public String getNom()
	{ return nom; }
	
	public int getAnneeDebut()
	{ return anneeDeb; }
	
	public int getAnneeFin()
	{ return anneeFin; }

	public void ajoutCoureur(Coureur coureurTmp) {
		coureurs.add(coureurTmp);
	}
}
