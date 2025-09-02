package infra.repository;

import infra.model.Responsabilisation;
import infra.model.ResponsabilisationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResponsabilisationRepository extends JpaRepository<Responsabilisation, ResponsabilisationId> {
    Optional<Responsabilisation> findByStructureIdAndPosteIdAndActifTrue(Long structureId, Long posteId);
    List<Responsabilisation> findAllByActifTrue();
}
