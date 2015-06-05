package modele;

import java.util.Date;

@SuppressWarnings("unused")
public class Tarif {

	private Date dateDebut;
	private Date dateFin;
	private float prix;
	
	public Tarif(Date dateDebut, Date dateFin, float prix)
	{
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
	}
	
}
