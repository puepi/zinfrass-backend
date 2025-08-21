package infra.repository;

import infra.model.Structure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StructureRepository extends JpaRepository<Structure,Long> {
    List<Structure> findByNomContainingIgnoreCase(String name);
}
