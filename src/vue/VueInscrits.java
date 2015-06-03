package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import modele.Coureur;
import modele.Semi_Marathon;

@SuppressWarnings("serial") // Evite un warning
public class VueInscrits extends JPanel{
	
	private ArrayList<JLabel> lblInscrits;
	private JPanel panelVueScroll;
	
	public VueInscrits(ArrayList<Coureur> inscrits, Semi_Marathon semi_marathon)
	{
		// redefinition de la taille de la fenetre
		//semi_marathon.setSize(300, 600);
		
		lblInscrits = new ArrayList<JLabel>();
		panelVueScroll = new JPanel();
		
		this.setLayout(new BorderLayout());
		// nbInscrits ligne + 1 pour les titres et 1 colonne 
		panelVueScroll.setLayout(new GridLayout(inscrits.size() + 1, 4));
		
		lblInscrits.add(new JLabel("Numéro", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Nom", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Prénom", SwingConstants.CENTER));
		lblInscrits.add(new JLabel("Date", SwingConstants.CENTER));
		Font boldFont = new Font(lblInscrits.get(0).getFont().getFontName() , Font.BOLD, lblInscrits.get(0).getFont().getSize());
		
		for(int i = 0; i < 4; i++) // on met en gras les polices des 4 premiers labels
		{
			lblInscrits.get(i).setFont(boldFont);
		}

		for(Coureur coureur : inscrits) // on sauvegarde les labels au cas ou
		{
			lblInscrits.add(new JLabel(Integer.toString(coureur.getNumDossard()), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(coureur.getNom(), SwingConstants.CENTER));
			lblInscrits.add(new JLabel(coureur.getPrenom(), SwingConstants.CENTER));
			lblInscrits.add(new JLabel("" + coureur.getDateNaiss(), SwingConstants.CENTER)); // sans les "", ne fonctionne pas
		}
		
		for(JLabel label : lblInscrits) // on traite chaque labels 
		{
			label.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
			panelVueScroll.add(label);
		}
		
		this.add(new JScrollPane(panelVueScroll), BorderLayout.CENTER); // Le bouton en haut de la fenetre
	}
}