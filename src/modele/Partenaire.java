package modele;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Partenaire {
	
	private String nom;
	private String email;
	private BufferedImage image;
	
	public Partenaire(String nom, String email)
	{
		this.nom = nom;
		this.email = email;
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
	
	public Partenaire(String nom, String email, BufferedImage image)
	{
		this.nom = nom;
		this.email = email;
		this.image = image;
	}
	
	public String getNom() 
	{ return nom; }
	
	public String getEmail() 
	{ return email; }
	
	public BufferedImage getImage()
	{ 
		return image;
	}
	

}
