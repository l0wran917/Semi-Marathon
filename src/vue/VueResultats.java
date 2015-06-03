package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VueResultats extends JPanel implements ActionListener{

	private JButton btnClassementH;
	private JButton btnClassementF;
	private JButton btnClassementG;
	
	private JTextField nom;
	private JTextField num;
	private JTextField pos;
	
	public VueResultats()
	{
		this.setLayout(new GridLayout(4,1));
		
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
		switch(e.getActionCommand())
		{
			case "homme" :
				
			break;
			case "femme" :
				
			break;
			case "general" :
				
			break;
			case "nom" :
				
			break;
			case "num" :
				
			break;
			case "pos" :
				
			break;
			default:
				// Erreur 
			break;
		}
	}
	
}
