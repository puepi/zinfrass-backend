package infra.repository;

import infra.model.Batiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatimentRepository extends JpaRepository<Batiment,Long> {
}
