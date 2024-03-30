package controleur;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Gaulois obelix;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		obelix = new Gaulois("obelix", 10);
		village = new Village("le village des irr�ductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		controlAfficherVillage.donnerNomsVillageois();
		//pas de vérification
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		
		assertEquals("le village des irr�ductibles", controlAfficherVillage.donnerNomVillage());
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		
		assertEquals(1, controlAfficherVillage.donnerNbEtals());
		
	}

}
