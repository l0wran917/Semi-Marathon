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

}
