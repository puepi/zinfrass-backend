package infra.repository;

import infra.model.Batiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatimentRepository extends JpaRepository<Batiment,Long> {
    List<Batiment> findBySubdivisionId(Long id);
    List<Batiment> findBySubdivisionNomContainingIgnoreCase(String name);
}
