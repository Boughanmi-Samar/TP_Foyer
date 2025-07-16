package tn.esprit.tpfoyer.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("test")

public class BlocRepositoryTest {

    @Autowired
    BlocRepository blocRepository;

    @Test
    public void testFindByCapaciteGreaterThan() {
        Bloc bloc = new Bloc();
        bloc.setNomBloc("BlocTest");
        bloc.setCapaciteBloc(100);
        blocRepository.save(bloc);

        List<Bloc> results = blocRepository.findAllByCapaciteBlocGreaterThan(50);
        assertThat(results).isNotEmpty();
        assertThat(results.get(0).getNomBloc()).isEqualTo("BlocTest");
    }
}

