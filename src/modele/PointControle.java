package modele;

import java.util.ArrayList;

public class PointControle {
	
	private float km;
	private Rue rue;
	private ArrayList<ChronometragePoint> chronos;
	
	public PointControle(float km, Rue rue, ArrayList<ChronometragePoint> chronos)
	{
		this.km = km;
		this.rue = rue;
		this.chronos = chronos;
	}

	public float getKm() {
		return km;
	}

	public Rue getRue() {
		return rue;
	}

	public ArrayList<ChronometragePoint> getChronos() {
		return chronos;
	}
	
	
	
}
