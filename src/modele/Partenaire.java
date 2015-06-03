package modele;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Partenaire {
	
	private String nom;
	private String email;
	private JLabel logo;
	
	public Partenaire(String nom, String email, JLabel logo)
	{
		this.nom = nom;
		this.email = email;
		this.logo = logo;
		logo.setSize(20, 20);
	}

	
	/*public Partenaire(String nom, String email) throws IOException
	{
		this.nom = nom;
		this.email = email;
		try 
		{
		    image = ImageIO.read(new File("logoNull.jpg"));
		} 
		catch (IOException e) 
		{
			System.out.println("Erreur Chargement image");
		}
	}*/

	
	public String getNom() 
	{ return nom; }
	
	public String getEmail() 
	{ return email; }
	
	public JLabel getLogo()
	{ 
		return logo;
	}
	

}
