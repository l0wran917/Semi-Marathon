package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modele.Coureur;
import modele.Semi_Marathon;



public class VueRechercheResultat extends JPanel {
	
	private ArrayList<JLabel> lblInscrits;
	private JPanel panelVueScroll;
	
	public VueRechercheResultat(ArrayList<Coureur> inscrits, Semi_Marathon semi_marathon)
	{
		// redefinition de la taille de la fenetre
		//semi_marathon.setSize(300, 600);
		
		lblInscrits = new ArrayList<JLabel>();
		panelVueScroll = new JPanel();
		
		this.setLayout(new BorderLayout());
		// nbInscrits ligne + 1 pour les titres et 1 colonne 
		panelVueScroll.setLayout(new GridLayout(inscrits.size() + 1, 10));
		
		lblInscrits.add(new JLabel("Sexe", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Position", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Catégorie", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Numéro Dossard", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Nom", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Prénom", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Date Naissance", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("HeureLigneDépart", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("HeureLigneArrivée", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Temps Réel", SwingConstants.CENTER));
		Font boldFont = new Font(lblInscrits.get(0).getFont().getFontName() , Font.BOLD, lblInscrits.get(0).getFont().getSize());
		
		for(int i = 0; i < 10; i++) // on met en gras les polices des 4 premiers labels
		{
			lblInscrits.get(i).setFont(boldFont);
		}

		for(Coureur coureur : inscrits) // on sauvegarde les labels au cas ou
		{
			lblInscrits.add(new JLabel("" + coureur.getSexe(), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(Integer.toString(coureur.getPosition()), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(coureur.getCodeCategorie(), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(Integer.toString(coureur.getNumDossard()), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(coureur.getNom(), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(coureur.getPrenom(), SwingConstants.CENTER));
			lblInscrits.add(new JLabel("" + coureur.getDateNaiss(), SwingConstants.CENTER)); // sans les "", ne fonctionne pas
			lblInscrits.add(new JLabel(coureur.getHeureLigneDepart(), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(coureur.getHeureLigneArrivee(), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(coureur.getTempsReel(), SwingConstants.CENTER));
			
		}
		
		for(JLabel label : lblInscrits) // on traite chaque labels 
		{
			label.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
			panelVueScroll.add(label);
		}
		
		this.add(new JScrollPane(panelVueScroll), BorderLayout.CENTER); // Le bouton en haut de la fenetre
	}
	
	
	public VueRechercheResultat(ArrayList<Coureur> inscrits, Semi_Marathon semi_marathon, Boolean ResultatGeneral)
	{
		// redefinition de la taille de la fenetre
		//semi_marathon.setSize(300, 600);
		
		lblInscrits = new ArrayList<JLabel>();
		panelVueScroll = new JPanel();
		
		this.setLayout(new BorderLayout());
		// nbInscrits ligne + 1 pour les titres et 1 colonne 
		panelVueScroll.setLayout(new GridLayout(inscrits.size() + 1, 11));
		
		lblInscrits.add(new JLabel("Sexe", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Position Générale", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Position Par Sexe", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Catégorie", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Numéro Dossard", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Nom", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Prénom", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Date Naissance", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("HeureLigneDépart", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("HeureLigneArrivée", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Temps Réel", SwingConstants.CENTER));
		Font boldFont = new Font(lblInscrits.get(0).getFont().getFontName() , Font.BOLD, lblInscrits.get(0).getFont().getSize());
		
		for(int i = 0; i < 11; i++) // on met en gras les polices des 4 premiers labels
		{
			lblInscrits.get(i).setFont(boldFont);
		}

		for(Coureur coureur : inscrits) // on sauvegarde les labels au cas ou
		{
			lblInscrits.add(new JLabel("" + coureur.getSexe(), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(Integer.toString(coureur.getPosition()), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(Integer.toString(coureur.getPositionSexe()), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(coureur.getCodeCategorie(), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(Integer.toString(coureur.getNumDossard()), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(coureur.getNom(), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(coureur.getPrenom(), SwingConstants.CENTER));
			lblInscrits.add(new JLabel("" + coureur.getDateNaiss(), SwingConstants.CENTER)); // sans les "", ne fonctionne pas
			lblInscrits.add(new JLabel(coureur.getHeureLigneDepart(), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(coureur.getHeureLigneArrivee(), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(coureur.getTempsReel(), SwingConstants.CENTER));
			
		}
		
		for(JLabel label : lblInscrits) // on traite chaque labels 
		{
			label.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
			panelVueScroll.add(label);
		}
		
		this.add(new JScrollPane(panelVueScroll), BorderLayout.CENTER); // Le bouton en haut de la fenetre
	}
	

}
