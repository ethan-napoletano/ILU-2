package produit;

public abstract class Produit implements IProduit{

	private String nom;
	protected Unite unite;

	protected Produit(String nom, Unite unite) {
		super();
		this.nom = nom;
		this.unite = unite;
	}

	@Override
	public String getNom() {
		return nom;
	}

	public abstract String decrireProduit();
}