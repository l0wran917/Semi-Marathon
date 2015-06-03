package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import modele.Semi_Marathon;

public class VueMdpAdmin extends JPanel implements ActionListener {

	private JPasswordField mdp;
	private JButton valider;
	
	private Semi_Marathon semiMarathon;
	
	public VueMdpAdmin(Semi_Marathon semiMarathon)
	{
		// 290, 75
		
		this.semiMarathon = semiMarathon;
		
		this.setLayout(new BorderLayout());
		
		JPanel pnlMdp = new JPanel();
		pnlMdp.setLayout(new GridLayout(2, 1));
		pnlMdp.add(new JLabel("Mot de passe :", SwingConstants.CENTER));
		
		JPanel pnlSaisie = new JPanel();
		
		mdp = new JPasswordField();
		valider = new JButton("Valider");
		valider.addActionListener(this);
		valider.setActionCommand("valider");
		
		pnlSaisie.setLayout(new GridLayout(1, 2));
		pnlSaisie.add(mdp);
		pnlSaisie.add(valider);
		
		pnlMdp.add(pnlSaisie);
		
		this.add(new JLabel("       "), BorderLayout.EAST); // Mise en page
		this.add(pnlMdp, BorderLayout.CENTER);
		this.add(new JLabel("Un indice, c'est : motdepasse", SwingConstants.CENTER), BorderLayout.SOUTH);
		this.add(new JLabel("       "), BorderLayout.WEST); // Mise en page
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "valider")
		{
			if(Arrays.equals(mdp.getPassword(), "motdepasse".toCharArray()))
			{
				JOptionPane.showMessageDialog(this, "Ok");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Mot de passe incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

}
