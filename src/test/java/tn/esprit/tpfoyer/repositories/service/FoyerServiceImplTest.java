package tn.esprit.tpfoyer.repositories.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;
import tn.esprit.tpfoyer.service.FoyerServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FoyerServiceImplTest {

    @Mock
    FoyerRepository foyerRepository;

    @InjectMocks
    FoyerServiceImpl foyerService;

    public FoyerServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRetrieveAllFoyers() {
        Foyer f1 = new Foyer(null, "A", 100, null, null);
        Foyer f2 = new Foyer(null, "B", 200, null, null);

        when(foyerRepository.findAll()).thenReturn(Arrays.asList(f1, f2));

        List<Foyer> foyers = foyerService.retrieveAllFoyers();

        assertThat(foyers).hasSize(2);
        verify(foyerRepository).findAll();
    }

    @Test
    void testRetrieveFoyerById() {
        Foyer f = new Foyer(1L, "C", 300, null, null);
        when(foyerRepository.findById(1L)).thenReturn(Optional.of(f));

        Foyer result = foyerService.retrieveFoyer(1L);
        assertThat(result.getNomFoyer()).isEqualTo("C");
    }

    @Test
    void testAddFoyer() {
        Foyer f = new Foyer(null, "D", 400, null, null);
        when(foyerRepository.save(f)).thenReturn(f);

        Foyer result = foyerService.addFoyer(f);
        assertThat(result.getNomFoyer()).isEqualTo("D");
    }
}
