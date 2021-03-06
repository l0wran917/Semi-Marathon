package modele;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import vue.VueAdmin;
import vue.VueEcoleEntreprise;
import vue.VueInscription;
import vue.VueInscrits;
import vue.VueMdpAdmin;
import vue.VueMenuUtilisateur;
import vue.VueModifInfos;
import vue.VuePartenaires;
import vue.VuePrecisionsParcours;
import vue.VueRechercheResultat;
import vue.VueResultats;
import vue.VueRetraitDossard;


@SuppressWarnings("unused")
public class Semi_Marathon{
	
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
	
	@SuppressWarnings("deprecation")
	public Semi_Marathon()
	{
		fenetres = new ArrayList<JFrame>();
		fenetres.add(new JFrame("Semi Marathon"));
		fenetres.get(0).setSize(800, 600);
		fenetres.get(0).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetres.get(0).setResizable(false);
			
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
		JLabel logo = new JLabel();
		for(int i=1; i < 8; i++) // Ajout de partenaires pour test
			partenaires.add(new Partenaire("Partenaire " + Integer.toString(i), "Mail " + Integer.toString(i), new JLabel(new ImageIcon("assets/logoApple.png"))));
		
		coureurs = new ArrayList<Coureur>();
		
		rues = new ArrayList<Rue>();
		for(int i=1; i < 40; i++) // Ajout de rues pour test
			rues.add(new Rue("Rue du parcours", i));
		
		institutions = new ArrayList<Ecole_Entreprise>();
		for(int i = 0; i < 40; i ++)
			institutions.add(new Ecole_Entreprise("instutution" ,coureurs));
		
		typesDossard = new ArrayList<TypeDossard>();
		typesDossard.add(new TypeDossard("Elite", "Femmes : -1h20/Homme -1h10"));
		typesDossard.add(new TypeDossard("Preferentiel", "Femmes : -1h35/Homme -1h25"));
		typesDossard.add(new TypeDossard("Rouge", "Homme -1h35"));
		typesDossard.add(new TypeDossard("Jaune", "Entre 1h35 et 1h40"));
		typesDossard.add(new TypeDossard("Bleu", "Entre 1h40 et 1h50"));
		typesDossard.add(new TypeDossard("Violet", "Entre 1h50 et 2h"));
		typesDossard.add(new TypeDossard("Vert", "Entre 2h et 2h10"));
		typesDossard.add(new TypeDossard("Rose", "Plus de 2h10"));
		
		categorie = new ArrayList<Categorie>();
		categorie.add(new Categorie("Veterans", "V4", 1945, -90000));
		categorie.add(new Categorie("Veterans", "V3", 1955, 1946));
		categorie.add(new Categorie("Veterans", "V2", 1965, 1956));
		categorie.add(new Categorie("Veterans", "V1", 1975, 1966));
		categorie.add(new Categorie("Seniors", "SE", 1992, 1976));
		categorie.add(new Categorie("Espoirs", "ES", 1995, 1993));
		categorie.add(new Categorie("Juniors", "JU", 1997, 1996));
		categorie.add(new Categorie("Cadets", "CA", 1999, 1998));
		categorie.add(new Categorie("Minimes", "MI", 2001, 2000));
		categorie.add(new Categorie("Benjamins", "BE", 2003, 2002));
		categorie.add(new Categorie("Poussins", "PO", 2005, 2004));
		categorie.add(new Categorie("Ecole d'Athlétisme", "EA", 90000, 2006));
		
		
		fenetres.get(0).add(new VueMenuUtilisateur(this));

		fenetres.get(0).setVisible(true);
	}
	
