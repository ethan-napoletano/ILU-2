package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegaulois.IVillage;

public class Scenario {

	public static void main(String[] args) {

		IVillage village = new IVillage() {
			private IEtal[] etals = new Etal[100];
			int nbEtalOccupe = 0;

			@Override
			public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
				if (nbEtalOccupe < 100) {
					etals[nbEtalOccupe] = etal;
					etal.installerVendeur(vendeur, produit, prix);
					nbEtalOccupe++;
					return true;
				}
				return false;
			}

			@Override
			public void acheterProduit(String produit, int quantiteSouhaitee) {
			    int quantiteInitiale = quantiteSouhaitee;
			    int quantiteAchetee = 0;

			    for (int i = 0; i < nbEtalOccupe; i++) {
			        int quantiteDispo = etals[i].contientProduit(produit, quantiteSouhaitee);
			        if (quantiteDispo != 0) {
			            int cout = etals[i].acheterProduit(quantiteDispo);
			            quantiteSouhaitee -= quantiteDispo;
			            quantiteAchetee += quantiteDispo;
			            System.out.println("A l'étal n° " + (i + 1) + ", j'achète " + quantiteDispo + " " + produit 
			                               + (quantiteDispo > 1 ? "s" : "") + " et je paye " + cout + " sous.");
			        }
			    }
			    
			    System.out.println("Je voulais " + quantiteInitiale + " " + produit + (quantiteInitiale > 1 ? "s" : "")
			                       + ", j'en ai acheté " + quantiteAchetee + ".\n");
			}


			@Override
			public void afficherVillage() {
				for (int i = 0; i < nbEtalOccupe; i++) {
					System.out.println(etals[i].etatEtal());
				}
			}
		};

		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		village.afficherVillage();

		village.acheterProduit("sanglier", 3);

		village.afficherVillage();
	}

}