package infra.repository;

import infra.model.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement,Long>{
    List<Equipement> findByLotId(Long idLot);
    List<Equipement> findByCurrentPosition(String position);

    @Query("""
            select distinct e from Equipement e
            left join fetch e.lot l
            left join fetch l.typeEquipement t
            left join  fetch e.interventions i
            left join fetch e.incidents  inc
            left join fetch l.images img
            """)
    List<Equipement> findAllWithDetails();
}
