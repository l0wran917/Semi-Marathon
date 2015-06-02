package modele;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;

import vue.VueMenuUtilisateur;
import vue.VueRetraitDossard;

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
	
	private ArrayList<JFrame> fenetres;
	
	private final int NB_HORAIRE_REMISE_DOSSARDS = 3;
	
	private JFrame fenetre;
	
	public Semi_Marathon()
	{
		
		fenetre = new JFrame("Semi Marathon");
		fenetre.setSize(800, 600);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setResizable(false);
			
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
		
		partenaires = new ArrayList<Partenaire>();	

		for(int i=1; i < 4; i++) // Ajout de partenaires pour test
			partenaires.add(new Partenaire("Partenaire " + Integer.toString(i), "Mail " + Integer.toString(i)));
	
		coureurs = new ArrayList<Coureur>();
		for(int i=1; i < 5; i++) // Ajout de partenaires pour test
			coureurs.add(new Coureur("Nom", "Prenom", 1));
		
		rues = new ArrayList<Rue>();
		for(int i=1; i < 5; i++) // Ajout de rues pour test
			rues.add(new Rue("Rue du terter", i));
	
		
		fenetre.add(new VueMenuUtilisateur(this));	
		
		fenetre.setVisible(true);
	}
	
	public static void main(String args[])
	{
		Semi_Marathon semiMarathon = new Semi_Marathon();
	}

	public void ouvrir(String actionCommand) {
		switch(actionCommand)
		{
			case "inscription" :
				
				
			break;
		}
	}
	
	public ArrayList<Partenaire> getPartenaires()
	{ return partenaires; }
	
	public ArrayList<Coureur> getCoureur()
	{ return coureurs; }

	public JFrame getFrame()
	{ return fenetre; }
	
	public void refresh()
	{ fenetre.repaint(); fenetre.setVisible(true); }

	public ArrayList<Rue> getRues()
	{ return rues; }
	
	public String getVille()
	{ return ville; }

	public String getDate() {
		String dateFormate = date.getDate() + "/" + date.getMonth() + "/" + date.getYear();
		
		return dateFormate;
	}

	public String getDistance() {
		return Float.toString(longueur);
	}

	public String getNbInscrits() {
		return Integer.toString(coureurs.size());
	}

	public String getNbMaxCoureur() {
		return Integer.toString(nbMaxPart);
	}
	
}
