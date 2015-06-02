package vue;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Partenaire;

@SuppressWarnings("serial") // Evite un warning
public class VuePartenaires extends JPanel{
	
	private ArrayList<JLabel> lblPartenaires;
	
	public VuePartenaires(ArrayList<Partenaire> partenaires)
	{
		// nbPartenaire ligne et 1 colonne
		this.setLayout(new GridLayout(partenaires.size(), 1)); 

		lblPartenaires = new ArrayList<JLabel>();
		
		for(Partenaire partenaire : partenaires)
		{
			String texteAffiche = partenaire.getNom() + " : " + partenaire.getEmail(); 
			
			// Stock les labels s'il y a besoin de les modifier
			lblPartenaires.add(new JLabel(texteAffiche));
			lblPartenaires.get(0).setHorizontalTextPosition(0);
			
			// Ajout au panel
			this.add(lblPartenaires.get(lblPartenaires.size()-1));
		}
		
	}
	
}
