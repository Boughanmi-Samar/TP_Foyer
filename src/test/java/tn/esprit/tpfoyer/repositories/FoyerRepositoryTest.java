package tn.esprit.tpfoyer.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FoyerRepositoryTest {

    @Autowired
    FoyerRepository foyerRepository;

    /**
     * Cas 1 : persistance + findById
     */
    @Test
    void saveAndRetrieveFoyer() {
        // given
        Foyer foyer = new Foyer();
        foyer.setNomFoyer("Foyer Alpha");
        foyer.setCapaciteFoyer(300);

        // when
        Foyer saved = foyerRepository.save(foyer);
        Optional<Foyer> found = foyerRepository.findById(saved.getIdFoyer());

        // then
        assertThat(found).isPresent();
        assertThat(found.get().getNomFoyer()).isEqualTo("Foyer Alpha");
        assertThat(found.get().getCapaciteFoyer()).isEqualTo(300);
    }


    @Test
    void findByCapaciteFoyerGreaterThan() {
        // given
        Foyer petit = foyerRepository.save(new Foyer(null, "Petit Foyer", 50, null, null));
        Foyer grand = foyerRepository.save(new Foyer(null, "Grand Foyer", 500, null, null));

        // when
        List<Foyer> result = foyerRepository.findAllByCapaciteFoyerGreaterThan(100);

        // then
        assertThat(result)
                .extracting(Foyer::getNomFoyer)
                .contains("Grand Foyer")
                .doesNotContain("Petit Foyer");
    }
}
