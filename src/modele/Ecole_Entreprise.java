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
}
