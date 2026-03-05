package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private Marche marche;
	
	public Village(String nom, int nbVillageoisMaximum, int nbEtalsMarche) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
		this.marche = new Marche(nbEtalsMarche); 
	}

	
	private static class Marche {
	        private Etal[] etals;  
	        
	        private Marche(int nombreEtals) {
	            this.etals = new Etal[nombreEtals];
	            for (int i = 0; i < nombreEtals; i++) {
	                etals[i] = new Etal();  
	            }
	        }
	        private void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
	            if (indiceEtal < 0 || indiceEtal >= etals.length) {
	                System.out.println("Indice d etal invalide : " + indiceEtal);
	                return;
	            }

	            Etal etal = etals[indiceEtal];

	            
	            if (etal.isEtalOccupe()) {
	                System.out.println("etal " + indiceEtal + " est deja occupé");
	                return;
	            }

	            etal.occuperEtal(vendeur, produit, nbProduit);
	        }
	        private int trouverEtalLibre() {
	        	for(int i=0;i<etals.length;i++) {
	        		if(!etals[i].isEtalOccupe()) {
	        			return i;
	        		}
	        		
	        	}
	        	return -1;
	        }
	        private Etal[] trouverEtals(String produit) {
	            int compteur = 0;
	            for (int i = 0; i < etals.length; i++) {
	                Etal etal = etals[i];
	                if (etal.isEtalOccupe() && etal.contientProduit(produit)) {
	                    compteur++;
	                }
	            }

	            Etal[] etalsProduit = new Etal[compteur];
	            int ind = 0;
	            for (int i = 0; i < etals.length; i++) {
	                Etal etal = etals[i];
	                if (etal.isEtalOccupe() && etal.contientProduit(produit)) {
	                    etalsProduit[ind++] = etal;
	                }
	            }

	            return etalsProduit;
	        }

	        private Etal trouverVendeur(Gaulois gaulois) {
	        	for (int i=0;i<etals.length;i++) {
	        		Etal etal = etals[i];
	        		if (etal.isEtalOccupe() && etal.getVendeur()==gaulois) {
	        			return etal;
	        		}
	            }
	        	return null;
	        }
	        private void afficherMarche() {
	        	int nbEtalVide = 0;
	        	for(int i=0;i<etals.length;i++) {
	        		if(!etals[i].isEtalOccupe()) {
	        			nbEtalVide = nbEtalVide+1;
	        		}
	        		else {
	        			etals[i].afficherEtal();
	        		}
	        		
	        	}
	        	System.out.println("Il reste " + nbEtalVide + " étals non utilisés dans le marché.\n");
	        }
	 }
	        
	 
	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les lÃ©gendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	public String installerVendeur(Gaulois vendeur, String produit, int nbProduit) {
	    StringBuilder chaine = new StringBuilder();
	    chaine.append(vendeur.getNom() + " cherche un endroit pour vendre " + nbProduit + " " + produit + ".\n");

	    int indiceEtalLibre = marche.trouverEtalLibre();
	    if (indiceEtalLibre != -1) {
	        marche.utiliserEtal(indiceEtalLibre, vendeur, produit, nbProduit);
	        chaine.append("Le vendeur " + vendeur.getNom() + " vend des " + produit + " à l'étal n°" + indiceEtalLibre + ".\n");
	    } else {
	        chaine.append("Malheureusement, il n'y a plus d'étals libres pour " + vendeur.getNom() + " !\n");
	    }

	    return chaine.toString();
	}
	public String rechercherVendeursProduit(String produit) {
		StringBuilder chaine = new StringBuilder();
		Etal etals[]=marche.trouverEtals(produit);
		if(etals.length == 0) {
			chaine.append("Il n'y a pas de vendeur qui propose des "+ produit+" au marché");
		}
		else if(etals.length == 1) {
			chaine.append("Seul le vendeur"+ etals[0] +" propose des "+ produit +" au marché");
		}
		else {
			chaine.append("Les vendeurs qui proposent des "+ produit +" sont :/n");
			for(int i=0;i<etals.length;i++) {
				chaine.append("- "+ etals[i].getVendeur());
			}
		}
		return chaine.toString();
		
		
	}

}