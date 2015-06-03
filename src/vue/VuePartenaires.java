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
import modele.Partenaire;
import modele.Semi_Marathon;

@SuppressWarnings("serial") // Evite un warning
public class VuePartenaires extends JPanel{
	
	private ArrayList<JLabel> lblPartenaires;
	private JPanel panelVueScroll;
	private JButton boutonQuitter;
	
	public VuePartenaires(ArrayList<Partenaire> partenaires, Semi_Marathon semi_marathon)
	{
		// redefinition de la taille de la fenetre
		//semi_marathon.setSize(300, 600);		
		lblPartenaires = new ArrayList<JLabel>();
		panelVueScroll = new JPanel();
		boutonQuitter = new JButton("Quitter");
				
		this.setLayout(new BorderLayout());
		// nbInscrits ligne + 1 pour les titres et 1 colonne 
		panelVueScroll.setLayout(new GridLayout(partenaires.size() + 1, 3));
				
		lblPartenaires.add(new JLabel("Nom", SwingConstants.CENTER));
		lblPartenaires.add(new JLabel("Email", SwingConstants.CENTER));
		lblPartenaires.add(new JLabel("Logo", SwingConstants.CENTER));
		Font boldFont = new Font(lblPartenaires.get(0).getFont().getFontName() , Font.BOLD, lblPartenaires.get(0).getFont().getSize());

		for(int i = 0; i < lblPartenaires.size(); i++) // on met en gras les polices des 4 premiers labels
		{
			lblPartenaires.get(i).setFont(boldFont);
		}

		for(Partenaire partenaire : partenaires) // on sauvegarde les labels au cas ou
		{
			lblPartenaires.add(new JLabel(partenaire.getNom(), SwingConstants.CENTER));
			lblPartenaires.add(new JLabel(partenaire.getEmail(), SwingConstants.CENTER));
			lblPartenaires.add(new JLabel("logo.jpg", SwingConstants.CENTER));
		}
				
		for(JLabel label : lblPartenaires) // on traite chaque labels 
		{
			label.setHorizontalTextPosition(0);
			label.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
			panelVueScroll.add(label);
		}
				
		this.add(new JScrollPane(panelVueScroll), BorderLayout.CENTER); // Le bouton en haut de la fenetre
		this.add(boutonQuitter, BorderLayout.NORTH); // la liste au milieu
	
	}
	
}
