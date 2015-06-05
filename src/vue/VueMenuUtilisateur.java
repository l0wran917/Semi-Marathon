package vue;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import modele.Semi_Marathon;

@SuppressWarnings("serial")
public class VueMenuUtilisateur extends JPanel implements ActionListener {

	private Semi_Marathon semiMarathon;
	
	private JPanel pnlTitre;
	private JPanel pnlCenter;
	
	private JButton inscription;
	private JButton parcours;
	private JButton admin;
	private JButton resultats;
	private JButton inscrits;
	private JButton partenaires;
	
	private JLabel lieu;
	private JLabel date;
	private JLabel distance;
	private JLabel nbCoureur;
	
	private JPanel pnlInfos;
	
	public static final String INSCRIPTION = "Inscription";
	public static final String PARCOURS = "Parcours";
	public static final String RESULTATS = "Resultats";
	public static final String INSCRITS = "Inscrits";
	public static final String PARTENAIRES = "Partenaires";
	public static final String ADMIN_MDP = "Connexion administrateur";
	public static final String ADMIN = "Administration";
	public static final String CLASSEMENT = "Classement";
	public static final String CLASSEMENT_SEXE = "Classement sexe";
	
	
	public VueMenuUtilisateur(Semi_Marathon semiMarathon)
	{
		this.semiMarathon = semiMarathon;
		
		this.setLayout(new BorderLayout());
		
		pnlTitre = new JPanel();
		pnlTitre.setLayout(new BorderLayout());
		
		JLabel titre = new JLabel("Semi Marathon", SwingConstants.CENTER);
		titre.setFont(new Font(titre.getFont().getFontName(), titre.getFont().getStyle(), 46));
		pnlTitre.add(titre, BorderLayout.NORTH);
		
		pnlInfos = new JPanel();
		pnlInfos.setLayout(new GridLayout(1, 4));

		lieu = new JLabel("Lieu : " + semiMarathon.getVille(), SwingConstants.CENTER);
		date = new JLabel("Date : " + semiMarathon.getDate(), SwingConstants.CENTER);
		distance = new JLabel("Distance : " + semiMarathon.getDistance() + " Km", SwingConstants.CENTER);
		nbCoureur = new JLabel("Coureur : " + semiMarathon.getNbInscrits() + " / " + semiMarathon.getNbMaxCoureur(), 
				SwingConstants.CENTER);
		
		
		pnlInfos.add(lieu);
		pnlInfos.add(date);		
		pnlInfos.add(distance);
		pnlInfos.add(nbCoureur);
		
		pnlTitre.add(pnlInfos, BorderLayout.CENTER);
		
		pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(1, 3));
		
		inscription = new JButton("Inscription");
		inscription.addActionListener(this);
		inscription.setActionCommand(INSCRIPTION);
		
		parcours = new JButton("Parcours");
		parcours.addActionListener(this);
		parcours.setActionCommand(PARCOURS);
		
		admin = new JButton("Admin");
		admin.addActionListener(this);
		admin.setActionCommand(ADMIN_MDP);
		
		resultats = new JButton("Resultats");
		resultats.addActionListener(this);
		resultats.setActionCommand(RESULTATS);
		
		inscrits = new JButton("Inscrits");
		inscrits.addActionListener(this);
		inscrits.setActionCommand(INSCRITS);
		
		partenaires = new JButton("Partenaires");
		partenaires.addActionListener(this);
		partenaires.setActionCommand(PARTENAIRES);

		JPanel pnlBtnGauche = new JPanel();
		pnlBtnGauche.setLayout(new GridLayout(7, 2));
		
		for(int i=0; i < 3; i++)
			pnlBtnGauche.add(new JLabel());
		pnlBtnGauche.add(inscription);
		
		for(int i=0; i < 3; i++)
			pnlBtnGauche.add(new JLabel());		
		pnlBtnGauche.add(parcours);
		
		for(int i=0; i < 3; i++)
			pnlBtnGauche.add(new JLabel());		
		pnlBtnGauche.add(admin);
		
		for(int i=0; i < 2; i++)
			pnlBtnGauche.add(new JLabel());
		
		
		JPanel pnlImg = new JPanel();
		pnlImg.add(new JLabel(new ImageIcon("assets/affiche.png")));
		
		
		JPanel pnlBtnDroite = new JPanel();
		pnlBtnDroite.setLayout(new GridLayout(7, 2));
		
		for(int i=0; i < 2; i++)
			pnlBtnDroite.add(new JLabel());
		pnlBtnDroite.add(resultats);
		
		for(int i=0; i < 3; i++)
			pnlBtnDroite.add(new JLabel());
		pnlBtnDroite.add(inscrits);
		
		for(int i=0; i < 3; i++)
			pnlBtnDroite.add(new JLabel());
		pnlBtnDroite.add(partenaires);
		
		for(int i=0; i < 3; i++)
			pnlBtnDroite.add(new JLabel());
		
		
		pnlCenter.add(pnlBtnGauche);
		pnlCenter.add(pnlImg);
		pnlCenter.add(pnlBtnDroite);
		
		this.add(pnlTitre, BorderLayout.NORTH);
		this.add(pnlCenter, BorderLayout.CENTER);
	}
	
	public void refreshInfos()
	{
		System.out.println("Refresh");
		
		((JLabel) pnlInfos.getComponent(0)).setText("Lieu : " + semiMarathon.getVille());
		((JLabel) pnlInfos.getComponent(1)).setText("Date : " + semiMarathon.getDate());
		((JLabel) pnlInfos.getComponent(2)).setText("Distance : " + semiMarathon.getDistance() + " Km");
		((JLabel) pnlInfos.getComponent(3)).setText("Coureur : " + semiMarathon.getNbInscrits() + " / " + 
													semiMarathon.getNbMaxCoureur());
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof JButton)
		{
			semiMarathon.ouvrir(e.getActionCommand());
		}
		
	}
	
	

}
