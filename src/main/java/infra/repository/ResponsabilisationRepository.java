package infra.repository;

import infra.model.Responsabilisation;
import infra.model.ResponsabilisationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsabilisationRepository extends JpaRepository<Responsabilisation, ResponsabilisationId> {
}
