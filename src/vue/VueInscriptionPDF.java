package vue;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import modele.Categorie;
import modele.Coureur;
import modele.Ecole_Entreprise;
import modele.Semi_Marathon;
import modele.TypeDossard;

@SuppressWarnings("serial")
public class VueInscriptionPDF extends JPanel implements ActionListener {
	
	private JTextField nom;
	private JTextField prenom;
	private JComboBox<String> sex;
	private JTextField anneeNaissance;
	private JTextField adresse;
	private JTextField codePost;
	private JTextField ville;
	private JTextField etat;
	private JTextField pays;
	private JTextField nationalite;
	private JTextField telephone;
	private JTextField mail;
	private JTextField club;
	private JTextField license;
	private JTextField entreprise;
	private JTextField ecole;
	
	private JRadioButton paiementCheque;
	private JRadioButton paiementCB;
	private JTextField numCB;
	private JTextField moisCB;
	private JTextField anneeCB;
	private JTextField criptoCB;
	
	private ArrayList<JRadioButton> dossard;
	private ArrayList<JRadioButton> prixInscription;
	private JTextField dateInscription;

	private JButton btnValidation;
	
	private JPanel infosPerso;
	private JPanel modalitePaiement;
	private JPanel infosPaiement;
	private JPanel sasDepart;
	
	private Semi_Marathon semiMarathon;
	
