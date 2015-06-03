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

public class VueModifInfos extends JPanel implements ActionListener{

	private JButton valider;
	
	private JTextField lieu;
	private JTextField date;
	private JTextField distance;
	private JTextField coureurMax;
	
	public VueModifInfos()
	{
		this.setLayout(new BorderLayout());
		
		valider = new JButton("Valider");
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(4,2));
		
		lieu = new JTextField();
		date = new JTextField();
		distance = new JTextField();
		coureurMax = new JTextField();
		
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
