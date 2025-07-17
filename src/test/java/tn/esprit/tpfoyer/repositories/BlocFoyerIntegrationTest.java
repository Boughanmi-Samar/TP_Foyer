package tn.esprit.tpfoyer.repositories;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional // pour rollback à la fin du test
public class BlocFoyerIntegrationTest {

    @Autowired
    private FoyerRepository foyerRepository;

    @Autowired
    private BlocRepository blocRepository;

    @Test
    public void testAjouterBlocAvecFoyer() {
        // Créer et enregistrer un foyer
        Foyer foyer = new Foyer();
        foyer.setNomFoyer("Foyer Intégration");
        foyer.setCapaciteFoyer(1000);
        foyer = foyerRepository.save(foyer);

        // Créer un bloc et l’associer au foyer
        Bloc bloc = new Bloc();
        bloc.setNomBloc("Bloc A");
        bloc.setCapaciteBloc(200);
        bloc.setFoyer(foyer);
        bloc = blocRepository.save(bloc);

        // Récupérer le bloc depuis la BD
        Bloc blocTrouve = blocRepository.findById(bloc.getIdBloc()).orElse(null);

        // Assertions
        assertThat(blocTrouve).isNotNull();
        assertThat(blocTrouve.getFoyer()).isNotNull();
        assertThat(blocTrouve.getFoyer().getNomFoyer()).isEqualTo("Foyer Intégration");
    }
}
