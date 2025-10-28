package infra.repository;

import infra.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<Incident,Long> {

    Incident findByNroIncident(String nroIncident);

    @Query("SELECT COUNT(i) FROM Incident i WHERE i.resolu='non'")
    long countUnresolvedIncidents();

    Long countByResolu(String resolu);
}
