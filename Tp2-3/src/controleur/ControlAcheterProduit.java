package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public Gaulois[] rechercherVendeurProduit (String produit) {
		Gaulois[] commercant = village.rechercherVendeursProduit(produit);
		return commercant;
	}
	public int acheterProduit(String nomVendeur, int quantiteAcheter) {
	    Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);

	    if (etal != null) { 
	        return etal.acheterProduit(quantiteAcheter);
	        
	    }
	    return 0; 
	}
	
	public boolean verifierIdentite(String nomAcheteur) {
	    return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	
}