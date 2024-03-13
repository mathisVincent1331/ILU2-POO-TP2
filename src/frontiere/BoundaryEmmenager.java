package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder force = new StringBuilder();
					force.append("Bienvenue villageois ");
					force.append(nomVisiteur+"\n");
					force.append("Quelle est votre force ?\n");
					int forceGaulois = Clavier.entrerEntier(force.toString());
					
					controlEmmenager.ajouterGaulois(nomVisiteur, forceGaulois);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		//TODO a completer
		StringBuilder forceDruide = new StringBuilder();
		forceDruide.append("Bienvenue druide ");
		forceDruide.append(nomVisiteur+"\n");
		forceDruide.append("Quelle est votre force ?\n");
		
		int scanDruide = Clavier.entrerEntier(forceDruide.toString());
		
		int potionMin=0;
		int potionMax=0;
		
		do {
			String messagePMin = "Quelle est la force de la plus faible que vous produisez ?";
			potionMin = Clavier.entrerEntier(messagePMin);
			
			String messagePMax ="Quelle est la force de la plus faible que vous produisez ?";
			potionMax = Clavier.entrerEntier(messagePMax);
			
			if (potionMax < potionMin) {
				System.out.println("Attention druide, vous vous êtes"
						+" trompé entre le minimum et le maximum.");
			}
			
		} while (potionMax < potionMin);
		controlEmmenager.ajouterDruide(nomVisiteur, scanDruide, scanDruide, scanDruide);
	}
}
