package tn.esprit.tpfoyer.repositories.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.service.IBlocService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BlocServiceTest {

    @Autowired
    IBlocService blocService;

    @Test
    void testAddAndRetrieveBloc() {
        Bloc bloc = new Bloc();
        bloc.setNomBloc("BlocTest");
        bloc.setCapaciteBloc(100L);

        Bloc savedBloc = blocService.addBloc(bloc);
        assertThat(savedBloc.getIdBloc()).isNotNull();

        Bloc retrievedBloc = blocService.retrieveBloc(savedBloc.getIdBloc());
        assertThat(retrievedBloc.getNomBloc()).isEqualTo("BlocTest");
    }

    @Test
    void testModifyBloc() {
        Bloc bloc = new Bloc();
        bloc.setNomBloc("BlocMod");
        bloc.setCapaciteBloc(150);
        Bloc savedBloc = blocService.addBloc(bloc);

        savedBloc.setNomBloc("BlocModified");
        Bloc updated = blocService.modifyBloc(savedBloc);
        assertThat(updated.getNomBloc()).isEqualTo("BlocModified");
    }

    @Test
    void testRemoveBloc() {
        Bloc bloc = new Bloc();
        bloc.setNomBloc("BlocDelete");
        bloc.setCapaciteBloc(100);
        Bloc saved = blocService.addBloc(bloc);

        blocService.removeBloc(saved.getIdBloc());

        List<Bloc> all = blocService.retrieveAllBlocs();
        assertThat(all.stream().noneMatch(b -> b.getNomBloc().equals("BlocDelete"))).isTrue();
    }
}