	public void genererCoureurs()
	{
		ArrayList<String> noms = new ArrayList<String>();
		ArrayList<String> prenoms = new ArrayList<String>();
		
		prenoms.add("Maxime");	prenoms.add("Jean-Luc"); prenoms.add("Hervé");	prenoms.add("Cyril");
		prenoms.add("Frédéric"); prenoms.add("Patrick");	prenoms.add("Emile");	prenoms.add("Raymond");
		prenoms.add("Patrice");	prenoms.add("Marc");	prenoms.add("Yves");	prenoms.add("Paul");
		prenoms.add("Alexis"); prenoms.add("Benjamin");	prenoms.add("Georges");	prenoms.add("Stéphane");
		prenoms.add("Antoine");
		prenoms.add("Louane"); 	prenoms.add("Amandine");	prenoms.add("Zoe");	prenoms.add("Gabrielle");
		prenoms.add("Olivia");	prenoms.add("Lucie");	prenoms.add("Ambre");	prenoms.add("Andrea");
		prenoms.add("Morgane");	prenoms.add("Lise");	prenoms.add("Heloise");	prenoms.add("Solene");
		prenoms.add("Chloe");	prenoms.add("Loane");	prenoms.add("Alexia");	prenoms.add("Claire");
		prenoms.add("Pauline");
		
		noms.add("Ankhesen");	noms.add("Gunhild"); 	noms.add("Ankhesen");	noms.add("Geertje");
		noms.add("Senbi"); noms.add("Edith");	noms.add("Wosret");	noms.add("Vilhelmine");
		noms.add("Teti");	noms.add("﻿Alrun");	noms.add("Pepi");	noms.add("Deetje");
		noms.add("Bebi"); noms.add("Svanhilde");	noms.add("Piye");	noms.add("Frideborg");
		noms.add("Euredice");	noms.add("Nepherites"); 	noms.add("Vilma"); 	noms.add("Senbi");	
		noms.add("Tepemkau");	noms.add("Lucie");	noms.add("Berenike");	noms.add("Brelok");
		noms.add("Bet");	noms.add("Ulfaran");	noms.add("Hebeny");	noms.add("Muri");
		noms.add("Netikerty");	noms.add("Dworkok"); 	noms.add("Ankhesen");	noms.add("Dailin");
		noms.add("Arsinoe");  noms.add("Ida");
		

		for(int i=1; i < 65; i++) // Ajout de partenaires pour test
		{
			int numNom = (int) (Math.random() * noms.size());
			int numPrenom = (int) (Math.random() * prenoms.size());
			
			coureurs.add(new Coureur(noms.get(numNom), prenoms.get(numPrenom), this));
		}
		
		refreshVueMenuUtilisateur();
	}
	
	public static void main(String args[])
	{
		Semi_Marathon semiMarathon = new Semi_Marathon();
		semiMarathon.genererCoureurs();
	}

	public void ouvrir(String actionCommand) {
		
		JFrame fenetreTmp = new JFrame(actionCommand);
		fenetreTmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetreTmp.setResizable(false);
		fenetreTmp.setVisible(true);
		

		switch(actionCommand)
		{
			case VueMenuUtilisateur.PARTENAIRES :
				fenetreTmp.setSize(300, 600);
				fenetreTmp.add(new VuePartenaires(partenaires, this));
			break;
			case VueMenuUtilisateur.INSCRITS :
				fenetreTmp.setSize(400, 600);
				fenetreTmp.add(new VueInscrits(coureurs, this));
			break;
			case VueMenuUtilisateur.PARCOURS :
				fenetreTmp.setSize(300, 600);
				fenetreTmp.add(new VuePrecisionsParcours(rues));				
			break;
			case VueMenuUtilisateur.INSCRIPTION :
				fenetreTmp.setSize(800, 600);
				fenetreTmp.add(new VueInscription(this));
			break;
			case VueMenuUtilisateur.RESULTATS :
				fenetreTmp.setSize(700, 480);
				fenetreTmp.add(new VueResultats(coureurs, this));
			break;
			case VueMenuUtilisateur.ADMIN_MDP :
				fenetreTmp.setSize(300, 90);
				fenetreTmp.add(new VueMdpAdmin(this));
			break;
			case VueMenuUtilisateur.ADMIN :
				fenetreTmp.setSize(500, 250);
				fenetreTmp.add(new VueAdmin(this));
			break;
			case VueAdmin.RETRAIT_DOSSARD :
				fenetreTmp.setSize(330, 130);
				fenetreTmp.add(new VueRetraitDossard(this));
			break;
			case VueAdmin.MODIF_INFOS :
				fenetreTmp.setSize(410,275);
				fenetreTmp.add(new VueModifInfos(this));
			break;
			case VueAdmin.INSTITUTIONS :
				fenetreTmp.setSize(300, 600);
				fenetreTmp.add(new VueEcoleEntreprise(institutions, this));
			break;
			default:
				fenetreTmp.setVisible(false); // Si aucune action reconnu, on affiche pas fenetre
			break;
		}
		fenetres.add(fenetreTmp);
	}
	
