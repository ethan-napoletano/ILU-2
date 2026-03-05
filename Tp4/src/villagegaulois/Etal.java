package villagegaulois;

import personnages.Gaulois;
import produit.Produit;

public class Etal<P extends Produit> implements IEtal {
	private Gaulois gauloisVendeur;
	private P[] produits;
	private int nbProduit;
	private int prix;
	private boolean etalOccupe = false;

	@Override
	public Gaulois getVendeur() {
		return gauloisVendeur;
	}

	public void installerVendeur(Gaulois vendeur, P[] produit, int prix) {
		this.gauloisVendeur = vendeur;
		this.prix = prix;
		this.nbProduit = produit.length;
		this.produits = produit;
		etalOccupe = true;
	}

	public boolean isEtalOccupe() {
		return etalOccupe;
	}

	@Override
	public int contientProduit(String produit, int quantiteSouhaitee) {
		int quantiteVendre = 0;
		if (nbProduit != 0 && this.produits[0].getNom().equals(produit)) {
			if (nbProduit >= quantiteSouhaitee) {
				quantiteVendre = quantiteSouhaitee;
			} else {
				quantiteVendre = nbProduit;
			}
		}
		return quantiteVendre;
	}

	@Override
	public int acheterProduit(int quantiteSouhaite) {
		int cout = 0;
		for (int i = nbProduit - 1; i > nbProduit - quantiteSouhaite - 1 || i > 1; i--) {
			cout += produits[i].calculerPrix(prix); // question 3.d
		}
		if (nbProduit >= quantiteSouhaite) {
			nbProduit -= quantiteSouhaite;
		} else {
			nbProduit = 0;
		}
		return cout;
	}

	/**
	 * 
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'�tal est occup� [1] : nom du vendeur [2] : produit
	 *         vendu [2] : quantit� de produit � vendre au d�but du march� [4] :
	 *         quantit� de produit vendu
	 */
	@Override
	public String etatEtal() {
		StringBuilder phrase = new StringBuilder(gauloisVendeur.getNom());
		if (nbProduit > 0) {
			phrase.append(" vend ");
			phrase.append(nbProduit + " produits :");
			for (int i = 0; i < nbProduit; i++) {
				phrase.append("\n- " + produits[i].decrireProduit());
			}
		} else {
			phrase.append(" n'a plus rien à vendre.");
		}
		phrase.append("\n");
		return phrase.toString();
	}

}