package modele;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Coureur {
	
	private int numDossard;
	private String nom;
	private String prenom;
	private char sexe;
	private Date dateNaiss; 
	// Categorie
	private Categorie categorie;
	
	private String adresse;
	private int codePostal;
	private String ville;
	private String etat;
	private String pays;
	private String nationalite;
	private int tel;
	private String email;
	private String club;
	private int numLicense;
	private boolean licenseCopie;
	private String typePaiement;
	private int numCB;
	private int CB_DerniesChiffres;
	private int moisFinCB;
	private int anneeFinCB;
	private boolean paiement;
	private boolean certificatMedical;
	private Date dateInscription;
	private boolean dossardRetire;
	
	// TempsReel
	
	// position
	private int position;
	
	
	private ArrayList<ChronometragePoint> chronos;
	private Ecole_Entreprise institutions; // 0..1
	private TypeDossard typeDossard;
	
	
	public Coureur(String nom, String prenom, int numDossard){
		this.nom = nom;
		this.prenom = prenom;
		this.numDossard = numDossard;
		
		chronos = new ArrayList<ChronometragePoint>();
		
		chronos.add(new ChronometragePoint(new Time(01,01,14) , this));
	    chronos.add(new ChronometragePoint(new Time(10,11,14) , this));
		
		position = 1;
		categorie = new Categorie("Cadet", "CA", 1995, 2015);
		
	}
	
	public int getNumDossard() 
	{ return numDossard; }
	
	public String getNom() 
	{ return nom; }
	
	public String getPrenom() 
	{ return prenom; }
	
	public Date getDateNaiss() 
	{ return dateNaiss; }
	
	public int getPosition()
	{ return position; }
	
	public String getCodeCategorie()
	{ return categorie.getCode(); }
	
	public String getHeureLigneDepart()
	{
		String heure = "";
		heure += chronos.get(0).getHeure().getHours() + ":";
		heure += chronos.get(0).getHeure().getMinutes() + ":";
		heure += chronos.get(0).getHeure().getSeconds();
		
		return heure;
	}
	
	public String getHeureLigneArrivee()
	{
		String heure = "";
		heure += chronos.get(chronos.size()-1).getHeure().getHours() + ":";
		heure += chronos.get(chronos.size()-1).getHeure().getMinutes() + ":";
		heure += chronos.get(chronos.size()-1).getHeure().getSeconds();
		
		return heure;
	}
	
}




