package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;

public class ScenarioTest {

//	public static void acheterProduit(Etal[] marche, String produit, int quantiteSouhaitee) {
//		int quantiteRestante = quantiteSouhaitee;
//		for (int i = 0; i < marche.length && quantiteRestante != 0; i++) {
//			Etal etal = marche[i];
//			int quantiteDisponible = etal.contientProduit(produit, quantiteRestante);
//			if (quantiteDisponible != 0) {
//				int prix = etal.acheterProduit(quantiteDisponible);
//				String chaineProduit = accorderNomProduit(produit, quantiteDisponible);
//				System.out.println("A l'étal n° " + (i + 1) + ", j'achete " + quantiteDisponible + " " + chaineProduit
//						+ " et je paye " + prix + " sous.");
//				quantiteRestante -= quantiteDisponible;
//			}
//		}
//		String chaineProduit = accorderNomProduit(produit, quantiteSouhaitee);
//		System.out.println("Je voulais " + quantiteSouhaitee + " " + chaineProduit + ", j'en ai acheté "
//				+ (quantiteSouhaitee - quantiteRestante) + ".");
//	}

	private static String accorderNomProduit(String produit, int quantiteSouhaitee) {
		String phraseProduit = produit;
		if (quantiteSouhaitee > 1) {
			phraseProduit = produit + "s";
		}
		return phraseProduit;
	}

	public static void main(String[] args) {

		Gaulois ordralphabetix = new Gaulois("Ordralphabetix", 9);
		Gaulois obelix = new Gaulois("Obelix", 20);
		Gaulois asterix = new Gaulois("Asterix", 6);

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		IEtal[] marche = new IEtal[3];
		Etal<Sanglier> etalSanglier1 = new Etal<>();
		Etal<Sanglier> etalSanglier2 = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();
		marche[0] = etalSanglier1;
		marche[1] = etalSanglier2;
		marche[2] = etalPoisson;

		etalSanglier1.installerVendeur(obelix, sangliersObelix, 8);
		etalSanglier2.installerVendeur(asterix, sangliersAsterix, 10);
		etalPoisson.installerVendeur(ordralphabetix, poissons, 7);

		for (int i = 0; i < 3; i++) {
			System.out.println(marche[i].etatEtal());
		}
		int quantiteSouhaite = 3;
		int quantiteDispo = 0;
		int quantiteAcheter = 0;
		int prixPaye = 0;
		for (int i = 0; i < 3 && quantiteAcheter < 3; i++) {
			quantiteDispo = marche[i].contientProduit("sanglier", quantiteSouhaite);
			prixPaye = marche[i].acheterProduit(quantiteDispo);
			System.out.println("A l'étal n°" + (i + 1) + ",j'achète " + quantiteDispo + " sangliers et je paye "
					+ prixPaye + " sous.");
			quantiteAcheter += quantiteDispo;
			quantiteSouhaite -= quantiteDispo;

		}

		for (int i = 0; i < 3; i++) {
			System.out.println(marche[i].etatEtal());
		}
	}

}