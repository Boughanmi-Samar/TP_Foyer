package tn.esprit.tpfoyer.repositories.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FoyerRepositoryTest {

    @Autowired
    private FoyerRepository foyerRepository;

    @Test
    public void testSaveFoyer() {
        Foyer foyer = new Foyer();
        foyer.setNomFoyer("Foyer El Ghazala");
        foyer.setCapaciteFoyer(200);

        Foyer savedFoyer = foyerRepository.save(foyer);

        assertThat(savedFoyer.getIdFoyer()).isNotNull();
        assertThat(savedFoyer.getNomFoyer()).isEqualTo("Foyer El Ghazala");
        assertThat(savedFoyer.getCapaciteFoyer()).isEqualTo(200);
    }
}