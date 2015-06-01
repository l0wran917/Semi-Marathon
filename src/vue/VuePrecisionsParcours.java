package vue;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Partenaire;
import modele.Rue;;

@SuppressWarnings("serial") // Evite un warning
public class VuePrecisionsParcours extends JPanel{
	
	private ArrayList<JLabel> lblRues;
	
	public VuePrecisionsParcours(ArrayList<Rue> rues)
	{
		// nbPartenaire ligne et 1 colonne
		this.setLayout(new GridLayout(rues.size(), 1)); 

		lblRues = new ArrayList<JLabel>();
		
		for(Rue rue : rues)
		{
			String texteAffiche = rue.getNom() + " : " + rue.getEmail(); 
			
			// Stock les labels s'il y a besoin de les modifier
			lblRues.add(new JLabel(texteAffiche));
			lblRues.get(0).setHorizontalTextPosition(0);
			
			// Ajout au panel
			this.add(lblRues.get(lblRues.size()-1));
		}
		
	}
	
	
}




