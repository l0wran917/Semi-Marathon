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
import javax.swing.SwingConstants;

import modele.Rue;

@SuppressWarnings("serial") // Evite un warning
public class VuePrecisionsParcours extends JPanel{
	
	private ArrayList<JLabel> lblRues;
	private JPanel panelVueScroll;
	
	public VuePrecisionsParcours(ArrayList<Rue> rues)
	{
		// redefinition de la taille de la fenetre
		//semi_marathon.setSize(300, 600);

		lblRues = new ArrayList<JLabel>();
		panelVueScroll = new JPanel();

		this.setLayout(new BorderLayout());
		// nbInscrits ligne + 1 pour les titres et 1 colonne 
		panelVueScroll.setLayout(new GridLayout(rues.size() + 1, 3));

		lblRues.add(new JLabel("Numéro", SwingConstants.CENTER));
		lblRues.add(new JLabel("Nom", SwingConstants.CENTER));
		lblRues.add(new JLabel("Km", SwingConstants.CENTER));
		Font boldFont = new Font(lblRues.get(0).getFont().getFontName() , Font.BOLD, lblRues.get(0).getFont().getSize());

		for(int i = 0; i < 3; i++) // on met en gras les polices des 4 premiers labels
		{
			lblRues.get(i).setFont(boldFont);
		}

		for(Rue rue : rues) // on sauvegarde les labels au cas ou
		{
			lblRues.add(new JLabel(Integer.toString(rue.getNumOrdre()), SwingConstants.CENTER));
			lblRues.add(new JLabel(rue.getNom(), SwingConstants.CENTER));
			lblRues.add(new JLabel(rue.getPointControle(), SwingConstants.CENTER));
		}
		

		for(JLabel label : lblRues) // on traite chaque labels 
		{
			label.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
			panelVueScroll.add(label);
		}
		
		

		this.add(new JScrollPane(panelVueScroll), BorderLayout.CENTER); // Le bouton en haut de la fenetre




	}

	
}




