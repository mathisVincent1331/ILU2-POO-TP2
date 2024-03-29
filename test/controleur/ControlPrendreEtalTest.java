package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private ControlVerifierIdentite controlVerifierIdentite;
	private Village village;
	private Gaulois obelix;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		obelix = new Gaulois("Obelix", 10);
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		
		controlEmmenager.ajouterGaulois("obelix", 12);
		assertTrue(controlPrendreEtal.resteEtals());
		
		controlPrendreEtal.prendreEtal("obelix", "mehnirs", 8);
		assertFalse(controlPrendreEtal.resteEtals());
		
	}

	@Test
	void testPrendreEtal() {
		fail("Not yet implemented");
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		Druide druide = new Druide("Panoramix", 4, 3, 8);
		
		controlEmmenager.ajouterGaulois("Obelix", 12);
		controlEmmenager.ajouterDruide("Panoramix", 3, 3, 7);
		
		assertTrue(controlVerifierIdentite.verifierIdentite(obelix.getNom()));
		assertFalse(controlVerifierIdentite.verifierIdentite("n'existe pas"));
		assertTrue(controlVerifierIdentite.verifierIdentite(druide.getNom()));
		assertTrue(controlVerifierIdentite.verifierIdentite(abraracourcix.getNom()));
	}

}
