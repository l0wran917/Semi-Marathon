package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modele.Coureur;
import modele.Semi_Marathon;

public class VueResultats extends JPanel implements ActionListener{

	private JButton btnClassementH;
	private JButton btnClassementF;
	private JButton btnClassementG;
	
	private JTextField nom;
	private JTextField num;
	private JTextField pos;

	private ArrayList<Coureur> coureurs;
	private Semi_Marathon semiMarathon;
	
	public VueResultats(ArrayList<Coureur> coureurs, Semi_Marathon semiMarathon)
	{
		
		this.semiMarathon = semiMarathon;
		this.setLayout(new GridLayout(4,1));
		
		this.coureurs = coureurs;
		trierCoureurs(coureurs); // on tri les coureurs par temps reel
		
		JPanel troisBtn = new JPanel();
		troisBtn.setLayout(new BorderLayout());
		
		JPanel pnlMiseEnPage = new JPanel();
		pnlMiseEnPage.setLayout(new GridLayout(3, 3));
		
		btnClassementH = new JButton("Homme");
		btnClassementH.addActionListener(this);
		btnClassementH.setActionCommand("homme");
		
		btnClassementF = new JButton("Femme"); 
		btnClassementF.addActionListener(this);
		btnClassementF.setActionCommand("femme");
		
		btnClassementG = new JButton("General");
		btnClassementG.addActionListener(this);
		btnClassementG.setActionCommand("general");

		pnlMiseEnPage.add(new JLabel());
		pnlMiseEnPage.add(new JLabel("Classement :", SwingConstants.CENTER));
		pnlMiseEnPage.add(new JLabel());
		
		pnlMiseEnPage.add(btnClassementH);
		pnlMiseEnPage.add(btnClassementF);
		pnlMiseEnPage.add(btnClassementG);
		
		for(int i=0; i < 3; i++)
			pnlMiseEnPage.add(new JLabel());
			
		troisBtn.add(new JLabel("       "), BorderLayout.EAST); // Mise en page
		troisBtn.add(pnlMiseEnPage, BorderLayout.CENTER);
		troisBtn.add(new JLabel("       "), BorderLayout.WEST); // Mise en page
		
		//
		
		JPanel pnlNom = new JPanel();
		pnlNom.setLayout(new GridLayout(2, 5));
		
		pnlNom.add(new JLabel()); // Mise en page

		JButton validerNom = new JButton("Rechercher");
		validerNom.addActionListener(this);
		validerNom.setActionCommand("nom");
		nom = new JTextField();
		pnlNom.add(new JLabel("Nom :", SwingConstants.CENTER));
		pnlNom.add(nom);
		pnlNom.add(validerNom);
		
		pnlNom.add(new JLabel()); // Mise en page
		for(int i=0; i < 5; i++) // Mise en page
			pnlNom.add(new JLabel()); // Mise en page
		
		//
		
		JPanel pnlNum = new JPanel();
		pnlNum.setLayout(new GridLayout(2, 5));

		pnlNum.add(new JLabel()); // Mise en page
		
		JButton validerNum = new JButton("Rechercher");
		validerNum.addActionListener(this);
		validerNum.setActionCommand("num");
		num = new JTextField();
		pnlNum.add(new JLabel("Numero :", SwingConstants.CENTER));
		pnlNum.add(num);
		pnlNum.add(validerNum);
		
		pnlNum.add(new JLabel());

		for(int i=0; i < 5; i++) // Mise en page
			pnlNum.add(new JLabel()); // Mise en page
		
		//
		
		JPanel pnlPos = new JPanel();
		pnlPos.setLayout(new GridLayout(2, 5));
		
		pnlPos.add(new JLabel());

		JButton validerPos = new JButton("Rechercher");
		validerPos.addActionListener(this);
		validerPos.setActionCommand("pos");
		pos = new JTextField();
		pnlPos.add(new JLabel("Position :", SwingConstants.CENTER));
		pnlPos.add(pos);
		pnlPos.add(validerPos);
		
		for(int i=0; i < 5; i++)
			pnlPos.add(new JLabel());
		pnlPos.add(new JLabel());
		
		this.add(troisBtn);
		this.add(pnlNom);
		this.add(pnlNum);
		this.add(pnlPos);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch(e.getActionCommand())
		{
			case "homme" :
				semiMarathon.ouvrir("Classement sexe", chercherCoureur('H'));
			break;
			case "femme" :
				semiMarathon.ouvrir("Classement sexe", chercherCoureur('F'));
			break;
			case "general" :
				semiMarathon.ouvrir("Classement", chercherCoureur());
			break;
			case "nom" :
				semiMarathon.ouvrir("Classement", chercherCoureur(nom.getText())); // ne marche pas ??!!
			break;
			case "num" :
				if(isNumeric(num.getText()))
				{
					semiMarathon.ouvrir("Classement", chercherCoureur(Integer.parseInt(num.getText())));
				}
			break;
			case "pos" :
				if(isNumeric(pos.getText()))
				{
					semiMarathon.ouvrir("Classement", chercherCoureurPos(Integer.parseInt(pos.getText())));
				}
			break;
			default:
				// Erreur 
			break;
		}
	}
	
	public ArrayList<Coureur> chercherCoureur(char sexe) 
	{
		ArrayList<Coureur> classementCoureurs = new ArrayList<Coureur>();
		
		for(Coureur coureur : coureurs)
		{
			if(coureur.getSexe() == sexe)
			{
				classementCoureurs.add(coureur);
			}
		}
		for(int i = 1; i < classementCoureurs.size() + 1; i++)
		{
			classementCoureurs.get(i - 1).setPositionSexe(i);
		}
		
		return classementCoureurs;
	}
	
	public ArrayList<Coureur> chercherCoureur()
	{
		ArrayList<Coureur> classementCoureurs = new ArrayList<Coureur>();
		
		for(Coureur coureur : coureurs)
		{
			classementCoureurs.add(coureur);
		}
		return classementCoureurs;
	}
	
	public ArrayList<Coureur> chercherCoureur(String nom)
	{
		ArrayList<Coureur> classementCoureurs = new ArrayList<Coureur>();
		
		for(Coureur coureur : coureurs)
		{
			if(coureur.getNom().toUpperCase().compareTo(nom.toUpperCase()) == 0)
			{
				classementCoureurs.add(coureur);
			}
		}
		return classementCoureurs;
	}
	
	public ArrayList<Coureur> chercherCoureur(int num)
	{
		ArrayList<Coureur> classementCoureurs = new ArrayList<Coureur>();
		
		for(Coureur coureur : coureurs)
		{
			if(coureur.getNumDossard() == num){
				classementCoureurs.add(coureur);
			}
			
		}
		return classementCoureurs;
	}
	
	public ArrayList<Coureur> chercherCoureurPos(int position)
	{
		ArrayList<Coureur> classementCoureurs = new ArrayList<Coureur>();
		
		for(Coureur coureur : coureurs)
		{
			if(coureur.getPosition() == position){
				classementCoureurs.add(coureur);
			}
			
		}
		return classementCoureurs;
	}
	
	public static boolean isNumeric(String str)
	  {
	    try
	    {
	      double d = Double.parseDouble(str);
	    }
	    catch(NumberFormatException nfe)
	    {
	      return false;
	    }
	    return true;
	  }
	
	
	public void trierCoureurs(ArrayList<Coureur> coureurs)
	{
		Collections.sort(coureurs);
		for(int i = 1; i < coureurs.size() + 1 ; i++)
		{
			coureurs.get(i-1).setPosition(i);
		}
	}

	
	
}
