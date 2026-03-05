package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private int poids;
	private Gaulois gauloisChasseur;

	public Sanglier(int poids, Gaulois chasseur) {
		super("sanglier", Unite.KILOGRAMME);
		this.poids = poids;
		this.gauloisChasseur = chasseur;
	}

	@Override
	public String decrireProduit() {
		return "sanglier de " + poids + " " + unite + " chassé par " + gauloisChasseur.getNom();

	}

	@Override
	public int calculerPrix(int prix) {
		return (poids * prix) / 1000;
	}

}