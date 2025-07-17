package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long>
{
    List<Foyer> findAllByCapaciteFoyerGreaterThan(long capaciteFoyer);

}
