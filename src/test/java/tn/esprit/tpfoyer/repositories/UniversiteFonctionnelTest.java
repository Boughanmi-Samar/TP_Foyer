package tn.esprit.tpfoyer.repositories;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.UniversiteRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class UniversiteFonctionnelTest {

    @Autowired
    UniversiteRepository universiteRepository;

    @Test
    void testAjouterUniversiteAvecFoyer() {
        // Créer un foyer
        Foyer foyer = new Foyer();
        foyer.setNomFoyer("Foyer National");
        foyer.setCapaciteFoyer(500);

        // Créer une université avec un foyer associé
        Universite universite = new Universite();
        universite.setNomUniversite("Université de Tunis");
        universite.setAdresse("Tunis Centre");
        universite.setFoyer(foyer); // association

        // Sauvegarder dans la base
        Universite saved = universiteRepository.save(universite);

        // Assertions
        assertThat(saved.getIdUniversite()).isPositive();
        assertThat(saved.getFoyer()).isNotNull();
        assertThat(saved.getFoyer().getNomFoyer()).isEqualTo("Foyer National");
    }
}
