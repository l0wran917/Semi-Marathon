package modele;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import vue.VueAdmin;
import vue.VueEcoleEntreprise;
import vue.VueInscriptionPDF;
import vue.VueInscrits;
import vue.VueMdpAdmin;
import vue.VueMenuUtilisateur;
import vue.VueModifInfos;
import vue.VuePartenaires;
import vue.VuePrecisionsParcours;
import vue.VueRechercheResultat;
import vue.VueRetraitDossard;


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
	
	public Semi_Marathon()
	{
		fenetres = new ArrayList<JFrame>();
		fenetres.add(new JFrame("Semi Marathon"));
		fenetres.get(0).setSize(800, 600);
		fenetres.get(0).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//fenetres.get(0).setResizable(false);
			
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
		for(int i=1; i < 4; i++) // Ajout de partenaires pour test
			partenaires.add(new Partenaire("Partenaire " + Integer.toString(i), "Mail " + Integer.toString(i), new JLabel(new ImageIcon("assets/logoApple.png"))));
	
		coureurs = new ArrayList<Coureur>();
		for(int i=1; i < 40; i++) // Ajout de partenaires pour test
			coureurs.add(new Coureur("Nom", "Prenom"));
		
		rues = new ArrayList<Rue>();
		for(int i=1; i < 40; i++) // Ajout de rues pour test
			rues.add(new Rue("Rue du terter", i));
		
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
		categorie.add(new Categorie("Veterans", "V3", 1946, 1955));
		categorie.add(new Categorie("Veterans", "V2", 1956, 1965));
		categorie.add(new Categorie("Veterans", "V1", 1966, 1975));
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
	
	public static void main(String args[])
	{
		@SuppressWarnings("unused")
		Semi_Marathon semiMarathon = new Semi_Marathon();
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
				fenetreTmp.setSize(300, 600);
				fenetreTmp.add(new VueInscrits(coureurs, this));
			break;
			case VueMenuUtilisateur.PARCOURS :
				fenetreTmp.setSize(300, 600);
				fenetreTmp.add(new VuePrecisionsParcours(rues));				
			break;
			case VueMenuUtilisateur.INSCRIPTION :
				fenetreTmp.setSize(800, 600);
				fenetreTmp.add(new VueInscriptionPDF(this));
			break;
			case VueMenuUtilisateur.RESULTATS :
				fenetreTmp.setSize(700, 480);
				fenetreTmp.add(new VueRechercheResultat(coureurs, this));
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
	
	public ArrayList<Partenaire> getPartenaires()
	{ return partenaires; }
	
	public ArrayList<Coureur> getCoureur()
	{ return coureurs; }
	
	public void refresh()
	{ fenetres.get(0).repaint(); fenetres.get(0).setVisible(true); }

	public ArrayList<Rue> getRues()
	{ return rues; }
	
	public String getVille()
	{ return ville; }

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
	
	public Categorie getCategorie(int anneeNaissance)
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
	
}
