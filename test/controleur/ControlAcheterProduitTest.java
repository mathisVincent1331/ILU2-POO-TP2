package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Gaulois obelix;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		obelix = new Gaulois("Obelix", 10);
		village = new Village("le village des irr�ductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testControlAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertNotNull(controlAcheterProduit, "Constructeur ne renvoie pas null");
	}

	@Test
	void testAcheterProduit() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);

		controlEmmenager.ajouterGaulois("obelix", 12);
		controlPrendreEtal.prendreEtal("obelix", "menhirs", 8);
		
		assertEquals(3, controlAcheterProduit.acheterProduit("obelix", 3));
		assertEquals(5, controlAcheterProduit.acheterProduit("obelix", 12));
		assertEquals(-1, controlAcheterProduit.acheterProduit("n'existe pas", 4));
		
	}

	@Test
	void testTrouverMarchand() {
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);

		controlEmmenager.ajouterGaulois("obelix", 12);
		controlPrendreEtal.prendreEtal("obelix", "menhirs", 8);
		
		assertNotNull(controlAcheterProduit.trouverMarchand("menhirs"));
		assertNull(controlAcheterProduit.trouverMarchand("rien"));
	}

}