	public void ouvrir(String actionCommand, ArrayList<Coureur> classement) {
		
		JFrame fenetreTmp = new JFrame(actionCommand);
		fenetreTmp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetreTmp.setResizable(false);
		fenetreTmp.setVisible(true);
		
		if(actionCommand == VueMenuUtilisateur.CLASSEMENT)
		{
			fenetreTmp.setSize(1350, 550);
			fenetreTmp.add(new VueRechercheResultat(classement, this));
		}
		else if(actionCommand == VueMenuUtilisateur.CLASSEMENT_SEXE)
		{
			fenetreTmp.setSize(1500, 480);
			fenetreTmp.add(new VueRechercheResultat(classement, this, new Boolean(true)));
		}
		fenetres.add(fenetreTmp);
	}
	
	public ArrayList<Partenaire> getPartenaires()
	{ return partenaires; }
	
	public ArrayList<Coureur> getCoureur()
	{ return coureurs; }
	
	public ArrayList<Rue> getRues()
	{ return rues; }
	
	public String getVille()
	{ return ville; }

	@SuppressWarnings("deprecation")
	public String getDate() {
		
		String jour = Integer.toString(date.getDate());
		String mois = Integer.toString(date.getMonth());
		String annee = Integer.toString(date.getYear());
		
		if(jour.length() == 1)
			jour = new String("0" + jour);
		
		if(mois.length() == 1)
			mois = new String("0" + mois);
		
		String dateFormate = jour + "/" + mois + "/" + annee;
		
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

	public void setSize(int x, int y)
	{
		fenetres.get(0).setSize(x, y);
	}

	public Ecole_Entreprise getInstitution(String institution) {
		Ecole_Entreprise institutionRecherche = null;
		
		int i = 0;
		while(i<institutions.size() && institutions.get(i).getNom() != institution)
		{ i++; }
		
		if(i >= institutions.size())
			i--;
		
		if(institutions.get(i).getNom() == institution)
			institutionRecherche = institutions.get(i);
		else
		{
			institutionRecherche = new Ecole_Entreprise(institution);
			this.institutions.add(institutionRecherche);		
		}
		return institutionRecherche;
	}

	public void ajoutCoureur(Coureur coureurTmp) {
		coureurs.add(coureurTmp);
		refreshVueMenuUtilisateur();
	}
	
	public void refreshVueMenuUtilisateur(){
		((VueMenuUtilisateur) ((JFrame) fenetres.get(0)).getContentPane().getComponent(0)).refreshInfos();
	}

	public TypeDossard getTypeDossard(String nom) {
		
		int i = 0;
		while(i<typesDossard.size() && typesDossard.get(i).getNom().toUpperCase().compareTo(nom.toUpperCase()) != 0)
		{ i++; }
		
		if(i>= typesDossard.size())
			i--;
		
		if(typesDossard.get(i).getNom().toUpperCase().compareTo(nom.toUpperCase()) == 0)
		{
			return typesDossard.get(i);
		}
		else
			return null;
	}
	
	public  Categorie getCategorie(int anneeNaissance)
	{
		int i = 0;
		
		boolean avant;
		boolean apres;
		
		boolean etatRecherche = true;
		
		while(i<categorie.size() && etatRecherche)
		{
			avant = anneeNaissance <= categorie.get(i).getAnneeDebut();
			apres = anneeNaissance >= categorie.get(i).getAnneeFin();
			
			etatRecherche = !(avant && apres);
				
			i++;
		}
		i--;
		
		if(categorie.get(i).getAnneeDebut() >= anneeNaissance && categorie.get(i).getAnneeFin() <= anneeNaissance)
		{
			return categorie.get(i);
		}
		
		return null;
	}

	public Coureur getCoureur(int num) {
		if(num > 0 && num < coureurs.size())
			return coureurs.get(num-1);
		else
			return null;
		
	}

	public void setInfos(String lieu, String date, String distance, String nbCoureursMax) {
		Date dateTmp = convertiStringDate(date);
		
		this.ville = lieu;
		this.date = dateTmp;
		this.longueur = Float.parseFloat(distance);
		this.nbMaxPart = Integer.parseInt(nbCoureursMax);
		
		refreshVueMenuUtilisateur();
		
	}
	
	static public Date convertiStringDate(String date)
	{

		char jourChar[] = {date.charAt(0), date.charAt(1)};
		char moisChar[] = {date.charAt(3), date.charAt(4)};
		char anneeChar[] = {date.charAt(6), date.charAt(7), date.charAt(8), date.charAt(9)};
		
		String jour = new String(jourChar);
		String mois = new String(moisChar);
		String annee = new String(anneeChar);
		
		@SuppressWarnings("deprecation")
		Date dateReturn = new Date(Integer.parseInt(annee), Integer.parseInt(mois), Integer.parseInt(jour));

		return dateReturn;	
		
	}
	
}
