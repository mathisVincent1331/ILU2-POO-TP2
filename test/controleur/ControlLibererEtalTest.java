package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Gaulois obelix;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		obelix = new Gaulois("obelix", 10);
		village = new Village("le village des irr�ductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal, "Constructeur ne renvoie pas null");

	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		
		controlEmmenager.ajouterGaulois("obelix", 12);
		controlPrendreEtal.prendreEtal("obelix", "menhirs", 8);
		
		assertTrue(controlLibererEtal.isVendeur(obelix.getNom()));
		assertFalse(controlLibererEtal.isVendeur("n'existe pas"));
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);

		controlEmmenager.ajouterGaulois("obelix", 12);
		controlPrendreEtal.prendreEtal("obelix", "menhirs", 8);
		
		assertNotNull(controlLibererEtal.libererEtal(obelix.getNom()));
		assertNull(controlLibererEtal.libererEtal("n'existe pas"));
	}

}
