package tn.esprit.tpfoyer.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BlocRepositoryTest {

    @Autowired
    private BlocRepository blocRepository;

    @Test
    public void testFindBlocsWithCapaciteGreaterThan50() {
        // Given
        Bloc b1 = new Bloc();
        b1.setNomBloc("BlocTest1");
        b1.setCapaciteBloc(60);
        blocRepository.save(b1);

        Bloc b2 = new Bloc();
        b2.setNomBloc("BlocTest2");
        b2.setCapaciteBloc(40);
        blocRepository.save(b2);

        // When
        List<Bloc> result = blocRepository.findAllByCapaciteBlocGreaterThan(50);

        // Then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getNomBloc()).isEqualTo("BlocTest1");
    }
}
