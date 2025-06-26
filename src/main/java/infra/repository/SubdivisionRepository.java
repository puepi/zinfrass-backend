package infra.repository;

import infra.model.Subdivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubdivisionRepository extends JpaRepository<Subdivision,Long> {
    Optional<Subdivision> findByNomIgnoreCase(String name);
}
