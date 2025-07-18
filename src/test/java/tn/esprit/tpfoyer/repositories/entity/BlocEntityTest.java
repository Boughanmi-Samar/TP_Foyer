package tn.esprit.tpfoyer.repositories.entity;

import org.junit.jupiter.api.Test;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Foyer;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class BlocEntityTest {

    @Test
    public void testGettersAndSetters() {
        Bloc bloc = new Bloc();
        bloc.setIdBloc(1L);
        bloc.setNomBloc("Bloc A");
        bloc.setCapaciteBloc(50L);

        assertEquals(1L, bloc.getIdBloc());
        assertEquals("Bloc A", bloc.getNomBloc());
        assertEquals(50L, bloc.getCapaciteBloc());
    }

    @Test
    public void testSetAndGetFoyer() {
        Bloc bloc = new Bloc();
        Foyer foyer = new Foyer();
        foyer.setIdFoyer(1L);
        foyer.setNomFoyer("Foyer Central");

        bloc.setFoyer(foyer);

        assertNotNull(bloc.getFoyer());
        assertEquals("Foyer Central", bloc.getFoyer().getNomFoyer());
    }

    @Test
    public void testSetAndGetChambres() {
        Bloc bloc = new Bloc();
        Chambre chambre1 = new Chambre();
        chambre1.setIdChambre(1L);

        Chambre chambre2 = new Chambre();
        chambre2.setIdChambre(2L);

        Set<Chambre> chambres = new HashSet<>();
        chambres.add(chambre1);
        chambres.add(chambre2);

        bloc.setChambres(chambres);

        assertEquals(2, bloc.getChambres().size());
    }

    @Test
    public void testToStringContainsNomBloc() {
        Bloc bloc = new Bloc();
        bloc.setNomBloc("Bloc Test");
        String str = bloc.toString();
        assertTrue(str.contains("Bloc Test"));
    }
}
