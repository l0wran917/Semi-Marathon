package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import modele.Semi_Marathon;

public class VueModifInfos extends JPanel implements ActionListener{

	private JButton valider;
	
	private JTextField lieu;
	private JTextField date;
	private JTextField distance;
	private JTextField coureurMax;
	
	private Semi_Marathon semiMarathon;
	
	public VueModifInfos(Semi_Marathon semiMarathon)
	{
		// 410, 275
		this.setLayout(new BorderLayout());
	
		this.semiMarathon = semiMarathon;
		
		valider = new JButton("Valider");
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(4,2));
		
		MaskFormatter masqueDate = null;
		try {
			masqueDate = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lieu = new JTextField();
		date = new JFormattedTextField(masqueDate);
		distance = new JTextField();
		coureurMax = new JTextField();
		
		lieu.setText(semiMarathon.getVille());
		date.setText(semiMarathon.getDate());
		distance.setText(semiMarathon.getDistance());
		coureurMax.setText(semiMarathon.getNbMaxCoureur());
		
		pnlCenter.add(new JLabel("Lieu :", SwingConstants.CENTER));
		pnlCenter.add(lieu);
		
		pnlCenter.add(new JLabel("Date :", SwingConstants.CENTER));
		pnlCenter.add(date);
		
		pnlCenter.add(new JLabel("Distance :", SwingConstants.CENTER));
		pnlCenter.add(distance);
		
		pnlCenter.add(new JLabel("Nombre coureur max :", SwingConstants.CENTER));
		pnlCenter.add(coureurMax);
		
		
		this.add(pnlCenter, BorderLayout.CENTER);
		this.add(valider, BorderLayout.SOUTH);
		this.add(new JLabel("  "), BorderLayout.EAST);
		this.add(new JLabel("  "), BorderLayout.NORTH);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
}