	public VueInscriptionPDF(Semi_Marathon semiMarathon)
	{
		this.semiMarathon = semiMarathon;

		btnValidation = new JButton("Inscrire");
		btnValidation.setActionCommand("valider");
		btnValidation.addActionListener(this);
		
		this.setLayout(new BorderLayout());
		
		// Panel infos coureur
		infosPerso = new JPanel();
		
		infosPerso.setLayout(new GridLayout(8,4));
		
		
		MaskFormatter masqueDate = null;
		MaskFormatter masqueCP = null;
		MaskFormatter masqueTelephone = null;
		MaskFormatter masqueNumCB = null;
		MaskFormatter masqueDateCB = null;
		MaskFormatter masqueCrypCB = null;
		try {
			masqueDate = new MaskFormatter("##/##/####");
			masqueCP = new MaskFormatter("#####");
			masqueTelephone = new MaskFormatter("## ## ## ## ##");
			masqueNumCB = new MaskFormatter("#### #### #### ####");
			masqueDateCB = new MaskFormatter("##");
			masqueCrypCB = new MaskFormatter("###");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		nom = new JTextField();
		infosPerso.add(new JLabel("Nom :", SwingConstants.CENTER));
		infosPerso.add(nom);
		
		prenom = new JTextField();
		infosPerso.add(new JLabel("Prenom :", SwingConstants.CENTER));
		infosPerso.add(prenom);
		
		String[] valSex = {"M", "F"};
		sex = new JComboBox<String>(valSex);
		infosPerso.add(new JLabel("Sexe :", SwingConstants.CENTER));
		infosPerso.add(sex);
		
		anneeNaissance =  new JFormattedTextField(masqueDate);
		infosPerso.add(new JLabel("Date Naissance :", SwingConstants.CENTER));
		infosPerso.add(anneeNaissance);
		
		adresse = new JTextField();
		infosPerso.add(new JLabel("Adresse :", SwingConstants.CENTER));
		infosPerso.add(adresse);
		
		codePost = new JFormattedTextField(masqueCP);
		infosPerso.add(new JLabel("Code Postal :", SwingConstants.CENTER));
		infosPerso.add(codePost);
		
		ville = new JTextField();
		infosPerso.add(new JLabel("Ville :", SwingConstants.CENTER));
		infosPerso.add(ville);
		
		etat = new JTextField();
		infosPerso.add(new JLabel("Etat", SwingConstants.CENTER));
		infosPerso.add(etat);
		
		pays = new JTextField();
		infosPerso.add(new JLabel("Pays :", SwingConstants.CENTER));
		infosPerso.add(pays);
		
		nationalite = new JTextField();
		infosPerso.add(new JLabel("Nationalite :", SwingConstants.CENTER));
		infosPerso.add(nationalite);
		
		telephone = new JFormattedTextField(masqueTelephone);
		infosPerso.add(new JLabel("Telephone :", SwingConstants.CENTER));
		infosPerso.add(telephone);
		
		mail = new JTextField();
		infosPerso.add(new JLabel("Mail :", SwingConstants.CENTER));
		infosPerso.add(mail);
		
		club = new JTextField();
		infosPerso.add(new JLabel("Club :", SwingConstants.CENTER));
		infosPerso.add(club);
		
		license = new JTextField();
		infosPerso.add(new JLabel("License :", SwingConstants.CENTER));
		infosPerso.add(license);
		
		entreprise = new JTextField();
		infosPerso.add(new JLabel("Entreprise :", SwingConstants.CENTER));
		infosPerso.add(entreprise);
		
		ecole = new JTextField();
		infosPerso.add(new JLabel("Ecole :", SwingConstants.CENTER));
		infosPerso.add(ecole);
		//
		
		// Panel Modalite Paiement
		modalitePaiement = new JPanel();
		modalitePaiement.setLayout(new BorderLayout());
		
		paiementCheque = new JRadioButton("Cheque à l'ordre de A.S.O");
		paiementCheque.setActionCommand("cheque");
		paiementCheque.addActionListener(this);
		paiementCheque.setHorizontalAlignment(SwingConstants.CENTER);
		
		paiementCB = new JRadioButton("Carte de credit");
		paiementCB.setActionCommand("cb");
		paiementCB.addActionListener(this);
		paiementCB.setHorizontalAlignment(SwingConstants.CENTER);
		
		ButtonGroup grpRadioBtn = new ButtonGroup();
		grpRadioBtn.add(paiementCB);
		grpRadioBtn.add(paiementCheque);
		
		JPanel selectPaiement = new JPanel();
		selectPaiement.add(paiementCheque);
		selectPaiement.add(paiementCB);
		
		infosPaiement = new JPanel();
		infosPaiement.setLayout(new GridLayout(3, 4));
		
		numCB = new JFormattedTextField(masqueNumCB);
		infosPaiement.add(new JLabel("Numero carte credit :", SwingConstants.CENTER));
		infosPaiement.add(numCB);
		infosPaiement.add(new JLabel()); // Pour cadrage
		infosPaiement.add(new JLabel()); // Pour cadrage
		
		moisCB = new JFormattedTextField(masqueDateCB);
		infosPaiement.add(new JLabel("Mois :", SwingConstants.CENTER));
		infosPaiement.add(moisCB);
		
		anneeCB = new JFormattedTextField(masqueDateCB);
		infosPaiement.add(new JLabel("Annee :", SwingConstants.CENTER));
		infosPaiement.add(anneeCB);
		
		criptoCB = new JFormattedTextField(masqueCrypCB);
		infosPaiement.add(new JLabel("3 derniers chiffres :", SwingConstants.CENTER));
		infosPaiement.add(criptoCB);
		infosPaiement.add(new JLabel()); // Pour cadrage
		infosPaiement.add(new JLabel()); // Pour cadrage

		modalitePaiement.add(selectPaiement, BorderLayout.NORTH);
		//
		
		// Panel sas depart
		sasDepart = new JPanel();
		sasDepart.setLayout(new BorderLayout());
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(3,1));
		
		JPanel pnlDossard = new JPanel();
		pnlDossard.setLayout(new GridLayout(3,3));
		
		dossard = new ArrayList<JRadioButton>();
		
		JRadioButton dossardElite = new JRadioButton("Dossard Elite");
		dossardElite.setActionCommand("ELITE");
		dossard.add(dossardElite);
		JRadioButton dossardPref = new JRadioButton("Dossard Preferenciel");
		dossardPref.setActionCommand("PREFERENTIEL");
		dossard.add(dossardPref);
		JRadioButton dossardRouge = new JRadioButton("Dossard Rouge");
		dossardRouge.setActionCommand("ROUGE");
		dossard.add(dossardRouge);
		JRadioButton lievre1h35 = new JRadioButton("Lievre 1h35");
		lievre1h35.setActionCommand("JAUNE");
		dossard.add(lievre1h35);
		JRadioButton lievre1h40 = new JRadioButton("Lievre 1h40");
		lievre1h40.setActionCommand("BLEU");
		dossard.add(lievre1h40);
		JRadioButton lievre1h50 = new JRadioButton("Lievre 1h50");
		lievre1h50.setActionCommand("VIOLET");
		dossard.add(lievre1h50);
		JRadioButton lievre2h = new JRadioButton("Lievre 2h");
		lievre2h.setActionCommand("VERT");
		dossard.add(lievre2h);
		JRadioButton lievre2hplus = new JRadioButton("Lievre 2h et +");
		lievre2hplus.setActionCommand("ROSE");
		dossard.add(lievre2hplus);
		
		ButtonGroup grpDossard = new ButtonGroup();
		for(JRadioButton dossard : this.dossard)
		{
			grpDossard.add(dossard);
			pnlDossard.add(dossard);
		}
		
		JPanel pnlPrix = new JPanel();
		pnlPrix.setLayout(new GridLayout(1,3));
		
		prixInscription = new ArrayList<JRadioButton>();
		
		JRadioButton prix24 = new JRadioButton("24€ du 01/09/2014 au 20/12/2014");
		prix24.setActionCommand("24");
		prixInscription.add(prix24);
		JRadioButton prix27 = new JRadioButton("27€ du 21/12/2014 au 20/01/2015");
		prix27.setActionCommand("27");
		prixInscription.add(prix27);
		JRadioButton prix33 = new JRadioButton("33€ du 21/01/2015 au 10/02/2015");
		prix33.setActionCommand("33");
		prixInscription.add(prix33);
		
		ButtonGroup grpPrix = new ButtonGroup();
		for(JRadioButton prix : prixInscription)
		{
			grpPrix.add(prix);
			pnlPrix.add(prix);
		}
		
		JPanel pnlDate = new JPanel();
		pnlDate.setLayout(new GridLayout(1,2));
		
		dateInscription = new JFormattedTextField(masqueDate);
		pnlDate.add(new JLabel("Date Inscription :", SwingConstants.CENTER));
		pnlDate.add(dateInscription);
					
		pnlCenter.add(pnlDossard);
		pnlCenter.add(pnlPrix);
		pnlCenter.add(pnlDate);
		
		sasDepart.add(pnlCenter, BorderLayout.CENTER);
		sasDepart.add(btnValidation, BorderLayout.SOUTH);
		//
		
		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Infos Coureur", infosPerso);
		tabs.addTab("Modalite Paiement", modalitePaiement);
		tabs.addTab("Sas Depart", sasDepart);
		
		this.add(tabs);
	}
	
