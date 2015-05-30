package modele;

import java.util.ArrayList;
import java.util.Date;

public class Coureur {
	
	private int numDossard;
	private String nom;
	private String prenom;
	private char sexe;
	private int anneeNaissance;
	// Categorie
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
	// Position
	
	private ArrayList<ChronometragePoint> chronos;
	private Ecole_Entreprise institutions; // 0..1
	private TypeDossard typeDossard;
	
}
