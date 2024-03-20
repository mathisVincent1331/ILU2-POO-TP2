package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		StringBuilder message = new StringBuilder();
		
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			message.append("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !\n");
		} else {
			String[] donneesEtal;
			
			donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			String etalOccupe = donneesEtal[0];
			
			if (etalOccupe.equals("true")) {
				message.append("Vous avez vendu ");
				message.append(donneesEtal[4]);
				message.append(" sur ");
				message.append(donneesEtal[3]+" ");
				message.append(donneesEtal[2]);
				message.append(" \n");
				
				message.append("Au revoir ");
				message.append(nomVendeur);
				message.append(" passez une bonne journée.\n");

			}
		}
		System.out.println(message);
	}

}