	public boolean erreurDonneesSaisie()
	{
		boolean infoIncorrect = false; // On suppose qu'il n'y a pas d'erreur (s'il y a erreur, bool passe vrai)

		// Parcout chaque textfield du panel infos
		for(int i = 1; i <= infosPerso.getComponentCount(); i+=2)
		{
			if(infosPerso.getComponent(i) instanceof JTextField)
			{
				if(infosPerso.getComponent(i) != etat && infosPerso.getComponent(i) != club &&
						infosPerso.getComponent(i) != license && infosPerso.getComponent(i) != entreprise &&
						infosPerso.getComponent(i) != ecole) // Champs facultatif
				{
					if(((JTextField) infosPerso.getComponent(i)).getText().length() == 0 || ((JTextField) infosPerso.getComponent(i)).getText().charAt(0) == ' ')
					{
						metLblPrecedentCouleur(infosPerso, infosPerso.getComponent(i), "red");
						infoIncorrect = true;
					}
					else
						metLblPrecedentCouleur(infosPerso, infosPerso.getComponent(i), "black");
				}
			}
		}
		
		// Verification choix paiement
		if(!paiementCheque.isSelected() && !paiementCB.isSelected())
		{
			infoIncorrect = true;
			metRadioBtnCouleur(paiementCheque, "red");
			metRadioBtnCouleur(paiementCB, "red");
		}
		else
		{
			metRadioBtnCouleur(paiementCheque, "black");
			metRadioBtnCouleur(paiementCB, "black");
		}
			
		if(paiementCB.isSelected())
		{
			for(int i = 1; i <= infosPaiement.getComponentCount(); i+=2)
			{
				if(infosPaiement.getComponent(i) instanceof JTextField)
				{
					if(((JTextField) infosPaiement.getComponent(i)).getText().length() == 0 || ((JTextField) infosPaiement.getComponent(i)).getText().charAt(0) == ' ')
					{
						metLblPrecedentCouleur(infosPaiement, infosPaiement.getComponent(i), "red");
						infoIncorrect = true;
					}
					else
						metLblPrecedentCouleur(infosPaiement, infosPaiement.getComponent(i), "black");
				}
			}
		}
		
		// Verification sasDepart
		boolean dossardNonSelect = false;
		int i = 0;
		while(i<dossard.size() && !dossard.get(i).isSelected())
			i++;
		if(i>=dossard.size() || !dossard.get(i).isSelected()) // si aucun selectionner on va jusqua i=taille
			// => IndexOutOfBound
		{
			dossardNonSelect = true;
			infoIncorrect = true;
		}
		
		for(JRadioButton radio : dossard)
		{
			if(dossardNonSelect)
				metRadioBtnCouleur(radio, "red");
			else
				metRadioBtnCouleur(radio, "black");
		}
		
		boolean prixNonSelect = false;
		i = 0;
		while(i<prixInscription.size() && !prixInscription.get(i).isSelected())
			i++;
		if(i>=prixInscription.size() || !prixInscription.get(i).isSelected()) // si aucun selectionner on va jusqua i=taille
			// => IndexOutOfBound
		{
			prixNonSelect = true;
			infoIncorrect = true;
		}
		
		for(JRadioButton radio : prixInscription)
		{
			if(prixNonSelect)
				metRadioBtnCouleur(radio, "red");
			else
				metRadioBtnCouleur(radio, "black");
		}
		
		JPanel pnlCenterSas = (JPanel) ((Container) sasDepart.getComponents()[0]).getComponents()[2];
		if(dateInscription.getText().charAt(0) == ' ')
		{
			infoIncorrect = true;
			metLblPrecedentCouleur(pnlCenterSas, dateInscription, "red");
		}
		else
			metLblPrecedentCouleur(pnlCenterSas, dateInscription, "black");
		
		
		return infoIncorrect;
	}
	
