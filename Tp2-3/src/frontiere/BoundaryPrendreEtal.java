package frontiere;

import controleur.ControlPrendreEtal;


public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolé " + nomVendeur + ", mais il faut être un habitant du village pour commercer ici.");
			return;
		}
		else {
			System.out.println("Bonjour " + nomVendeur + " ,je vais regarder si je peux trouver un étal.");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolé"+ nomVendeur+ "je n'ai plus d'étal qui ne soit pas déja occupé.");
				
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me rete un étal pour vous !");
		System.out.println("Il me faudrait quelques renseignements :");
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
		int quantite = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, quantite);
		
		if(numEtal != -1) {
			System.out.println("Le vendeur "+ nomVendeur+ "s'est installé a l'étal n°"+numEtal);
			
		}
		else {
			System.out.println("erreur lors de l'installation");
		}
	}
}
