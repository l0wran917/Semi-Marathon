package modele;

public class Rue {
	
	private String nom;
	private int numOrdre;
	private PointControle pointControle; // 0..1
	
	public Rue(String nom, int numOrdre, PointControle pointControle) // Avec un point de controle
	{
		this.nom = nom;
		this.numOrdre = numOrdre;
		this.pointControle = pointControle;
	}
	
	
	public Rue(String nom, int numOrdre) // Sans point de controle
	{
		this.nom = nom;
		this.numOrdre = numOrdre;
	}


	public String getNom() {
		return nom;
	}

	public int getNumOrdre() {
		return numOrdre;
	}

	public PointControle getPointControle() {
		return pointControle;
	}
	
	
	
}
