package src.modele;

public class Partenaire {
	
	private String nom;
	private String email;
	
	public Partenaire(String nom, String email)
	{
		this.nom = nom;
		this.email = email;
	}
	
	public String getNom() 
	{ return nom; }
	
	public String getEmail() 
	{ return email; }
	

}
