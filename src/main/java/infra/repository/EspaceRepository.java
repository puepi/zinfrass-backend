package infra.repository;

import infra.model.Espace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspaceRepository extends JpaRepository<Espace, Long> {
}
