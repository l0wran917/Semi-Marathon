package modele;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Semi_Marathon {
	
	private String ville;
	private Date date;
	private float longueur;
	private int anneeNaissanceMin;
	private int nbMaxPart;
	private String lieuDepartArr;
	private Time heureDepart;
	private Time tempsMax;
	private String URL;
	private String adrInscription;
	private String lieuRemiseDossard;
	private String horairesRemiseDossard[];
	// NbInscrit = courreurs.size()
	// NbPlacesDispo = nbMaxPart - nbInscrit
	
	private ArrayList<Partenaire> partenaires;
	private ArrayList<Tarif> tarifs;
	private ArrayList<TypeDossard> typesDossard;
	private ArrayList<Ecole_Entreprise> institutions;
	private ArrayList<Categorie> categorie;
	private ArrayList<Rue> rues;
	private ArrayList<Coureur> coureurs;
	
	private final int NB_HORAIRE_REMISE_DOSSARDS = 3;
	
	public Semi_Marathon()
	{
		ville = "Paris";
		date = new Date(2015, 3, 8); // 8 Mars 2015
		longueur = 21.1f;
		anneeNaissanceMin = 1997;
		nbMaxPart = 40000;
		lieuDepartArr = "Esplanade Chateau Vincennes";
		heureDepart = new Time(10,0,0);
		tempsMax = new Time(2, 50, 0);
		URL = "marathon.com/semi/2015/fr";
		adrInscription = "ASI Challenges, BP 18292";
		lieuRemiseDossard = "Parc Floaral";
		horairesRemiseDossard = new String[NB_HORAIRE_REMISE_DOSSARDS];
		horairesRemiseDossard[0] = new String("6/03 10-18");
		horairesRemiseDossard[1] = new String("7/03 10-19");
		horairesRemiseDossard[2] = new String("8/03 7-9");
		
		
	}
	
	
	
}
