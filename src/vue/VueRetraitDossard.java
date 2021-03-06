package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.Coureur;
import modele.Semi_Marathon;

@SuppressWarnings("serial")
public class VueRetraitDossard extends JPanel implements ActionListener{

	private JTextField numDossard;
	private JButton btnValider;
	
	private Semi_Marathon semiMarathon;
	
	public VueRetraitDossard(Semi_Marathon semiMarathon)
	{
		this.semiMarathon = semiMarathon;
		//semiMarathon.setSize(330, 300);
		
		this.setLayout(new BorderLayout());
		
		JPanel pnlSaisieNumDossard = new JPanel();
		pnlSaisieNumDossard.setLayout(new GridLayout(3, 4));
		
		JLabel lblNumDossard = new JLabel("Numero :");
		numDossard = new JTextField();
		//pnlSaisieNumDossard.add(lblNumDossard);
		
		for(int i = 0; i < 5; i++)
			pnlSaisieNumDossard.add(new JLabel());
		
		pnlSaisieNumDossard.add(lblNumDossard);
		pnlSaisieNumDossard.add(numDossard);
		
		for(int i = 0; i < 5; i++)
			pnlSaisieNumDossard.add(new JLabel());
		
		
		btnValider = new JButton("Enregistrer retrait dossard");
		btnValider.setActionCommand("valider");
		btnValider.addActionListener(this);
		
		this.add(pnlSaisieNumDossard, BorderLayout.CENTER);
		this.add(btnValider, BorderLayout.SOUTH);

	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton)
		{
			if(((JButton)e.getSource()).getActionCommand() == "valider")
			{
				try
				{
					Coureur coureurTmp = semiMarathon.getCoureur(Integer.parseInt(numDossard.getText()));
					if(coureurTmp != null)
					{
						if(coureurTmp.getDossardRetire()) // Si deja retiré
							JOptionPane.showMessageDialog(this, "Dossard déja retiré", "Erreur", JOptionPane.ERROR_MESSAGE);
						else
						{
							coureurTmp.validerRetraitDossard();
							JOptionPane.showMessageDialog(this, "Retrait enregistré");
						}	
					}
					else
					{
						// Coureur n'existe pas
						JOptionPane.showMessageDialog(this, "Numero de dossard inexistant", "Erreur", JOptionPane.ERROR_MESSAGE);	
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(this, "Valeur saisie incorrecte", "Erreur", JOptionPane.ERROR_MESSAGE);	
				}
			}
		}
	}
	
}
