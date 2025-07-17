package tn.esprit.tpfoyer.repositories.entity;

import org.junit.jupiter.api.Test;
import tn.esprit.tpfoyer.entity.Universite;

import static org.junit.jupiter.api.Assertions.*;

public class UniversiteEntityTest {

    @Test
    public void testGettersAndSetters() {
        Universite u = new Universite();
        u.setIdUniversite(1L);
        u.setNomUniversite("ESPRIT");
        u.setAdresse("Ariana");

        assertEquals(1L, u.getIdUniversite());
        assertEquals("ESPRIT", u.getNomUniversite());
        assertEquals("Ariana", u.getAdresse());
    }

    @Test
    public void testToString() {
        Universite u = new Universite();
        u.setIdUniversite(1L);
        u.setNomUniversite("ENIS");
        u.setAdresse("Sfax");

        String expected = "Universite(idUniversite=1, nomUniversite=ENIS, adresse=Sfax, foyer=null)";
        assertTrue(u.toString().contains("ENIS"));
    }
}
