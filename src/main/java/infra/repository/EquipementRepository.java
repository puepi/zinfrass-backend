package infra.repository;

import infra.model.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement,Long>{
    List<Equipement> findByLotId(Long idLot);
    List<Equipement> findByCurrentPosition(String position);
}
