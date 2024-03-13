package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		//TODO a completer
		StringBuilder message = new StringBuilder();		
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			message.append("Je suis désolé, ");
			message.append(nomVendeur);
			message.append(" mais il faut être un habitant de notre village pour commercer ici.\n");
		} else {
			message.append("Bonjour "+nomVendeur+", je vais regarder si je peux trouver un étal\n");
						
			if (!controlPrendreEtal.resteEtals()) {
				message.append("Désolé ");
				message.append(nomVendeur);
				message.append("je n'ai plus d'étal qui ne soit pas déjà occupé.\n");
			} else {
				installerVendeur(nomVendeur);
			}
		}
		System.out.println(message);
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
		StringBuilder demande = new StringBuilder();
		demande.append("C'est parfait, il me reste un étal pour vous !\n");
		demande.append("Il me faudrait quelques renseignements\n");
		demande.append("Quel produit souhaitez vous vendre ?\n");
		System.out.println(demande);
		String produitVendu = scan.next();
		
		int QuantiteVendre = Clavier.entrerEntier("Combien souhaitez vous en vendre?");
		
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produitVendu, QuantiteVendre);
		
		if (numEtal != -1) {
			System.out.println("Le vendeur "+nomVendeur+" s'est installé à l'étal n°"+numEtal);
		}
	}
}