	public void metLblPrecedentCouleur(JPanel panel, Component composent, String couleur)
	{
		int i = 0;
		while(i < panel.getComponentCount() && panel.getComponent(i) != composent)
		{ i++; }
		if(panel.getComponent(i-1) instanceof JLabel)
		{				
			JLabel lblPrecedent = (JLabel) panel.getComponent(i-1);
			
			if(lblPrecedent.getText().charAt(0) != '<') // Si il n'y a pas de couleur, il n'est pas en html
			{
				lblPrecedent.setText(	"<html><span style=color:" + couleur + ";>" + 
										lblPrecedent.getText() + 
										"</span></html>");
			}
			else // Si deja un span, il faut le supprimer pour changer couleur
			{
				int debutText = lblPrecedent.getText().indexOf(";>") + 2; // Indique le debut du motif 
				// donc la fin = debut motif + taille motif
				int finText = lblPrecedent.getText().indexOf("</span>");
				
				lblPrecedent.setText(	"<html><span style=color:" + couleur + ";>" + 
						lblPrecedent.getText().substring(debutText, finText) + 
						"</span></html>");
			}
		}
		this.repaint();
	}
	
	public void metRadioBtnCouleur(JRadioButton radio, String couleur)
	{
		if(radio.getText().charAt(0) != '<') // Si il n'y a pas de couleur, il n'est pas en html
		{
			radio.setText(	"<html><span style=color:" + couleur + ";>" + 
							radio.getText() + 
							"</span></html>");
		}
		else // Si deja un span, il faut le supprimer pour changer couleur
		{
			int debutText = radio.getText().indexOf(";>") + 2; // Indique le debut du motif 
			// donc la fin = debut motif + taille motif
			int finText = radio.getText().indexOf("</span>");
			
			radio.setText(	"<html><span style=color:" + couleur + ";>" + 
					radio.getText().substring(debutText, finText) + 
					"</span></html>");
		}
		
		this.repaint();
	}

	
	public void actionPerformed(ActionEvent e) {
		// Gestion btn
		if(e.getSource() instanceof JButton)
		{
			JButton btn = (JButton)e.getSource();
			
			if(btn.getActionCommand() == "valider")
			{
				if(erreurDonneesSaisie())
					JOptionPane.showMessageDialog(this, "Information manquante ou incorrecte",
						"Erreur", JOptionPane.WARNING_MESSAGE);
				else
				{
					String institution;
					if(entreprise.getText().length() != 0)
						institution = entreprise.getText();
					else
						institution = ecole.getText();
					
					Ecole_Entreprise institutionTmp = semiMarathon.getInstitution(institution);
					
					int i=0;
					while(i<dossard.size() && !dossard.get(i).isSelected())
					{ i++; }
					TypeDossard typeDossardTmp = semiMarathon.getTypeDossard(dossard.get(i).getActionCommand());
					
					Date dateNaissance = convertiStringDate(anneeNaissance.getText());
					
					String telephoneSansEspace = telephone.getText().replace(" ", "");
					String numCBSansEspace = numCB.getText().replace(" ", "");
					
					Categorie catTmp = semiMarathon.getCategorie(dateNaissance.getYear());

					Coureur coureurTmp = new Coureur(nom.getText(), prenom.getText(), 
						sex.getItemAt(sex.getSelectedIndex()).charAt(0),
						dateNaissance, adresse.getText(), Integer.parseInt(codePost.getText()), 
						ville.getText(),
						pays.	getText(), nationalite.getText(), Long.parseLong(telephoneSansEspace), 
						mail.getText(),
						club.getText(), Integer.parseInt(license.getText()), institutionTmp, catTmp);
					
					if(paiementCheque.isSelected())
						coureurTmp.setPaiement("cheque");
					else if(paiementCB.isSelected())
						coureurTmp.setPaiement("cb", Long.parseLong(numCBSansEspace), 
								Integer.parseInt(moisCB.getText()), Integer.parseInt(anneeCB.getText()),
								Integer.parseInt(criptoCB.getText()));
					
					catTmp.ajoutCoureur(coureurTmp);

					if(typeDossardTmp != null)
						coureurTmp.setTypeDossard(typeDossardTmp);
					
					institutionTmp.ajoutCoureur(coureurTmp);
					semiMarathon.ajoutCoureur(coureurTmp);
					
					int numDossard = coureurTmp.getNumDossard();
					
					JOptionPane.showMessageDialog(this, "<html><center>Inscription confirmé,<br>"
							+ "vous allez recevoir un email de confirmation<br>"
							+ "(Nan je rigole, c'est pour faire genre)<br>"
							+ "Numero Dossard : " + numDossard + "</center></html>");
				}
			}
		}
		
		// Gestion RadioButton
		if(e.getSource() instanceof JRadioButton)
		{
			if(e.getActionCommand() == "cb")
				modalitePaiement.add(infosPaiement, BorderLayout.CENTER);
			else if(e.getActionCommand() == "cheque")
				modalitePaiement.remove(infosPaiement);
			
			this.repaint();
		}
	}
	
	private Date convertiStringDate(String date)
	{

		char jourChar[] = {date.charAt(0), date.charAt(1)};
		char moisChar[] = {date.charAt(3), date.charAt(4)};
		char anneeChar[] = {date.charAt(6), date.charAt(7), date.charAt(8), date.charAt(9)};
		
		String jour = new String(jourChar);
		String mois = new String(moisChar);
		String annee = new String(anneeChar);
		
		Date dateReturn = new Date(Integer.parseInt(annee), Integer.parseInt(mois), Integer.parseInt(jour));

		return dateReturn;	
		
	}

}
