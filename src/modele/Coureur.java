package modele;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Coureur implements Comparable<Coureur> {
	
	public static int NB_COUREURS = 0;
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
	private long tel;
	private String email;
	private String club;
	private int numLicense;
	private boolean licenseCopie;
	private String typePaiement;
	private long numCB;
	private int CB_DerniesChiffres;
	private int moisFinCB;
	private int anneeFinCB;
	private boolean paiement;
	private boolean certificatMedical;
	private Date dateInscription;
	private boolean dossardRetire;
	
	// TempsReel
	
	private String tempsReel;
	int heureTempsReel;
	int minutesTempsReel;
	int secondesTempsReel;
	
	// position
	private int position;
	
	
	private ArrayList<ChronometragePoint> chronos;
	private Ecole_Entreprise institution; // 0..1
	private TypeDossard typeDossard;
	
	
	public Coureur(String nom, String prenom, Semi_Marathon semiMarathon){
		NB_COUREURS++;
		
		this.nom = nom;
		this.prenom = prenom;
		this.numDossard = NB_COUREURS;
		
		chronos = new ArrayList<ChronometragePoint>();
		
		chronos.add(new ChronometragePoint(new Time(01,01,14) , this));
	    chronos.add(new ChronometragePoint(new Time(10,11,14) , this));
	    
	    
	    if((int)(Math.random()*10) % 2 == 0)
	    	sexe = 'H';
	    else
	    	sexe = 'F';
	    
	    int anneeNaissance = (int)(Math.random()* (2015-1940) + 1940);
	    dateNaiss = new Date(anneeNaissance, (int)(Math.random()*(12 - 1)+1), (int)(Math.random()*30)+1);
	    
	    categorie = semiMarathon.getCategorie(anneeNaissance);
	    
	    tempsReel = getTempsReelAleatoire();
		
	}
	
	public Coureur(String nom, String prenom, char sexe, Date dateNaiss, String adresse, int cp, 
			String ville, String pays, String nationalite, long tel, String mail, String club, int license,
			Ecole_Entreprise institution, Categorie cat)
	{
		NB_COUREURS++;
		
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.dateNaiss = dateNaiss;
		this.adresse = adresse;
		this.codePostal = cp;
		this.ville = ville;
		this.pays = pays;
		this.nationalite = nationalite;
		this.tel = tel;
		this.email = mail;
		this.club = club;
		this.numLicense = license;
		this.institution = institution;
		this.numDossard = NB_COUREURS;
		this.categorie = cat;
	}
	
	public int getNumDossard() 
	{ return numDossard; }
	
	public String getNom() 
	{ return nom; }
	
	public String getPrenom() 
	{ return prenom; }
	
	public Date getDateNaiss() 
	{ return dateNaiss; }
	
	public String getDateNaissString() {
			
			String jour = Integer.toString(dateNaiss.getDate());
			String mois = Integer.toString(dateNaiss.getMonth());
			String annee = Integer.toString(dateNaiss.getYear());
			
			if(jour.length() == 1)
				jour = new String("0" + jour);
			
			if(mois.length() == 1)
				mois = new String("0" + mois);
			
			String dateFormate = jour + "/" + mois + "/" + annee;
			
			return dateFormate;
		}
	
	public int getPosition()
	{ return position; }
	
	public String getCodeCategorie()
	{ 
		if(categorie != null)
			return categorie.getCode(); 
		else
			return new String("XX");
	}
	
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

	public void setPaiement(String typePaiement) {
		this.typePaiement = typePaiement;
		
	}
	
	/*public String getTempsReelCalcul()
	{
		String heure = "";
		String minute = "";
		String seconde = "";
		
		return "";
	}*/
	
	public String getTempsReelAleatoire()
	{	
		int heure = 1 + (int)(Math.random() * ((2 - 1) + 1));
		int minute = 0 + (int)(Math.random() * ((60 - 0) + 1));
		int seconde = 0 + (int)(Math.random() * ((60 - 0) + 1));
		
		
		if(heure == 2 && minute > 50)
		{
			minute = minute - 10;
		}
		if(minute == 60 && seconde != 0)
		{
			seconde = 0;
		}
		
		heureTempsReel = heure;
		minutesTempsReel = minute;
		secondesTempsReel = seconde;
	
		return Integer.toString(heure) + ":" + Integer.toString(minute) + ":" + Integer.toString(seconde);
	}
	
	public String getTempsReel()
	{ return tempsReel; }
	
	public double getTempsReelDouble()
	{ return Double.parseDouble(tempsReel); }

	public void setPaiement(String typePaiement, long numCB, int moisCB, int anneeCB, int criptoCB) {
		this.typePaiement = "cb";
		this.numCB = numCB;
		this.moisFinCB = moisCB;
		this.anneeFinCB = anneeCB;
		this.CB_DerniesChiffres = criptoCB;
	}

	public void setTypeDossard(TypeDossard typeDossardTmp) {
		this.typeDossard = typeDossardTmp;
	}
	
	public void setPosition(int i)
	{
		this.position = i;
	}
	 
	public char getSexe()
	{ return sexe; }


	public void validerRetraitDossard() {
		this.dossardRetire = true;
	}
	
	public boolean getDossardRetire(){
		return dossardRetire;
	}

	public int compareTo(Coureur c)
	{
		int retour = 0;
		
		if(heureTempsReel < c.heureTempsReel)
		{
			retour =  -1;
		}
		else if(heureTempsReel > c.heureTempsReel)
		{
			retour = 1;
		}
		else if(heureTempsReel == c.heureTempsReel)
		{
			if(minutesTempsReel < c.minutesTempsReel)
			{
				retour = -1;
			}
			else if(minutesTempsReel > c.minutesTempsReel)
			{
				retour = 1;
			}
			else if(minutesTempsReel == c.minutesTempsReel)
			{
				if(secondesTempsReel < c.secondesTempsReel)
				{
					retour = -1;
				}
				else if(secondesTempsReel > c.secondesTempsReel)
				{
					retour = 1;
				}
				else 
				{
					retour = 0;
				}
			}
		}
		return retour;
	}

	
}




