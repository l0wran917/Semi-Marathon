package modele;

import java.util.ArrayList;

public class TypeDossard {
	
	private String nom;
	private String description;
	
	private ArrayList<Coureur> coureurs;
	
	public TypeDossard(String nom, String description, ArrayList<Coureur> coureurs)
	{
		this.nom = nom;
		this.description = description;
		this.coureurs = coureurs;
	}

	public TypeDossard(String nom, String description) {		
		this.nom = nom;
		this.description = description;
		this.coureurs = new ArrayList<Coureur>();
	}
	
	public void ajoutCoureur(Coureur coureurTmp)
	{
		this.coureurs.add(coureurTmp);
	}

	public String getNom() {
		return nom;
	}
	
	public String getDesc() {
		return description;
	}


}
