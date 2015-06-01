package modele;

public class Rue {
	
	private String nom;
	private int numOrdre;
	private PointControle pointControle; // 0..1
	
	public Rue(String nom, int numOrdre, PointControle pointControle)
	{
		this.nom = nom;
		this.numOrdre = numOrdre;
		this.pointControle = pointControle;
	}
	
	
}
