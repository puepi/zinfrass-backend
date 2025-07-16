package infra.repository;

import infra.dto.response.SubdivisionResponseDto;
import infra.enums.TypeSubdivision;
import infra.model.Subdivision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubdivisionRepository extends JpaRepository<Subdivision,Long> {
    Optional<Subdivision> findByNomIgnoreCase(String name);

    List<Subdivision> findByTypeAndParentId(TypeSubdivision type, Long parentId);

    List<Subdivision> findByParentId(Long id);

    List<Subdivision> findByNomContainingIgnoreCase(String name);
}
