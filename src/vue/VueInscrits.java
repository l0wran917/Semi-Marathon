package vue;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Coureur;

@SuppressWarnings("serial") // Evite un warning
public class VueInscrits extends JPanel{
	
	private ArrayList<JLabel> lblInscrits;
	
	public VueInscrits(ArrayList<Coureur> inscrits)
	{
		// nbInscrits ligne et 1 colonne
		this.setLayout(new GridLayout(inscrits.size(), 1)); 

		lblInscrits = new ArrayList<JLabel>();
		
		for(Coureur coureur : inscrits)
		{
			String texteAffiche = coureur.getNumDossard() + " : " + coureur.getNom() + " " + coureur.getPrenom() + " " + coureur.getDateNaiss() ;
			
			// Stock les labels s'il y a besoin de les modifier
			lblInscrits.add(new JLabel(texteAffiche));
			lblInscrits.get(0).setHorizontalTextPosition(0);
			
			// Ajout au panel
			this.add(lblInscrits.get(lblInscrits.size()-1));
		}	
	}
}
