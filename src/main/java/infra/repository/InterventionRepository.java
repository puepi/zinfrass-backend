package infra.repository;

import infra.model.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InterventionRepository extends JpaRepository<Intervention,Long> {
    @Query("select count(i) from Intervention i")
    Long countAllInterventions();
}
