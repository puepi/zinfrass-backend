package infra.repository;

import infra.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<Incident,Long> {

    Incident findByNroIncident(String nroIncident);
}
