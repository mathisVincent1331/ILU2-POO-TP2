package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Gaulois obelix;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		obelix = new Gaulois("Obelix", 10);
		village = new Village("le village des irr�ductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		
		controlEmmenager.ajouterGaulois("obelix", 12);
		assertTrue(controlPrendreEtal.resteEtals());
		
		controlPrendreEtal.prendreEtal("obelix", "mehnirs", 8);
		assertFalse(controlPrendreEtal.resteEtals());
		
	}

	@Test
	void testPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);

		controlEmmenager.ajouterGaulois("obelix", 12);
		
		assertEquals(0, controlPrendreEtal.prendreEtal("obelix", "menhirs", 8));
		assertEquals(-1, controlPrendreEtal.prendreEtal("exite pas", "menhirs", 8));
		
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		Druide druide = new Druide("Panoramix", 4, 3, 8);
		
		controlEmmenager.ajouterGaulois("Obelix", 12);
		controlEmmenager.ajouterDruide("Panoramix", 3, 3, 7);
		
		assertTrue(controlPrendreEtal.verifierIdentite(obelix.getNom()));
		assertFalse(controlPrendreEtal.verifierIdentite("n'existe pas"));
		assertTrue(controlPrendreEtal.verifierIdentite(druide.getNom()));
		assertTrue(controlPrendreEtal.verifierIdentite(abraracourcix.getNom()));
	}

}
