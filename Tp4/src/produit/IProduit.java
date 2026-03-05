package produit;

public interface IProduit<P extends Produit> {

	String getNom();
	int calculerPrix(int prix);

}