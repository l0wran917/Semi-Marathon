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

import modele.Coureur;
import modele.Ecole_Entreprise;
import modele.Semi_Marathon;

@SuppressWarnings("serial") // Evite un warning
public class VueEcoleEntreprise  extends JPanel{
	
	private ArrayList<JLabel> lblEcolesEntreprises;
	private JPanel panelVueScroll;
	
	public VueEcoleEntreprise(ArrayList<Ecole_Entreprise> ecoles_Entreprises, Semi_Marathon semi_marathon)
	{
		// redefinition de la taille de la fenetre
		//semi_marathon.setSize(300, 600);
		
		lblEcolesEntreprises = new ArrayList<JLabel>();
		panelVueScroll = new JPanel();
		
		this.setLayout(new BorderLayout());
		// nbInscrits ligne + 1 pour les titres et 1 colonne 
		panelVueScroll.setLayout(new GridLayout(ecoles_Entreprises.size() + 1, 1));
		
		lblEcolesEntreprises.add(new JLabel("Nom", SwingConstants.CENTER));
		Font boldFont = new Font(lblEcolesEntreprises.get(0).getFont().getFontName() , Font.BOLD, lblEcolesEntreprises.get(0).getFont().getSize());
		
		lblEcolesEntreprises.get(0).setFont(boldFont);

		for(Ecole_Entreprise ecole_entreprise : ecoles_Entreprises) // on sauvegarde les labels au cas ou
		{
			lblEcolesEntreprises.add(new JLabel(ecole_entreprise.getNom(), SwingConstants.CENTER));
		}
		
		for(JLabel label : lblEcolesEntreprises) // on traite chaque labels 
		{
			label.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
			panelVueScroll.add(label);
		}
		
		this.add(new JScrollPane(panelVueScroll), BorderLayout.CENTER); // Le bouton en haut de la fenetre
	}
}