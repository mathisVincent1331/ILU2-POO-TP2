package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infoMarche = controlAfficherMarche.donnerInfosMarche();
		
		if (infoMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard !\n");
		} else {
			
			System.out.println(nomAcheteur + " vous trouverez,au marché :\n");
			for (int i=0; i < infoMarche.length; i++){
				StringBuilder infoMarchand = new StringBuilder();
				
				infoMarchand.append("- ");
				infoMarchand.append(infoMarche[i]);
				i++;
				infoMarchand.append(" qui vend ");
				infoMarchand.append(infoMarche[i]+" ");
				i++;
				infoMarchand.append(infoMarche[i]);
				
				System.out.println(infoMarchand);
			}
		}
	}
}
