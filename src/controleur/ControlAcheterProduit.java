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

	
	public int acheterProduit(String nomVendeur, int quantite){
		if (controlVerifierIdentite.verifierIdentite(nomVendeur)){
			Etal etalVendeur = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
			return etalVendeur.acheterProduit(quantite);
		}
		System.out.println("Je suis désolé "+
				nomVendeur+" mais il faut être un habitant de notre village pour commercer ici.\n");
		return -1;
	}
	
	public Gaulois[] trouverMarchand(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
}
